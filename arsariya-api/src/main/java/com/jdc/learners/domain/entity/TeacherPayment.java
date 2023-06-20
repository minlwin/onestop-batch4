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
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "TEACHER_PAYMENT")
@NoArgsConstructor
@RequiredArgsConstructor
public class TeacherPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	private Integer id;

	@ManyToOne(optional = false)
	private Teacher teacher;

	@ManyToOne(optional = false)
	private PaymentType type;

	@Column(name = "account_name", nullable = false)
	@NonNull
	private String accountName;

	@Column(name = "account_number", nullable = false)
	@NonNull
	private String accountNumber;

	@Embedded
	private AuditInfo audit = new AuditInfo();

}