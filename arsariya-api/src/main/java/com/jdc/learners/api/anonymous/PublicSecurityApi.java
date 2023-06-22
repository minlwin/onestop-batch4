package com.jdc.learners.api.anonymous;

import static com.jdc.learners.utils.ExceptionUtils.keyNotFound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
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

@RestController
@RequestMapping("public/security")
public class PublicSecurityApi {

	@Autowired
	private SecurityService service;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping
	public ApiResult<LoginUserVO> signIn( 
			@RequestBody @Validated SignInForm form, BindingResult result) {
		return internalSignIn(form);
	}
	
	@PostMapping("/teacher")
	public ApiResult<LoginUserVO> teacherSignUp( 
			@RequestBody @Validated TeacherSignUpForm form, BindingResult result) {
		// Create Teacher
		service.create(form);
		
		// Sign In
		return internalSignIn(form.signIn());
	}

	@PostMapping("/student")
	public ApiResult<LoginUserVO> studentSignUp( 
			@RequestBody @Validated StudentSignUpForm form, BindingResult result) {
		// Crate Student
		service.create(form);
		
		// Sign In
		return internalSignIn(form.signIn());
	}
	
	private ApiResult<LoginUserVO> internalSignIn(SignInForm form) {
		// Check User
		var authentication = authenticationManager.authenticate(form.authentication());
		
		// Set Authentication Result to Security Context of current thread
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		// Find Login User
		return service.findLoginUser(form.getEmail()).map(ApiResult::success)
				.orElseThrow(() -> keyNotFound("Account", "email", form.getEmail()));
	}

}