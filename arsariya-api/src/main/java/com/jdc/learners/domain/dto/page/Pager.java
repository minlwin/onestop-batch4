package com.jdc.learners.domain.dto.page;

import lombok.Data;

@Data
public class Pager {

	public Pager() {
	}

	private int current;

	private int size;

	private long totalCount;

	private long totalPage;

}