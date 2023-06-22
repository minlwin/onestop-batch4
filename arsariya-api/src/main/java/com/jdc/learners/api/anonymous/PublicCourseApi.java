package com.jdc.learners.api.anonymous;

import static com.jdc.learners.utils.ExceptionUtils.idNotFound;
import static com.jdc.learners.utils.ExceptionUtils.keyNotFound;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.learners.domain.dto.ApiResult;
import com.jdc.learners.domain.dto.page.PagerResult;
import com.jdc.learners.domain.dto.vo.CourseDetailsVO;
import com.jdc.learners.domain.dto.vo.CourseListVO;
import com.jdc.learners.domain.service.CourseService;
import com.jdc.learners.domain.service.TeacherService;

@RestController
@RequestMapping("public/course")
public class PublicCourseApi {

	@Autowired
	private CourseService service;
	
	@Autowired
	private TeacherService teacherService;
	

	@GetMapping
	public ApiResult<PagerResult<CourseListVO>> search(
			@RequestParam Optional<Integer> category, 
			@RequestParam Optional<String> keyword, 
			@RequestParam(required = false, defaultValue = "0") int current, 
			@RequestParam(required = false, defaultValue = "10") int size) {
		return ApiResult.success(service.search(category, keyword, current, size));
	}

	@GetMapping("{id}/objectives")
	public ApiResult<List<String>> findObjective(@PathVariable int id) {
		return service.findObjective(id).map(ApiResult::success).orElseThrow(() -> idNotFound("Course", id));
	}

	@GetMapping("{id}")
	public ApiResult<CourseDetailsVO> findDetails(@PathVariable int id) {
		return service.findDetails(id).map(ApiResult::success).orElseThrow(() -> idNotFound("Course", id));
	}
	
	@GetMapping("teacher")
	public ApiResult<List<CourseListVO>> findCoursesForTeacher(@RequestParam String loginId) {
		return teacherService.findCoursesForTeacher(loginId).map(ApiResult::success)
				.orElseThrow(() -> keyNotFound("Teacher", "email", loginId));
	}

}