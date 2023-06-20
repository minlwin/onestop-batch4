package com.jdc.learners.domain.dto.vo;

import java.time.LocalDateTime;

import com.jdc.learners.domain.dto.MemberProfileDto;

import lombok.Data;

@Data
public class CourseDetailsVO {

	public CourseDetailsVO() {
	}

	private int id;

	private String name;

	private int fees;

	private int hours;

	private CategoryVO category;

	private MemberProfileDto teacher;

	private String description;

	private int students;

	private LocalDateTime updateAt;

}