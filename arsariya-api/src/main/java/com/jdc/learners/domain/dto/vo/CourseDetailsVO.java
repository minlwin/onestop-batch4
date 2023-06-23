package com.jdc.learners.domain.dto.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.jdc.learners.domain.dto.MemberProfileDto;
import com.jdc.learners.domain.entity.Course;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CourseDetailsVO {
	
	@NonNull
	private Integer id;

	@NonNull
	private String name;

	@NonNull
	private Integer fees;

	@NonNull
	private Integer hours;

	@NonNull
	private String description;

	@NonNull
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime updateAt;
	
	private String image;

	private CategoryVO category;

	private MemberProfileDto teacher;

	private int students;
	
	private Type type;
	
	public enum Type {
		PROMOTE, OWN_COURSE, ATTEND_COURSE, NONE
	}

	
	public static CourseDetailsVO from(Course entity) {
		var vo = new CourseDetailsVO(entity.getId(), entity.getName(), entity.getFees(), entity.getHours(), entity.getDescription(), entity.getAudit().getCreateAt());
		vo.setCategory(CategoryVO.from(entity.getCategory()));
		vo.setTeacher(MemberProfileDto.from(entity.getTeacher()));
		vo.setStudents(entity.getRegistrations().size());
		vo.setImage(entity.getImage());
		return vo;
	}
}