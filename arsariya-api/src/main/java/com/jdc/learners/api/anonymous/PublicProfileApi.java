package com.jdc.learners.api.anonymous;

import static com.jdc.learners.utils.ExceptionUtils.keyNotFound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.learners.domain.dto.ApiResult;
import com.jdc.learners.domain.dto.MemberProfileDto;
import com.jdc.learners.domain.service.MemberProfileService;

@RestController
@RequestMapping("public/profile")
public class PublicProfileApi {

	@Autowired
	private MemberProfileService service;

	@GetMapping
	public ApiResult<MemberProfileDto> getProfile(@RequestParam String loginId) {
		return service.getProfile(loginId).map(ApiResult::success).orElseThrow(() -> keyNotFound("Member", "login id", loginId));
	}

}