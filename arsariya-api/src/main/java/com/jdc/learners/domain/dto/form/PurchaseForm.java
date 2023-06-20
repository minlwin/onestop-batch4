package com.jdc.learners.domain.dto.form;

import com.jdc.learners.domain.entity.Registration;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PurchaseForm {

	@NotNull(message = "Please define course for purchase course.")
	private Integer courseId;

	@NotNull(message = "Please select payment type.")
	private Integer paymentId;
	
	private Integer fees;

	private String promotionCode;
	
	public Registration entity() {
		var data = new Registration();
		data.setFees(fees);
		data.setPromotionCode(promotionCode);
		return data;
	}

}