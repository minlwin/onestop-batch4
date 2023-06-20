package com.jdc.learners.domain.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jdc.learners.domain.dto.page.PagerResult;
import com.jdc.learners.domain.dto.vo.RegistrationAdminVO;
import com.jdc.learners.domain.repo.RegistrationRepo;

@Service
public class RegistrationService {

	private RegistrationRepo repo;

	public PagerResult<RegistrationAdminVO> search(Optional<String> student, Optional<String> course, Optional<LocalDate> from, Optional<LocalDate> to, int current, int size) {
		// TODO implement here
		return null;
	}

}