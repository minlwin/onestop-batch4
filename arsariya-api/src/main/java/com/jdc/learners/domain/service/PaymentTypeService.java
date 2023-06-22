package com.jdc.learners.domain.service;

import static com.jdc.learners.utils.ExceptionUtils.idNotFound;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.learners.domain.dto.PaymentTypeDto;
import com.jdc.learners.domain.repo.PaymentTypeRepo;

@Service
@Transactional
public class PaymentTypeService {

	@Autowired
	private PaymentTypeRepo repo;

	@Transactional(readOnly = true)
	public List<PaymentTypeDto> getAll() {
		return repo.findAll().stream().map(PaymentTypeDto::from).toList();
	}

	public PaymentTypeDto create(PaymentTypeDto form) {
		var entity = repo.save(form.entity());
		return PaymentTypeDto.from(entity);
	}

	public PaymentTypeDto update(int id, PaymentTypeDto form) {
		var entity = repo.findById(id).orElseThrow(() -> idNotFound("Payment Type", id));
		entity.setName(form.getName());
		return PaymentTypeDto.from(entity);
	}

}