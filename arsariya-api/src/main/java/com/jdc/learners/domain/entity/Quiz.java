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
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "QUIZ")
@EntityListeners(value = AuditingEntityListener.class)
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String question;

	@Embedded
	@ElementCollection
	@CollectionTable(name = "QUIZ_CHOICES")
	private List<Choice> choices;

	@Column(nullable = false)
	private int point;

	@Embedded
	private AuditInfo audit = new AuditInfo();

}