package com.jdc.learners.domain.dto.vo;

import java.time.LocalDate;

import com.jdc.learners.domain.dto.MemberProfileDto;

import lombok.Data;

@Data
public class RegistrationAdminVO {

	public RegistrationAdminVO() {
	}

	private int id;

	private MemberProfileDto student;

	private CourseListVO course;

	private LocalDate registAt;

	private int fees;

	private int discount;

	private int paid;

}