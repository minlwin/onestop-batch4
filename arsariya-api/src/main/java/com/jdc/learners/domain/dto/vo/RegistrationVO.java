package com.jdc.learners.domain.dto.vo;

import java.time.LocalDate;

import com.jdc.learners.domain.dto.TeacherPaymentDto;

import lombok.Data;

@Data
public class RegistrationVO {

	public RegistrationVO() {
	}

	private int id;

	private CourseListVO course;

	private LoginUserVO student;

	private LocalDate registAt;

	private TeacherPaymentDto payment;

	private int fees;

	private String promotionCode;

	private int discount;

}