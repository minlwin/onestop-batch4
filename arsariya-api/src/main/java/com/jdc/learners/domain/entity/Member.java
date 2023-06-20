package com.jdc.learners.domain.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "MEMBER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Member extends Account {

	private String phone;
	
	@Column(name = "profile_image")
	private String profileImage;

	@Column(name = "regist_at")
	private LocalDate registAt;
	
	protected Member(Role role) {
		super(role);
	}

}