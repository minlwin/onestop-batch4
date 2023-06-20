package com.jdc.learners.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.learners.domain.dto.vo.CategoryVO;
import com.jdc.learners.domain.repo.CategoryRepo;

@Service
@Transactional(readOnly = true)
public class CategoryService {
	
	@Autowired
	private CategoryRepo repo;

	public List<CategoryVO> getAll() {
		return repo.findAll().stream().map(CategoryVO::from).toList();
	}

}