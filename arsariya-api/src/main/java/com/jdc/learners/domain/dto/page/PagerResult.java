package com.jdc.learners.domain.dto.page;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Data;

@Data
public class PagerResult<T> {

	private Pager pager;
	private List<T> list;
	
	public static<T> PagerResult<T> from(Page<T> page) {
		var result = new PagerResult<T>();
		result.setList(page.getContent());
		result.pager = Pager.builder()
				.current(page.getNumber())
				.size(page.getSize())
				.totalPage(page.getTotalPages())
				.totalCount(page.getTotalElements())
				.build();
		return result;
	}

}