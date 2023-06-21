package com.jdc.learners.api.admin;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.learners.domain.dto.ApiResult;
import com.jdc.learners.domain.dto.page.PagerResult;
import com.jdc.learners.domain.dto.vo.StudentAdminVO;
import com.jdc.learners.domain.service.StudentService;

@RestController
@RequestMapping("/admin/students")
public class AdminStudentApi {

	@Autowired
	private StudentService service;

	@GetMapping
	public ApiResult<PagerResult<StudentAdminVO>> search(
			@RequestParam Optional<String> student, 
			@RequestParam Optional<LocalDate> from, 
			@RequestParam Optional<LocalDate> to, 
			@RequestParam(required = false, defaultValue = "0") int current, 
			@RequestParam(required = false, defaultValue = "10") int size) {
		return ApiResult.success(service.search(student, from, to, current, size));
	}

}