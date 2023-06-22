package com.jdc.learners.domain.dto.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.jdc.learners.domain.entity.Student;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class StudentAdminVO {

	@NonNull
	private Integer id;

	@NonNull
	private String name;

	@NonNull
	private String email;

	@NonNull
	private String phone;

	@NonNull
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate registAt;

	private int courseCount;

	private int paid;
	
	public static StudentAdminVO from(Student entity) {
		var vo = new StudentAdminVO(entity.getId(), entity.getName(), entity.getEmail(), entity.getPhone(), entity.getRegistAt());
		vo.setCourseCount(entity.getRegistrations().size());
		vo.setPaid(entity.getRegistrations().stream().mapToInt(a -> a.getFees() - a.getDiscount()).sum());
		return vo;
	}

}