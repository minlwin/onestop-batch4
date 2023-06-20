package com.jdc.learners.domain.dto.form;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseForm {

	private int id;

	@NotBlank(message = "Please enter course name.")
	private String name;

	@NotBlank(message = "Please enter category name.")
	private String category;

	private String description;

	private String image;

	private int hours;

	private int fees;

	private String teacher;

	private List<String> objectives;

}