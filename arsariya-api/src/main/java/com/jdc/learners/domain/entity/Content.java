package com.jdc.learners.domain.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CONTENT")
@Inheritance(strategy = InheritanceType.JOINED)
@EntityListeners(value = AuditingEntityListener.class)
public abstract class Content {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private ContentType type;
	
	@ManyToOne(optional = false)
	private Lesson lesson;

	private String description;

	private AuditInfo audit = new AuditInfo();

	public enum ContentType {
		Video,
		Pdf,
		Exam
	}

}