package com.jdc.learners.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdc.learners.domain.dto.vo.CategoryVO;
import com.jdc.learners.domain.repo.CategoryRepo;

@Service
public class CategoryService {

	private CategoryRepo repo;

	public List<CategoryVO> getAll() {
		// TODO implement here
		return null;
	}

}