package com.jdc.learners.domain.dto.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentSignUpForm {
	
	@NotBlank(message = "Please enter student name.")
	private String name;

	@NotBlank(message = "Please enter phone number.")
	private String phone;

	@NotBlank(message = "Please enter email address.")
	private String email;

	@NotBlank(message = "Please enter password.")
	private String password;

}