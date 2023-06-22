package com.jdc.learners.api.teacher;

import static com.jdc.learners.utils.ExceptionUtils.keyNotFound;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.jdc.learners.domain.dto.form.TeacherPaymentForm;
import com.jdc.learners.domain.dto.vo.TeacherPaymentVO;
import com.jdc.learners.domain.service.PaymentMethodService;

@RestController
@RequestMapping("teacher/payment")
public class TeacherPaymentMethodApi {

	@Autowired
	private PaymentMethodService service;

	@GetMapping
	public ApiResult<List<TeacherPaymentVO>> getOwnPayments() {
		return service.getOwnPayments().map(ApiResult::success)
				.orElseThrow(() -> keyNotFound("Teacher", "email", 
						SecurityContextHolder.getContext().getAuthentication().getName()));
	}

	@PostMapping
	public ApiResult<TeacherPaymentForm> create(
			@Validated @RequestBody TeacherPaymentForm form, BindingResult result) {
		return ApiResult.success(service.create(form));
	}

	@PutMapping("{id}")
	public ApiResult<TeacherPaymentForm> update(@PathVariable int id, 
			@Validated @RequestBody TeacherPaymentForm form, BindingResult result) {
		return ApiResult.success(service.update(id, form));
	}

}