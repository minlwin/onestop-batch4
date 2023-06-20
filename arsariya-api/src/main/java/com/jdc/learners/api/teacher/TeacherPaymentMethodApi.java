package com.jdc.learners.api.teacher;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.learners.domain.dto.ApiResult;
import com.jdc.learners.domain.dto.TeacherPaymentDto;
import com.jdc.learners.domain.service.PaymentMethodService;

@RestController
@RequestMapping("teacher/payment")
public class TeacherPaymentMethodApi {

	private PaymentMethodService service;

	@GetMapping
	public ApiResult<List<TeacherPaymentDto>> getOwnPayments() {
		return ApiResult.success(service.getOwnPayments());
	}

	@PostMapping
	public ApiResult<TeacherPaymentDto> create(
			@Validated @RequestBody TeacherPaymentDto form, BindingResult result) {
		return ApiResult.success(service.create(form));
	}

	@PutMapping("{id}")
	public ApiResult<TeacherPaymentDto> update(@PathVariable int id, 
			@Validated @RequestBody TeacherPaymentDto form, BindingResult result) {
		return ApiResult.success(service.update(id, form));
	}

}