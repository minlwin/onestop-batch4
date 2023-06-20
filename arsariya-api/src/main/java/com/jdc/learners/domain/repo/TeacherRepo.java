package com.jdc.learners.domain.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.learners.domain.entity.Teacher;

public interface TeacherRepo extends JpaRepositoryImplementation<Teacher, Integer> {

	public Optional<Teacher> findOneByEmail(String email);

}