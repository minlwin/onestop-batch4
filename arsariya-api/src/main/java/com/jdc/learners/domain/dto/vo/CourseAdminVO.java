package com.jdc.learners.domain.dto.vo;

import java.time.LocalDateTime;

import com.jdc.learners.domain.dto.MemberProfileDto;

import lombok.Data;

@Data
public class CourseAdminVO {

	public CourseAdminVO() {
	}

	private int id;

	private String name;

	private int fees;

	private LocalDateTime createAt;

	private MemberProfileDto teacher;

	private int students;

	private int total;

	private int agentFees;

}