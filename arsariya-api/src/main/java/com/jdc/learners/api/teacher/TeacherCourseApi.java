package com.jdc.learners.api.teacher;

import java.util.List;

import com.jdc.learners.domain.dto.ApiResult;
import com.jdc.learners.domain.dto.form.CourseForm;
import com.jdc.learners.domain.dto.vo.CourseListVO;
import com.jdc.learners.domain.service.CourseService;
import com.jdc.learners.domain.service.TeacherService;

public class TeacherCourseApi {

	private CourseService courseService;

	private TeacherService teacherService;

	public ApiResult<List<CourseListVO>> findCoursesForTeacher(String loginId) {
		// TODO implement here
		return null;
	}

	public ApiResult<CourseListVO> create(CourseForm form) {
		// TODO implement here
		return null;
	}

	public ApiResult<CourseListVO> update(int id, CourseForm form) {
		// TODO implement here
		return null;
	}

}