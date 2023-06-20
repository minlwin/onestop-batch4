package com.jdc.learners.api.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.learners.domain.dto.ApiResult;
import com.jdc.learners.domain.dto.form.CourseForm;
import com.jdc.learners.domain.dto.vo.CourseListVO;
import com.jdc.learners.domain.service.CourseService;
import com.jdc.learners.domain.service.TeacherService;

@RestController
@RequestMapping("teacher/course")
public class TeacherCourseApi {

	@Autowired
	private CourseService courseService;

	@Autowired
	private TeacherService teacherService;
	
	@GetMapping
	public ApiResult<List<CourseListVO>> findCoursesForTeacher(@RequestParam String loginId) {
		return teacherService.findCoursesForTeacher(loginId).map(ApiResult::success).orElseThrow();
	}
	
	@PostMapping
	public ApiResult<CourseListVO> create(
			@Validated @RequestBody CourseForm form, BindingResult result) {
		return ApiResult.success(courseService.create(form));
	}

	@PutMapping("{id}")
	public ApiResult<CourseListVO> update(@PathVariable int id, 
			@Validated @RequestBody CourseForm form, BindingResult result) {
		return ApiResult.success(courseService.update(id, form));
	}

}