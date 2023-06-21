package com.jdc.learners.domain.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jdc.learners.domain.dto.form.CourseForm;
import com.jdc.learners.domain.dto.page.PagerResult;
import com.jdc.learners.domain.dto.vo.CourseAdminVO;
import com.jdc.learners.domain.dto.vo.CourseDetailsVO;
import com.jdc.learners.domain.dto.vo.CourseListVO;
import com.jdc.learners.domain.entity.Category;
import com.jdc.learners.domain.entity.Course;
import com.jdc.learners.domain.repo.CategoryRepo;
import com.jdc.learners.domain.repo.CourseRepo;
import com.jdc.learners.domain.repo.TeacherRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional(readOnly = true)
public class CourseService {

	@Autowired
	private CourseRepo courseRepo;

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private TeacherRepo teacherRepo;

	@Transactional
	@PreAuthorize("hasAuthority('Teacher')")
	public CourseListVO create(CourseForm form) {
		
		var teacher = teacherRepo.findOneByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(EntityNotFoundException::new);

		var entity = new Course();
		entity.setName(form.getName());
		entity.setCategory(getCategory(form.getCategory()));
		entity.setFees(form.getFees());
		entity.setHours(form.getHours());
		entity.setImage(form.getImage());
		entity.setDescription(form.getDescription());
		entity.setObjectives(form.getObjectives());
		entity.setTeacher(teacher);
		
		entity = courseRepo.save(entity);

		return CourseListVO.from(entity);
	}

	@Transactional
	@PreAuthorize("hasAuthority('Teacher')")
	public CourseListVO update(int id, CourseForm form) {
		
		var entity = courseRepo.findById(id).orElseThrow(EntityNotFoundException::new);
		
		entity.setName(form.getName());
		entity.setCategory(getCategory(form.getCategory()));
		entity.setFees(form.getFees());
		entity.setHours(form.getHours());
		entity.setImage(form.getImage());
		entity.setDescription(form.getDescription());
		entity.setObjectives(form.getObjectives());
		
		return CourseListVO.from(entity);
	}

	public Optional<List<String>> findObjective(int id) {
		return courseRepo.findById(id).map(Course::getObjectives);
	}

	public Optional<CourseDetailsVO> findDetails(int id) {
		return courseRepo.findById(id).map(CourseDetailsVO::from);
	}

	public PagerResult<CourseListVO> search(Optional<Integer> category, Optional<String> keyword, int current, int size) {
		
		var specification = withCategory(category)
				.and(withKeyword(keyword));
		
		var page = courseRepo.findAll(specification, 
				PageRequest.of(current, size)).map(CourseListVO::from);
		
		return PagerResult.from(page);
	}

	public PagerResult<CourseAdminVO> searchForAdmin(Optional<String> teacher, Optional<String> course, Optional<LocalDate> from, Optional<LocalDate> to, int current, int size) {
		
		var specification = withTeacher(teacher).and(withCourse(course)).and(withFrom(from)).and(withTo(to));
		
		var page = courseRepo.findAll(specification, 
				PageRequest.of(current, size)).map(CourseAdminVO::from);
		
		return PagerResult.from(page);
	}

	private Category getCategory(String category) {
		return categoryRepo.findOneByName(category).orElseGet(() -> categoryRepo.save(new Category(category)));
	}

	private Specification<Course> withCategory(Optional<Integer> data) {
		if(data.filter(a -> a > 0).isPresent()) {
			// TODO
		}
		
		return Specification.where(null);
	}
	
	private Specification<Course> withKeyword(Optional<String> data) {
		if(data.filter(StringUtils::hasLength).isPresent()) {
			// TODO
		}
		
		return Specification.where(null);
	}
	
	private Specification<Course> withTeacher(Optional<String> data) {
		if(data.filter(StringUtils::hasLength).isPresent()) {
			// TODO
		}
		
		return Specification.where(null);
	}
	
	private Specification<Course> withCourse(Optional<String> data) {
		if(data.filter(StringUtils::hasLength).isPresent()) {
			// TODO
		}
		
		return Specification.where(null);
	}
	
	private Specification<Course> withFrom(Optional<LocalDate> data) {
		if(data.isPresent()) {
			// TODO
		}
		
		return Specification.where(null);
	}	

	private Specification<Course> withTo(Optional<LocalDate> data) {
		if(data.isPresent()) {
			// TODO
		}
		
		return Specification.where(null);
	}	
}