package com.jdc.learners.domain.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.learners.domain.entity.PaymentType;

public interface PaymentTypeRepo extends JpaRepositoryImplementation<PaymentType, Integer> {

}