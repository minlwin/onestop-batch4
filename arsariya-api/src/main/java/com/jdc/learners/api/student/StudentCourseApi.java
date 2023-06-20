package com.jdc.learners.api.student;

import java.util.List;

import com.jdc.learners.domain.dto.ApiResult;
import com.jdc.learners.domain.dto.vo.CourseListVO;
import com.jdc.learners.domain.service.StudentService;

public class StudentCourseApi {

	private StudentService service;

	public ApiResult<List<CourseListVO>> search(String loginId) {
		// TODO implement here
		return null;
	}

}