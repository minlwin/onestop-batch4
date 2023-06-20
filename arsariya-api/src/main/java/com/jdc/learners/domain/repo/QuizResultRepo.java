package com.jdc.learners.domain.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.learners.domain.entity.QuizResult;

public interface QuizResultRepo extends JpaRepositoryImplementation<QuizResult, Integer> {

}