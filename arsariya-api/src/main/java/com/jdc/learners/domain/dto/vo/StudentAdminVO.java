package com.jdc.learners.domain.dto.vo;

import lombok.Data;

@Data
public class StudentAdminVO {

	public StudentAdminVO() {
	}

	private int id;

	private String name;

	private String email;

	private String phone;

	private String registAt;

	private int courseCount;

	private int paid;

}