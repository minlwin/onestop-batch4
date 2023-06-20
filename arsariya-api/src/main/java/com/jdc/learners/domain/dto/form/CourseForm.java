package com.jdc.learners.domain.dto.form;

import java.util.List;

import lombok.Data;

@Data
public class CourseForm {

	public CourseForm() {
	}

	private int id;

	private String name;

	private String category;

	private String description;

	private String image;

	private int hours;

	private int fees;

	private String teacher;

	private List<String> objectives;

}