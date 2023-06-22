package com.jdc.learners.api.member;

import static com.jdc.learners.utils.ExceptionUtils.keyNotFound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.learners.domain.dto.ApiResult;
import com.jdc.learners.domain.dto.MemberProfileDto;
import com.jdc.learners.domain.service.MemberProfileService;

@RestController
@RequestMapping("member/profile")
public class MemberProfileApi {

	@Autowired
	private MemberProfileService service;
	
	@PostMapping("image")
	public ApiResult<MemberProfileDto> uploadProfileImage(@RequestParam MultipartFile file) {
		return service.uploadProfileImage(file).map(ApiResult::success)
				.orElseThrow(() -> keyNotFound("Member", "email", 
						SecurityContextHolder.getContext().getAuthentication().getName()));
	}

	@PutMapping
	public ApiResult<MemberProfileDto> saveProfile(@RequestBody @Validated MemberProfileDto form, BindingResult result) {
		return service.saveProfile(form).map(ApiResult::success)
				.orElseThrow(() -> keyNotFound("Member", "email", 
						SecurityContextHolder.getContext().getAuthentication().getName()));
	}

}