package com.jdc.learners.domain.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jdc.learners.domain.dto.form.CourseForm;
import com.jdc.learners.domain.dto.page.PagerResult;
import com.jdc.learners.domain.dto.vo.CourseAdminVO;
import com.jdc.learners.domain.dto.vo.CourseDetailsVO;
import com.jdc.learners.domain.dto.vo.CourseListVO;
import com.jdc.learners.domain.repo.CategoryRepo;
import com.jdc.learners.domain.repo.CourseRepo;

@Service
public class CourseService {

	private CourseRepo courseRepo;

	private CategoryRepo categoryRepo;

	public PagerResult<CourseListVO> search(Optional<Integer> category, Optional<String> keyword, int current, int size) {
		// TODO implement here
		return null;
	}

	public PagerResult<CourseAdminVO> searchForAdmin(Optional<String> teacher, Optional<String> course, Optional<LocalDate> from, Optional<LocalDate> to, int current, int size) {
		// TODO implement here
		return null;
	}

	public Optional<List<String>> findObjective(int id) {
		// TODO implement here
		return null;
	}

	public Optional<CourseDetailsVO> findDetails(int id) {
		// TODO implement here
		return null;
	}

	public CourseDetailsVO create(CourseForm form) {
		// TODO implement here
		return null;
	}

	public CourseDetailsVO update(int id, CourseForm form) {
		// TODO implement here
		return null;
	}

}