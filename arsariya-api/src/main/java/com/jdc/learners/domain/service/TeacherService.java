package com.jdc.learners.domain.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jdc.learners.domain.dto.page.PagerResult;
import com.jdc.learners.domain.dto.vo.CourseListVO;
import com.jdc.learners.domain.dto.vo.TeacherAdminVO;
import com.jdc.learners.domain.repo.TeacherRepo;

@Service
public class TeacherService {

	private TeacherRepo teacherRepo;

	public PagerResult<TeacherAdminVO> search(Optional<String> teacher, Optional<String> email, Optional<LocalDate> from, Optional<LocalDate> to, int current, int size) {
		// TODO implement here
		return null;
	}

	public Optional<List<CourseListVO>> findCoursesForTeacher(String email) {
		// TODO implement here
		return null;
	}

}