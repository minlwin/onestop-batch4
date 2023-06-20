package com.jdc.learners.domain.dto.form;

import lombok.Data;

@Data
public class StudentSignUpForm {

	public StudentSignUpForm() {
	}

	private String name;

	private String phone;

	private String email;

	private String password;

}