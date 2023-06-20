package com.jdc.learners.api.member;

import org.springframework.web.multipart.MultipartFile;

import com.jdc.learners.domain.dto.ApiResult;
import com.jdc.learners.domain.dto.MemberProfileDto;
import com.jdc.learners.domain.service.MemberProfileService;

public class MemberProfileApi {

	private MemberProfileService service;
	
	public ApiResult<MemberProfileDto> uploadProfileImage(MultipartFile file) {
		// TODO implement here
		return null;
	}

	public ApiResult<MemberProfileDto> saveProfile(MemberProfileDto form) {
		// TODO implement here
		return null;
	}

}