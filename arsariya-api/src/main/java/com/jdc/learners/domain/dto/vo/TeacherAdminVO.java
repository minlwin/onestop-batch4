package com.jdc.learners.domain.dto.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TeacherAdminVO {

	public TeacherAdminVO() {
	}

	private int id;

	private String name;

	private String email;

	private String phone;

	private LocalDate registAt;

	private long courseCount;

	private long totalFees;

	private long agentFees;

	private long netAward;

}