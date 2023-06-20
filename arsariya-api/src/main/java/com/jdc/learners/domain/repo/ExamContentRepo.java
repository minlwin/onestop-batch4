package com.jdc.learners.domain.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.learners.domain.entity.ExamContent;

public interface ExamContentRepo extends JpaRepositoryImplementation<ExamContent, Integer> {

}