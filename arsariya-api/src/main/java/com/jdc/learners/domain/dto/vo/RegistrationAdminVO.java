package com.jdc.learners.domain.dto.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.jdc.learners.domain.dto.MemberProfileDto;
import com.jdc.learners.domain.entity.Registration;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class RegistrationAdminVO {

	@NonNull
	private Integer id;

	@NonNull
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate registAt;

	@NonNull
	private Integer fees;

	@NonNull
	private Integer discount;

	private MemberProfileDto student;

	private CourseListVO course;

	private Integer paid;
	
	public static RegistrationAdminVO from(Registration entity) {
		var vo = new RegistrationAdminVO(entity.getId(), entity.getRegistAt(), entity.getFees(), entity.getDiscount());
		vo.setStudent(MemberProfileDto.from(entity.getStudent()));
		vo.setCourse(CourseListVO.from(entity.getCourse()));
		vo.setPaid(vo.getFees() - vo.getDiscount());
		return vo;
	}
}