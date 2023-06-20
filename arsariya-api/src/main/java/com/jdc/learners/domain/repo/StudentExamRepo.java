package com.jdc.learners.domain.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.learners.domain.entity.StudentExam;

public interface StudentExamRepo extends JpaRepositoryImplementation<StudentExam, Integer>{

}