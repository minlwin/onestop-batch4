package com.jdc.learners.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Choice {

	@Column(nullable = false, name = "option_key")
	private String option;

	@Column(nullable = false)
	private String value;

	private boolean answer;

}