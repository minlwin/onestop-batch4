package com.jdc.learners.api.anonymous;

import static com.jdc.learners.utils.ExceptionUtils.idNotFound;

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
import com.jdc.learners.domain.entity.Course;
import com.jdc.learners.domain.service.CourseService;

@RestController
@RequestMapping("public/course")
public class PublicCourseApi {

	@Autowired
	private CourseService service;

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
		return service.findObjective(id).map(ApiResult::success).orElseThrow(() -> idNotFound(Course.class, id));
	}

	@GetMapping("{id}")
	public ApiResult<CourseDetailsVO> findDetails(@PathVariable int id) {
		return service.findDetails(id).map(ApiResult::success).orElseThrow(() -> idNotFound(Course.class, id));
	}

}