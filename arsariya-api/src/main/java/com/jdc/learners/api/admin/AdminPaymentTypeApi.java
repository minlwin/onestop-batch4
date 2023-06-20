package com.jdc.learners.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.learners.domain.dto.ApiResult;
import com.jdc.learners.domain.dto.PaymentTypeDto;
import com.jdc.learners.domain.service.PaymentTypeService;

@RestController
@RequestMapping("/admin/payment")
public class AdminPaymentTypeApi {

	@Autowired
	private PaymentTypeService service;

	@PostMapping
	public ApiResult<PaymentTypeDto> create(@RequestBody @Validated PaymentTypeDto form, BindingResult result) {
		return ApiResult.success(service.create(form));
	}

	@PutMapping("{id}")
	public ApiResult<PaymentTypeDto> update(@PathVariable int id, @RequestBody @Validated PaymentTypeDto form, BindingResult result) {
		return ApiResult.success(service.update(id, form));
	}

}