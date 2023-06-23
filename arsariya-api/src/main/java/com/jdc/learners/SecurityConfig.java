package com.jdc.learners;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jdc.learners.security.AppUserDetailsService;
import com.jdc.learners.security.JwtTokenSecurityFilter;
import com.jdc.learners.utils.RestSecurityExceptionHandler;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@EnableMethodSecurity(prePostEnabled = true)
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
	AuthenticationProvider authenticationProvider(AppUserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
		var bean = new DaoAuthenticationProvider(passwordEncoder);
		bean.setUserDetailsService(userDetailsService);
		bean.setHideUserNotFoundExceptions(false);
		return bean;
	}
	
	@Bean
	SecurityFilterChain http(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(config -> {
			config.requestMatchers("/public/**", "/images/**").permitAll();
			config.requestMatchers("/admin/**").hasAuthority("Admin");
			config.requestMatchers("/teacher/**").hasAnyAuthority("Admin", "Teacher");
			config.requestMatchers("/member/**").hasAnyAuthority("Admin", "Teacher", "Student");
			config.requestMatchers("/student/**").hasAnyAuthority("Admin", "Student");
			config.anyRequest().denyAll();
		});
		
		http.cors(config -> {});
		
		http.csrf(config -> config.disable());
		
		http.sessionManagement(config -> config.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		// Add Jwt Token Security Filter before authentication token
		http.addFilterBefore(jwtTokenSecurityFilter, UsernamePasswordAuthenticationFilter.class);
		
		http.exceptionHandling(config -> {
			Optional.of(new RestSecurityExceptionHandler()).ifPresent(handler -> {
				config.authenticationEntryPoint(handler);
				config.accessDeniedHandler(handler);
			});
		});
		
		return http.build();
	}
}