package com.jdc.learners.domain.service;

import static com.jdc.learners.utils.ExceptionUtils.idNotFound;
import static com.jdc.learners.utils.ExceptionUtils.keyNotFound;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.learners.domain.dto.form.TeacherPaymentForm;
import com.jdc.learners.domain.dto.vo.TeacherPaymentVO;
import com.jdc.learners.domain.repo.PaymentTypeRepo;
import com.jdc.learners.domain.repo.TeacherPaymentRepo;
import com.jdc.learners.domain.repo.TeacherRepo;

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
	public Optional<List<TeacherPaymentVO>> getOwnPayments() {
		return teacherRepo.findOneByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
				.map(a -> a.getPayments().stream().map(TeacherPaymentVO::from).toList());
	}

	@PreAuthorize("hasAuthority('Teacher')")
	public TeacherPaymentForm create(TeacherPaymentForm form) {
		
		var loginId = SecurityContextHolder.getContext().getAuthentication().getName();
		
		var teacher = teacherRepo.findOneByEmail(loginId)
				.orElseThrow(() -> keyNotFound("Teacher", "email", loginId));
		var type = paymentTypeRepo.findById(form.getType())
				.orElseThrow(() -> idNotFound("Payment Type", form.getType()));
		
		var entity = form.entity();
		entity.setTeacher(teacher);
		entity.setType(type);
		
		entity = paymentRepo.save(entity);
		
		return TeacherPaymentForm.from(entity);
	}

	@PreAuthorize("hasAuthority('Teacher')")
	public TeacherPaymentForm update(int id, TeacherPaymentForm form) {
		
		var type = paymentTypeRepo.findById(form.getId())
				.orElseThrow(() -> idNotFound("Payment Type", form.getType()));

		var entity = paymentRepo.findById(id).orElseThrow(() -> idNotFound("Teacher Payment", id));
		
		entity.setType(type);
		entity.setAccountName(form.getAccountName());
		entity.setAccountNumber(form.getAccountNumber());
		
		return TeacherPaymentForm.from(entity);
	}

}