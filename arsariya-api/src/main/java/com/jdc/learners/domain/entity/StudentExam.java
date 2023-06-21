package com.jdc.learners.domain.entity;

import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "STUDENT_EXAM")
@EntityListeners(value = AuditingEntityListener.class)
public class StudentExam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(optional = false)
	private Registration registration;

	@ManyToOne(optional = false)
	private ExamContent exam;

	@ElementCollection
	@CollectionTable(name = "STUDENT_EXAM_RESULT")
	private List<QuizResult> result;

	private int duration;

	@Embedded
	private AuditInfo audit = new AuditInfo();
}