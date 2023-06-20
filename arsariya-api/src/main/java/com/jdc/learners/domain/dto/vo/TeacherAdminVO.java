package com.jdc.learners.domain.dto.vo;

import java.time.LocalDate;

import com.jdc.learners.domain.entity.Teacher;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class TeacherAdminVO {

	@NonNull
	private Integer id;

	@NonNull
	private String name;

	@NonNull
	private String email;

	@NonNull
	private String phone;

	@NonNull
	private LocalDate registAt;

	private long courseCount;

	private long totalFees;

	private long agentFees;

	private long netAward;
	
	public static TeacherAdminVO from(Teacher entity) {
		var vo = new TeacherAdminVO(entity.getId(), entity.getName(), entity.getEmail(), entity.getPhone(), entity.getRegistAt());
		vo.setCourseCount(entity.getCourses().size());
		entity.getCourses().stream().forEach(course -> {
			vo.setTotalFees(course.getRegistrations().stream().mapToInt(a -> a.getFees()).sum());
			vo.setAgentFees(course.getRegistrations().stream().mapToInt(a -> a.getAgentFees()).sum());
			vo.setNetAward(course.getRegistrations().stream().mapToInt(a -> a.getFees() - a.getDiscount()).sum() - vo.getAgentFees());
		});
		return vo;
	}

}