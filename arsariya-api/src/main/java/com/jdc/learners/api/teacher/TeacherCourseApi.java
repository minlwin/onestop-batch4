package com.jdc.learners.api.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.learners.domain.dto.ApiResult;
import com.jdc.learners.domain.dto.form.CourseForm;
import com.jdc.learners.domain.dto.vo.CourseDetailsVO;
import com.jdc.learners.domain.dto.vo.CourseListVO;
import com.jdc.learners.domain.service.CourseService;

@RestController
@RequestMapping("teacher/course")
public class TeacherCourseApi {

	@Autowired
	private CourseService courseService;

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
	
	@PostMapping("{id}/image")
	public ApiResult<CourseDetailsVO> uploadImage(@PathVariable int id, @RequestParam MultipartFile file) {
		return ApiResult.success(courseService.uploadImage(id, file));
	}

}