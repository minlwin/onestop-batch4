package com.jdc.learners.domain.dto;

import com.jdc.learners.domain.entity.PaymentType;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTypeDto {

	private int id;
	
	@NotBlank(message = "Please enter payment type name.")
	private String name;
	
	public PaymentType entity() {
		return new PaymentType(id, name);
	}
	
	public static PaymentTypeDto from(PaymentType entity) {
		return new PaymentTypeDto(entity.getId(), entity.getName());
	}

}