package com.jdc.learners.domain.dto.form;

import com.jdc.learners.domain.entity.TeacherPayment;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class TeacherPaymentForm {

	@NonNull
	private Integer id;

	@NotBlank(message = "Please enter teacher's email.")
	private String email;

	@Min(value = 1, message = "Please select payment type.")
	private int type;

	@NonNull
	@NotBlank(message = "Please enter account name.")
	private String accountName;

	@NonNull
	@NotBlank(message = "Please enter account number.")
	private String accountNumber;
	
	public TeacherPayment entity() {
		return new TeacherPayment(accountName, accountNumber);
	}
	
	public static TeacherPaymentForm from(TeacherPayment entity) {
		var vo = new TeacherPaymentForm(entity.getId(), entity.getAccountName(), entity.getAccountNumber());
		vo.setEmail(entity.getTeacher().getEmail());
		vo.setType(entity.getType().getId());
		return vo;
	}

}