package com.jdc.learners.domain.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.learners.domain.entity.FileContent;

public interface FileContentRepo extends JpaRepositoryImplementation<FileContent, Integer> {

}