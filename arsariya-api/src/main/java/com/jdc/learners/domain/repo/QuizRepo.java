package com.jdc.learners.domain.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.learners.domain.entity.Quiz;

public interface QuizRepo extends JpaRepositoryImplementation<Quiz, Integer> {

}