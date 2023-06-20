package com.jdc.learners.domain.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jdc.learners.domain.dto.form.StudentSignUpForm;
import com.jdc.learners.domain.dto.form.TeacherSignUpForm;
import com.jdc.learners.domain.dto.vo.LoginUserVO;
import com.jdc.learners.domain.entity.Account;
import com.jdc.learners.domain.repo.AccountRepo;

@Service
public class SecurityService {

	private AccountRepo repo;

	public Account create(TeacherSignUpForm form) {
		// TODO implement here
		return null;
	}

	public Account create(StudentSignUpForm form) {
		// TODO implement here
		return null;
	}

	public Optional<LoginUserVO> findLoginUser(String email) {
		// TODO implement here
		return null;
	}

}