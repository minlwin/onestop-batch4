package com.jdc.learners.domain.dto.form;

import lombok.Data;

@Data
public class PurchaseForm {

	public PurchaseForm() {
	}

	private int courseId;

	private String studentId;

	private int paymentId;

	private int fees;

	private String promotionCode;

}