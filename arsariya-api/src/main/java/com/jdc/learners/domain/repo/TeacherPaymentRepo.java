package com.jdc.learners.domain.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.learners.domain.entity.TeacherPayment;

public interface TeacherPaymentRepo extends JpaRepositoryImplementation<TeacherPayment, Integer> {

}