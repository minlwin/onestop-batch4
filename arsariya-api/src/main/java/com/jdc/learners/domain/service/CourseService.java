package com.jdc.learners.domain.service;

import static com.jdc.learners.utils.ExceptionUtils.idNotFound;
import static com.jdc.learners.utils.SpecificationUtils.withFrom;
import static com.jdc.learners.utils.SpecificationUtils.withTo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.learners.domain.dto.form.CourseForm;
import com.jdc.learners.domain.dto.page.PagerResult;
import com.jdc.learners.domain.dto.vo.CourseAdminVO;
import com.jdc.learners.domain.dto.vo.CourseDetailsVO;
import com.jdc.learners.domain.dto.vo.CourseDetailsVO.Type;
import com.jdc.learners.domain.dto.vo.CourseListVO;
import com.jdc.learners.domain.entity.Account.Role;
import com.jdc.learners.domain.entity.Category;
import com.jdc.learners.domain.entity.Course;
import com.jdc.learners.domain.entity.Registration;
import com.jdc.learners.domain.repo.CategoryRepo;
import com.jdc.learners.domain.repo.CourseRepo;
import com.jdc.learners.domain.repo.StudentRepo;
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
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private FileUploadService uploadService;

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
	
	@Transactional
	@PreAuthorize("hasAuthority('Teacher')")
	public CourseDetailsVO uploadImage(int id, MultipartFile file) {		
		return courseRepo.findById(id).map(entity -> {
			entity.setImage(uploadService.uploadCourseImage(file));
			return CourseDetailsVO.from(entity);
		})
		.map(this::setType)
		.orElseThrow(() -> idNotFound("Course", id));
	}

	public Optional<List<String>> findObjective(int id) {
		return courseRepo.findById(id).map(Course::getObjectives);
	}

	public Optional<CourseDetailsVO> findDetails(int id) {
		return courseRepo.findById(id)
				.map(CourseDetailsVO::from)
				.map(this::setType);
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
			return (root, query, cb) -> cb.equal(root.get("category").get("id"), data.get());
		}
		
		return Specification.where(null);
	}
	
	private Specification<Course> withKeyword(Optional<String> data) {
		if(data.filter(StringUtils::hasLength).isPresent()) {
			return (root, query, cb) -> cb.or(
				cb.like(cb.lower(root.get("name")), data.get().toLowerCase().concat("%")),
				cb.like(cb.lower(root.get("category").get("name")), data.get().toLowerCase().concat("%")));
		}
		
		return Specification.where(null);
	}
	
	private Specification<Course> withTeacher(Optional<String> data) {
		if(data.filter(StringUtils::hasLength).isPresent()) {
			return (root, query, cb) -> cb.like(cb.lower(root.get("teacher").get("name")), data.get().toLowerCase().concat("%"));
		}
		
		return Specification.where(null);
	}
	
	private Specification<Course> withCourse(Optional<String> data) {
		if(data.filter(StringUtils::hasLength).isPresent()) {
			return (root, query, cb) -> cb.like(cb.lower(root.get("name")), data.get().toLowerCase().concat("%"));
		}
		
		return Specification.where(null);
	}
	
	private CourseDetailsVO setType(CourseDetailsVO vo) {
		var authentication = SecurityContextHolder.getContext().getAuthentication();
		
		var authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
		
		if(authorities.contains(Role.Admin.name())) {
			vo.setType(Type.NONE);
		} else if(authorities.contains(Role.Teacher.name())){
			
			teacherRepo.findOneByEmail(authentication.getName()).ifPresent(teacher -> {
				if(teacher.getCourses().stream().map(Course::getId).toList().contains(vo.getId())) {
					vo.setType(Type.OWN_COURSE);
				} else {
					vo.setType(Type.NONE);
				}
			});
			
		} else if(authorities.contains(Role.Student.name())){
			
			studentRepo.findOneByEmail(authentication.getName()).ifPresent(student -> {
				if(student.getRegistrations().stream().map(Registration::getCourse).map(Course::getId).toList().contains(vo.getId())) {
					vo.setType(Type.ATTEND_COURSE);
				} else {
					vo.setType(Type.PROMOTE);
				}
			});	
			
		} else {
			vo.setType(Type.PROMOTE);
		}
		return vo;
	}


}