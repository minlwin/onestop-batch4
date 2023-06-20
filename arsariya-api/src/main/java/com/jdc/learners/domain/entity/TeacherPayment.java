package com.jdc.learners.domain.entity;

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
@Table(name = "TEACHER_PAYMENT")
public class TeacherPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(optional = false)
	private Teacher teacher;

	@ManyToOne(optional = false)
	private PaymentType type;

	@Column(name = "account_name", nullable = false)
	private String accountName;

	@Column(name = "account_number", nullable = false)
	private String accountNumber;

	@Embedded
	private AuditInfo audit = new AuditInfo();

}