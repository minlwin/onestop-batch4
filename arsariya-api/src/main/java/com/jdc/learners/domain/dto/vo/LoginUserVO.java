package com.jdc.learners.domain.dto.vo;

import lombok.Data;

@Data
public class LoginUserVO {

	public LoginUserVO() {
	}

	private int id;

	private String name;

	private String email;

	private String role;

}