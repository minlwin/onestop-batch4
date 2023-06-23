package com.jdc.learners.domain.dto.vo;

import com.jdc.learners.domain.dto.MemberProfileDto;
import com.jdc.learners.domain.entity.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class CourseListVO {

	@NonNull
	private Integer id;

	@NonNull
	private String name;

	@NonNull
	private Integer fees;

	@NonNull
	private Integer hours;
	
	private String image;

	private CategoryVO category;

	private MemberProfileDto teacher;
	
	public static CourseListVO from(Course entity) {
		var vo = new CourseListVO(entity.getId(), entity.getName(), entity.getFees(), entity.getHours());
		vo.setCategory(CategoryVO.from(entity.getCategory()));
		vo.setTeacher(MemberProfileDto.from(entity.getTeacher()));
		vo.setImage(entity.getImage());
		return vo;
	}

}