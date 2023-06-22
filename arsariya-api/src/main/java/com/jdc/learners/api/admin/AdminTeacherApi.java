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
import com.jdc.learners.domain.dto.vo.TeacherAdminVO;
import com.jdc.learners.domain.service.TeacherService;

@RestController
@RequestMapping("/admin/teacher")
public class AdminTeacherApi {

	@Autowired
	private TeacherService service;

	@GetMapping
	public ApiResult<PagerResult<TeacherAdminVO>> search(
			@RequestParam Optional<String> teacher, 
			@RequestParam Optional<String> email, 
			@RequestParam Optional<LocalDate> from, 
			@RequestParam Optional<LocalDate> to, 
			@RequestParam(required = false, defaultValue = "0") int current, 
			@RequestParam(required = false, defaultValue = "10") int size) {
		return ApiResult.success(service.search(teacher, email, from, to, current, size));
	}

}