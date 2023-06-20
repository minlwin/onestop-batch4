package com.jdc.learners.domain.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Teacher extends Member {

	@OneToMany(mappedBy = "teacher")
	private List<TeacherPayment> payments;

	@OneToMany(mappedBy = "teacher")
	private List<Course> courses;
	
	public Teacher() {
		super(Role.Teacher);
	}
	
}