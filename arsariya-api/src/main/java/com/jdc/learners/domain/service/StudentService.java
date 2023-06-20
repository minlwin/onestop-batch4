package com.jdc.learners.domain.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jdc.learners.domain.dto.form.PurchaseForm;
import com.jdc.learners.domain.dto.page.PagerResult;
import com.jdc.learners.domain.dto.vo.CourseListVO;
import com.jdc.learners.domain.dto.vo.RegistrationVO;
import com.jdc.learners.domain.dto.vo.StudentAdminVO;
import com.jdc.learners.domain.repo.RegistrationRepo;
import com.jdc.learners.domain.repo.StudentRepo;

@Service
public class StudentService {

	private StudentRepo studentRepo;

	private RegistrationRepo registrationRepo;

	public PagerResult<StudentAdminVO> search(Optional<String> student, Optional<LocalDate> from, Optional<LocalDate> to, int current, int size) {
		// TODO implement here
		return null;
	}

	public Optional<List<CourseListVO>> findCourseForStudent(String email) {
		// TODO implement here
		return null;
	}

	public RegistrationVO purchaseCourse(PurchaseForm form) {
		// TODO implement here
		return null;
	}

}