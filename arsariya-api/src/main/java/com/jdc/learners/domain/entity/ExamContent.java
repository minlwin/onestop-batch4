package com.jdc.learners.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "EXAM_CONTENT")
public class ExamContent extends Content {

	@Column(nullable = false)
	private int quizCount;

	@Column(nullable = false)
	private int minutes;

	@Column(nullable = false)
	private int passingPoint;

}