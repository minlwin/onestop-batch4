package com.jdc.learners.domain.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.learners.domain.entity.Content;

public interface ContentRepo extends JpaRepositoryImplementation<Content, Integer> {

}