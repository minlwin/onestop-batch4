package com.jdc.learners.domain.dto.form;

import java.time.LocalDate;

import com.jdc.learners.domain.entity.Student;

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
	
	public SignInForm signIn() {
		return new SignInForm(email, password);
	}
		
	public Student entity() {
		var entity = new Student();
		entity.setName(name);
		entity.setEmail(email);
		entity.setPhone(phone);
		entity.setRegistAt(LocalDate.now());
		entity.setActivated(true);
		return entity;
	}

}