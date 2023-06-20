package com.jdc.learners.domain.dto;

import com.jdc.learners.domain.entity.Member;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberProfileDto {

	private int id;

	@NotBlank(message = "Please enter name.")
	private String name;

	@NotBlank(message = "Please enter phone.")
	private String phone;

	@NotBlank(message = "Please enter email.")
	private String email;

	private String image;
	
	public static MemberProfileDto from(Member entity) {
		return new MemberProfileDto(entity.getId(), entity.getName(), entity.getPhone(), entity.getEmail(), entity.getProfileImage());
	}

}