package com.jdc.learners.api.anonymous;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.learners.domain.dto.ApiResult;
import com.jdc.learners.domain.dto.vo.CategoryVO;
import com.jdc.learners.domain.service.CategoryService;

@RestController
@RequestMapping("public/category")
public class PublicCategoryApi {

	@Autowired
	private CategoryService service;

	@GetMapping
	public ApiResult<List<CategoryVO>> findAll() {
		return ApiResult.success(service.getAll());
	}

}