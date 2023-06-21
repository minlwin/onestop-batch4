package com.jdc.learners.domain.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jdc.learners.domain.dto.page.PagerResult;
import com.jdc.learners.domain.dto.vo.CourseListVO;
import com.jdc.learners.domain.dto.vo.TeacherAdminVO;
import com.jdc.learners.domain.entity.Teacher;
import com.jdc.learners.domain.repo.TeacherRepo;

@Service
@Transactional(readOnly = true)
public class TeacherService {

	private TeacherRepo teacherRepo;

	public Optional<List<CourseListVO>> findCoursesForTeacher(String email) {
		return teacherRepo.findOneByEmail(email).map(a -> a.getCourses().stream().map(CourseListVO::from).toList());
	}

	public PagerResult<TeacherAdminVO> search(Optional<String> name, Optional<String> email, Optional<LocalDate> from, Optional<LocalDate> to, int current, int size) {
		var specification = withName(name).and(withFrom(from)).and(withTo(to));
		
		var page = teacherRepo.findAll(specification, 
				PageRequest.of(current, size)).map(TeacherAdminVO::from);
		
		return PagerResult.from(page);
	}
	
	private Specification<Teacher> withName(Optional<String> data) {
		if(data.filter(StringUtils::hasLength).isPresent()) {
			// TODO
		}
		
		return Specification.where(null);		
	}
	

	private Specification<Teacher> withFrom(Optional<LocalDate> data) {
		if(data.isPresent()) {
			// TODO
		}
		
		return Specification.where(null);
	}	

	private Specification<Teacher> withTo(Optional<LocalDate> data) {
		if(data.isPresent()) {
			// TODO
		}
		
		return Specification.where(null);
	}		

}