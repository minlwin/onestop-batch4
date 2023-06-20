package com.jdc.learners.domain.dto.form;

import java.time.LocalDate;

import com.jdc.learners.domain.entity.Teacher;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TeacherSignUpForm {

	@NotBlank(message = "Please enter student name.")
	private String name;

	@NotBlank(message = "Please enter email address.")
	private String email;

	@NotBlank(message = "Please enter password.")
	private String password;
	
	public SignInForm signIn() {
		return new SignInForm(email, password);
	}
	
	public Teacher entity() {
		var entity = new Teacher();
		entity.setName(name);
		entity.setEmail(email);
		entity.setRegistAt(LocalDate.now());
		entity.setActivated(true);
		return entity;
	}
	

}