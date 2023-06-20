package com.jdc.learners.domain.dto.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInForm {
	
	@NotBlank(message = "Please enter email for login.")
	private String email;
	
	@NotBlank(message = "Please enter password.")
	private String password;
	
	public UsernamePasswordAuthenticationToken authentication() {
		return new UsernamePasswordAuthenticationToken(email, password);
	}

}