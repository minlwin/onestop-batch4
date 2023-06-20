package com.jdc.learners.domain.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "REGISTRATION")
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(optional = false)
	private Course course;

	@ManyToOne(optional = false)
	private Student student;
	
	@Column(nullable = false)
	private LocalDate registAt;

	@ManyToOne(optional = false)
	private TeacherPayment paymentType;

	@Column(nullable = false)
	private int fees;

	@Column(nullable = false, name ="promotion_code")
	private String promotionCode;

	@Column(nullable = false)
	private int discount;
	
	@Embedded
	private AuditInfo audit = new AuditInfo();

}