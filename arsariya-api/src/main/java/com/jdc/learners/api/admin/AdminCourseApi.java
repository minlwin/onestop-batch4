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
import com.jdc.learners.domain.dto.vo.CourseAdminVO;
import com.jdc.learners.domain.service.CourseService;

@RestController
@RequestMapping("/admin/course")
public class AdminCourseApi {

	@Autowired
	private CourseService service;

	@GetMapping
	public ApiResult<PagerResult<CourseAdminVO>> search(
			@RequestParam Optional<String> teacher, 
			@RequestParam Optional<String> course, 
			@RequestParam Optional<LocalDate> from, 
			@RequestParam Optional<LocalDate> to, 
			@RequestParam(required = false, defaultValue = "0") int current, 
			@RequestParam(required = false, defaultValue = "10") int size) {
		
		var result = service.searchForAdmin(teacher, course, from, to, current, size);
		
		return ApiResult.success(result);
	}

}