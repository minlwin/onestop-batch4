package com.jdc.learners.domain.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "QUIZ_RESULT")
public class QuizResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(optional = false)
	private StudentExam exam;

	@ManyToOne(optional = false)
	private Quiz quiz;

	@ElementCollection
	@CollectionTable(name = "QUIZ_RESULT_ANSWERS")
	private List<String> answers;

}