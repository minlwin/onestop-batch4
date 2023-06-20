package com.jdc.learners.domain.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.learners.domain.entity.Course;

public interface CourseRepo extends JpaRepositoryImplementation<Course, Integer> {

}