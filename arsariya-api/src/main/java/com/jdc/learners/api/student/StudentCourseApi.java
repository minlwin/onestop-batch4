package com.jdc.learners.api.student;

import static com.jdc.learners.utils.ExceptionUtils.keyNotFound;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.learners.domain.dto.ApiResult;
import com.jdc.learners.domain.dto.vo.CourseListVO;
import com.jdc.learners.domain.service.StudentService;

@RestController
@RequestMapping("student/course")
public class StudentCourseApi {

	@Autowired
	private StudentService service;

	@GetMapping
	public ApiResult<List<CourseListVO>> search(@RequestParam String loginId) {
		return service.findCourseForStudent(loginId).map(ApiResult::success).orElseThrow(() -> keyNotFound("Student", "email", loginId));
	}

}