package com.jdc.learners.domain.dto.vo;

import com.jdc.learners.domain.dto.PaymentTypeDto;
import com.jdc.learners.domain.entity.TeacherPayment;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class TeacherPaymentVO {

	@NonNull
	private Integer id;

	@NonNull
	private String email;

	private PaymentTypeDto type;

	@NonNull
	private String accountName;

	@NonNull
	private String accountNumber;
	
	public TeacherPayment entity() {
		return new TeacherPayment(accountName, accountNumber);
	}
	
	public static TeacherPaymentVO from(TeacherPayment entity) {
		var vo = new TeacherPaymentVO(entity.getId(), entity.getTeacher().getEmail(), entity.getAccountName(), entity.getAccountNumber());
		vo.setEmail(entity.getTeacher().getEmail());
		vo.setType(PaymentTypeDto.from(entity.getType()));
		return vo;
	}

}