package com.jdc.learners.domain.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jdc.learners.domain.dto.page.PagerResult;
import com.jdc.learners.domain.dto.vo.RegistrationAdminVO;
import com.jdc.learners.domain.entity.Registration;
import com.jdc.learners.domain.repo.RegistrationRepo;

@Service
@Transactional(readOnly = true)
public class RegistrationService {

	@Autowired
	private RegistrationRepo repo;

	public PagerResult<RegistrationAdminVO> search(Optional<String> student, Optional<String> course, Optional<LocalDate> from, Optional<LocalDate> to, int current, int size) {
		var specification = withStudent(student)
				.and(withCourse(course))
				.and(withFrom(from))
				.and(withTo(to));
		
		var page = repo.findAll(specification, 
				PageRequest.of(current, size)).map(RegistrationAdminVO::from);
		
		return PagerResult.from(page);
	}
	
	private Specification<Registration> withStudent(Optional<String> data) {
		if(data.filter(StringUtils::hasLength).isPresent()) {
			// TODO
		}
		
		return Specification.where(null);		
	}
	
	private Specification<Registration> withCourse(Optional<String> data) {
		if(data.filter(StringUtils::hasLength).isPresent()) {
			// TODO
		}
		
		return Specification.where(null);		
	}

	private Specification<Registration> withFrom(Optional<LocalDate> data) {
		if(data.isPresent()) {
			// TODO
		}
		
		return Specification.where(null);
	}	

	private Specification<Registration> withTo(Optional<LocalDate> data) {
		if(data.isPresent()) {
			// TODO
		}
		
		return Specification.where(null);
	}
}