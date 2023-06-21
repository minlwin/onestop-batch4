package com.jdc.learners.utils;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class ValidationResultException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private List<String> messages;
	
	public ValidationResultException(BindingResult result) {
		messages = result.getFieldErrors().stream()
				.map(FieldError::getDefaultMessage).toList();
	}
	
	public List<String> getMessages() {
		return messages;
	}

}
