package com.jdc.learners.domain.dto.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.jdc.learners.domain.dto.PaymentTypeDto;
import com.jdc.learners.domain.entity.Registration;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class RegistrationVO {

	@NonNull
	private Integer id;

	@NonNull
	private Integer fees;

	@NonNull
	private String promotionCode;

	@NonNull
	private Integer discount;
	
	@NonNull
	private Integer agentFees;

	@NonNull
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate registAt;

	private CourseListVO course;

	private LoginUserVO student;

	private PaymentTypeDto payment;

	public static RegistrationVO from(Registration entity) {
		var vo = new RegistrationVO(entity.getId(), entity.getFees(), entity.getPromotionCode(), entity.getDiscount(), entity.getAgentFees(), entity.getRegistAt());
		vo.setCourse(CourseListVO.from(entity.getCourse()));
		vo.setPayment(PaymentTypeDto.from(entity.getPaymentType()));
		vo.setStudent(LoginUserVO.from(entity.getStudent()));
		return vo;
	}
}