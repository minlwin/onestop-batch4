package com.jdc.learners.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.learners.domain.dto.form.StudentSignUpForm;
import com.jdc.learners.domain.dto.form.TeacherSignUpForm;
import com.jdc.learners.domain.dto.vo.LoginUserVO;
import com.jdc.learners.domain.entity.Account;
import com.jdc.learners.domain.repo.AccountRepo;

@Service
@Transactional
public class SecurityService {

	@Autowired
	private AccountRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Account create(TeacherSignUpForm form) {
		var entity = form.entity();
		entity.setPassword(passwordEncoder.encode(form.getPassword()));
		return repo.save(entity);
	}

	public Account create(StudentSignUpForm form) {
		var entity = form.entity();
		entity.setPassword(passwordEncoder.encode(form.getPassword()));
		return repo.save(entity);
	}

	@Transactional(readOnly = true)
	public Optional<LoginUserVO> findLoginUser(String email) {
		return repo.findOneByEmail(email).map(LoginUserVO::from);
	}

}