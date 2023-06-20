package com.jdc.learners.domain.dto.form;

import lombok.Data;

@Data
public class TeacherSignUpForm {

	private String name;

	private String email;

	private String password;
	
	public SignInForm signIn() {
		return new SignInForm(email, password);
	}

}