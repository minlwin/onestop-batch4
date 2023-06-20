package com.jdc.learners.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdc.learners.domain.dto.TeacherPaymentDto;
import com.jdc.learners.domain.repo.TeacherPaymentRepo;
import com.jdc.learners.domain.repo.TeacherRepo;

@Service
public class PaymentMethodService {

	private TeacherPaymentRepo paymentRepo;

	private TeacherRepo teacherRepo;

	public List<TeacherPaymentDto> getOwnPayments() {
		// TODO implement here
		return null;
	}

	public TeacherPaymentDto create(TeacherPaymentDto form) {
		// TODO implement here
		return null;
	}

	public TeacherPaymentDto update(int id, TeacherPaymentDto form) {
		// TODO implement here
		return null;
	}

}