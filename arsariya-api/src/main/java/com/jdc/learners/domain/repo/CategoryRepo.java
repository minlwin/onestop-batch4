package com.jdc.learners.domain.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.learners.domain.entity.Category;

public interface CategoryRepo extends JpaRepositoryImplementation <Category, Integer> {

	public Optional<Category> findOneByName(String name);

}