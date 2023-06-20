package com.jdc.learners.domain.dto.vo;

import com.jdc.learners.domain.entity.Account;
import com.jdc.learners.domain.entity.Account.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserVO {

	private int id;

	private String name;

	private String email;

	private Role role;
	
	public static LoginUserVO from(Account entity) {
		return new LoginUserVO(entity.getId(), entity.getName(), entity.getEmail(), entity.getRole());
	}

}