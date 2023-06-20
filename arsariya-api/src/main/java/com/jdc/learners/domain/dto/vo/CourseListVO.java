package com.jdc.learners.domain.dto.vo;

import com.jdc.learners.domain.dto.MemberProfileDto;

import lombok.Data;

@Data
public class CourseListVO {

	public CourseListVO() {
	}

	private int id;

	private String name;

	private int fees;

	private int hours;

	private CategoryVO category;

	private MemberProfileDto teacher;

}