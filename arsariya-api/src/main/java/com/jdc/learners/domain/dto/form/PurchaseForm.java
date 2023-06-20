package com.jdc.learners.domain.dto.form;

import lombok.Data;

@Data
public class PurchaseForm {

	private Integer courseId;

	private String studentId;

	private Integer paymentId;

	private Integer fees;

	private String promotionCode;

}