package com.jdc.learners.domain.dto;

import lombok.Data;

@Data
public class TeacherPaymentDto {

	public TeacherPaymentDto() {
	}

	private int id;

	private String email;

	private int type;

	private String accountName;

	private String accountNumber;

}