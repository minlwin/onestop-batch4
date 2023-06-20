package com.jdc.learners.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.learners.domain.dto.TeacherPaymentDto;
import com.jdc.learners.domain.repo.PaymentTypeRepo;
import com.jdc.learners.domain.repo.TeacherPaymentRepo;
import com.jdc.learners.domain.repo.TeacherRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class PaymentMethodService {

	@Autowired
	private TeacherPaymentRepo paymentRepo;
	
	@Autowired
	private PaymentTypeRepo paymentTypeRepo;

	@Autowired
	private TeacherRepo teacherRepo;

	@Transactional(readOnly = true)
	public Optional<List<TeacherPaymentDto>> getOwnPayments() {
		return teacherRepo.findOneByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
				.map(a -> a.getPayments().stream().map(TeacherPaymentDto::from).toList());
	}

	@PreAuthorize("hasAuthority('Teacher')")
	public TeacherPaymentDto create(TeacherPaymentDto form) {
		
		var teacher = teacherRepo.findOneByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
				.orElseThrow(EntityNotFoundException::new);
		var type = paymentTypeRepo.findById(form.getId())
				.orElseThrow(EntityNotFoundException::new);
		
		var entity = form.entity();
		entity.setTeacher(teacher);
		entity.setType(type);
		
		entity = paymentRepo.save(entity);
		
		return TeacherPaymentDto.from(entity);
	}

	@PreAuthorize("hasAuthority('Teacher')")
	public TeacherPaymentDto update(int id, TeacherPaymentDto form) {
		
		var type = paymentTypeRepo.findById(form.getId())
				.orElseThrow(EntityNotFoundException::new);

		var entity = paymentRepo.findById(id).orElseThrow(EntityNotFoundException::new);
		
		entity.setType(type);
		entity.setAccountName(form.getAccountName());
		entity.setAccountNumber(form.getAccountNumber());
		
		return TeacherPaymentDto.from(entity);
	}

}