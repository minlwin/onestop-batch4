package com.jdc.learners.domain.service;

import static com.jdc.learners.utils.SpecificationUtils.withFrom;
import static com.jdc.learners.utils.SpecificationUtils.withTo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.learners.domain.dto.form.PurchaseForm;
import com.jdc.learners.domain.dto.page.PagerResult;
import com.jdc.learners.domain.dto.vo.CourseListVO;
import com.jdc.learners.domain.dto.vo.RegistrationVO;
import com.jdc.learners.domain.dto.vo.StudentAdminVO;
import com.jdc.learners.domain.entity.Student;
import com.jdc.learners.domain.repo.CourseRepo;
import com.jdc.learners.domain.repo.PaymentTypeRepo;
import com.jdc.learners.domain.repo.RegistrationRepo;
import com.jdc.learners.domain.repo.StudentRepo;
import com.jdc.learners.utils.SpecificationUtils;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional(readOnly = true)
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private RegistrationRepo registrationRepo;
	
	@Autowired
	private CourseRepo courseRepo;

	@Autowired
	private PaymentTypeRepo paymentTypeRepo;

	public Optional<List<CourseListVO>> findCourseForStudent(String email) {
		return studentRepo.findOneByEmail(email).map(a -> a.getRegistrations().stream()
				.map(c -> c.getCourse()).map(CourseListVO::from).toList());
	}

	@Transactional
	public RegistrationVO purchaseCourse(PurchaseForm form) {
		
		var student = studentRepo.findOneByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow(EntityNotFoundException::new);
		var course = courseRepo.findById(form.getCourseId()).orElseThrow(EntityNotFoundException::new);
		var paymentType = paymentTypeRepo.findById(form.getPaymentId()).orElseThrow(EntityNotFoundException::new);
		
		var entity = form.entity();
		entity.setStudent(student);
		entity.setCourse(course);
		entity.setPaymentType(paymentType);
		entity.setRegistAt(LocalDate.now());
		
		return RegistrationVO.from(registrationRepo.save(entity));
	}

	public PagerResult<StudentAdminVO> search(Optional<String> name, Optional<LocalDate> from, Optional<LocalDate> to, int current, int size) {
		
		var specification = withName(name).
				and(withFrom(from))
				.and(withTo(to));
		
		var page = studentRepo.findAll(specification, 
				PageRequest.of(current, size)).map(StudentAdminVO::from);
		
		return PagerResult.from(page);
	}
	
	private Specification<Student> withName(Optional<String> data) {
		return SpecificationUtils.withName(data);
	}
	
}