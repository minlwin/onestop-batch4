package com.jdc.learners.api.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.learners.domain.dto.ApiResult;
import com.jdc.learners.domain.dto.form.PurchaseForm;
import com.jdc.learners.domain.dto.vo.RegistrationVO;
import com.jdc.learners.domain.service.StudentService;

@RestController
@RequestMapping("student/registration")
public class StudentRegistrationApi {
	
	@Autowired
	private StudentService service;

	@PostMapping
	public ApiResult<RegistrationVO> purchaseCourse(@Validated @RequestBody PurchaseForm form, BindingResult result) {
		return ApiResult.success(service.purchaseCourse(form));
	}

}