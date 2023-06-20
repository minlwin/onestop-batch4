package com.jdc.learners.domain.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Student extends Member {

	@OneToMany(mappedBy = "student")
	private List<Registration> registrations;
	
	public Student() {
		super(Role.Student);
	}

}