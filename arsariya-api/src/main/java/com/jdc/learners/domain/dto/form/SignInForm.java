package com.jdc.learners.domain.dto.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInForm {

	private String email;
	private String password;
	
	public UsernamePasswordAuthenticationToken authentication() {
		return new UsernamePasswordAuthenticationToken(email, password);
	}

}