package com.jdc.learners.api.teacher;

import java.util.List;

import com.jdc.learners.domain.dto.ApiResult;
import com.jdc.learners.domain.dto.TeacherPaymentDto;
import com.jdc.learners.domain.service.PaymentMethodService;

public class TeacherPaymentMethodApi {

	private PaymentMethodService service;

	public ApiResult<List<TeacherPaymentDto>> getOwnPayments() {
		// TODO implement here
		return null;
	}

	public ApiResult<TeacherPaymentDto> create(TeacherPaymentDto form) {
		// TODO implement here
		return null;
	}

	public ApiResult<TeacherPaymentDto> update(int id, TeacherPaymentDto form) {
		// TODO implement here
		return null;
	}

}