package com.jdc.learners.domain.dto.vo;

import com.jdc.learners.domain.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryVO {

	private int id;
	private String name;
	
	public static CategoryVO from(Category entity) {
		return new CategoryVO(entity.getId(), entity.getName());
	}

}