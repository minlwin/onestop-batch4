package com.jdc.learners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jdc.learners.security.JwtTokenSecurityFilter;

@Configuration
@EnableJpaAuditing
public class SecurityConfig {
	
	@Autowired
	private JwtTokenSecurityFilter jwtTokenSecurityFilter;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	@Bean
	SecurityFilterChain http(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(config -> {
			config.requestMatchers("/public/**").permitAll();
			config.requestMatchers("/admin/**").hasAuthority("Admin");
			config.requestMatchers("/teacher/**").hasAnyAuthority("Admin", "Teacher");
			config.requestMatchers("/member/**").hasAnyAuthority("Teacher", "Student");
			config.requestMatchers("/student/**").hasAuthority("Student");
			config.anyRequest().denyAll();
		});
		
		http.csrf(config -> config.disable());
		
		http.sessionManagement(config -> config.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		// Add Jwt Token Security Filter before authentication token
		http.addFilterBefore(jwtTokenSecurityFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
}