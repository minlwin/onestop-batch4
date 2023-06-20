package com.jdc.learners.domain.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.learners.domain.entity.Registration;

public interface RegistrationRepo extends JpaRepositoryImplementation<Registration, Integer> {

}