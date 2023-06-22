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
public class CourseAdminVO {

	@NonNull
	private Integer id;

	@NonNull
	private String name;

	@NonNull
	private Integer fees;

	@NonNull
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime createAt;

	private MemberProfileDto teacher;

	private int students;

	private int total;

	private int agentFees;
	
	public static CourseAdminVO from(Course entity) {
		
		var vo = new CourseAdminVO(entity.getId(), entity.getName(), entity.getFees(), entity.getAudit().getCreateAt());
		vo.setTeacher(MemberProfileDto.from(entity.getTeacher()));
		vo.setStudents(entity.getRegistrations().size());
		vo.setTotal(entity.getRegistrations().stream().mapToInt(a -> a.getFees() - a.getDiscount()).sum());
		vo.setAgentFees(entity.getRegistrations().stream().mapToInt(a -> a.getAgentFees()).sum());

		return vo;
	}

}