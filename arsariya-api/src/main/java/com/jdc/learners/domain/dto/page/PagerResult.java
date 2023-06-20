package com.jdc.learners.domain.dto.page;

import java.util.List;

import lombok.Data;

@Data
public class PagerResult<T> {

	public PagerResult() {
	}

	private Pager pager;

	private List<T> list;

}