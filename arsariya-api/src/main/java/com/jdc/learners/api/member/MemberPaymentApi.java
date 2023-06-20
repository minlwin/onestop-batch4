package com.jdc.learners.api.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.learners.domain.dto.ApiResult;
import com.jdc.learners.domain.dto.PaymentTypeDto;
import com.jdc.learners.domain.service.PaymentTypeService;

@RestController
@RequestMapping("member/payment")
public class MemberPaymentApi {

	@Autowired
	private PaymentTypeService service;

	@GetMapping
	public ApiResult<List<PaymentTypeDto>> getAllPayments() {
		return ApiResult.success(service.getAll());
	}

}