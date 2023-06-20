package com.jdc.learners.domain.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.learners.domain.entity.Chapter;

public interface ChapterRepo extends JpaRepositoryImplementation<Chapter, Integer> {

}