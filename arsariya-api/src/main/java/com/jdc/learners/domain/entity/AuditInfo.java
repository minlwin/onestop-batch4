package com.jdc.learners.domain.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AuditInfo {

	private boolean deleted;

	private LocalDateTime createAt;

	private String createBy;

	private LocalDateTime updateAt;

	private String updateBy;

}