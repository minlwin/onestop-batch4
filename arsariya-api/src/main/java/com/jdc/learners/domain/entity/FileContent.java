package com.jdc.learners.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "FILE_CONTENT")
public class FileContent extends Content {

	@Column(nullable = false)
	private String file;

}