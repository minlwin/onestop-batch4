package com.jdc.learners.domain.entity;

import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "COURSE")
@EntityListeners(value = AuditingEntityListener.class)
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@ManyToOne(optional = false)
	private Teacher teacher;

	@ManyToOne(optional = false)
	private Category category;

	private String image;

	private int hours;

	private int fees;
	
	private int agentFees;

	private String description;

	@ElementCollection
	@CollectionTable(name = "COURSE_OBJECTIVES")
	private List<String> objectives;
	
	@Embedded
	private AuditInfo audit = new AuditInfo();

	@OneToMany(mappedBy = "course")
	private List<Registration> registrations;

}