package com.jdc.learners.api.anonymous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.learners.domain.dto.ApiResult;
import com.jdc.learners.domain.dto.form.SignInForm;
import com.jdc.learners.domain.dto.form.StudentSignUpForm;
import com.jdc.learners.domain.dto.form.TeacherSignUpForm;
import com.jdc.learners.domain.dto.vo.LoginUserVO;
import com.jdc.learners.domain.service.SecurityService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("public/security")
public class PublicSecurityApi {

	@Autowired
	private SecurityService service;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private SecurityContextRepository securityContextRepository;

	@PostMapping
	public ApiResult<LoginUserVO> signIn(@RequestBody @Validated SignInForm form, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		return internalSignIn(form, request, response);
	}
	
	@PostMapping("/teacher")
	public ApiResult<LoginUserVO> teacherSignUp(@RequestBody @Validated TeacherSignUpForm form, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		service.create(form);
		return internalSignIn(null, request, response);
	}

	@PostMapping("/student")
	public ApiResult<LoginUserVO> studentSignUp(@RequestBody @Validated StudentSignUpForm form, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		service.create(form);
		return internalSignIn(null, request, response);
	}
	
	private ApiResult<LoginUserVO> internalSignIn(SignInForm form, HttpServletRequest request, HttpServletResponse response) {
		var authentication = authenticationManager.authenticate(form.authentication());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		securityContextRepository.saveContext(SecurityContextHolder.getContext(), request, response);
		return null;
	}

}