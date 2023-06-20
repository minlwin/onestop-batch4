package com.jdc.learners.domain.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.learners.domain.entity.Student;

public interface StudentRepo extends JpaRepositoryImplementation<Student, Integer> {

	public Optional<Student> findOneByEmail(String email);

}