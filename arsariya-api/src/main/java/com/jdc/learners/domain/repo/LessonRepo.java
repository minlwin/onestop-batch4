package com.jdc.learners.domain.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.learners.domain.entity.Lesson;

public interface LessonRepo extends JpaRepositoryImplementation<Lesson, Integer> {

}