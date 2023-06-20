package com.jdc.learners.domain.dto;

import lombok.Data;

@Data
public class MemberProfileDto {

	public MemberProfileDto() {
	}

	private int id;

	private String name;

	private String phone;

	private String email;

	private String image;

}