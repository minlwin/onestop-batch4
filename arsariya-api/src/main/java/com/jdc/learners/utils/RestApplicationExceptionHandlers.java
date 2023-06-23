package com.jdc.learners.utils;

import static com.jdc.learners.domain.dto.ApiResult.authError;
import static com.jdc.learners.domain.dto.ApiResult.businessError;
import static com.jdc.learners.utils.AuthenticationExceptionUtils.resolveMessage;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jdc.learners.domain.dto.ApiResult;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class RestApplicationExceptionHandlers {
	
	@Value("${app.message.access.denied}")
	private String accessDeinedError;

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ApiResult<List<String>> handle(ValidationResultException e) {
		return businessError(e.getMessages());
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ApiResult<List<String>> handle(EntityNotFoundException e) {
		return businessError(List.of(e.getMessage()));
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ApiResult<List<String>> handle(AccessDeniedException e) {
		return businessError(List.of(accessDeinedError));
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ApiResult<List<String>> handle(AuthenticationException e) {
		return authError(List.of(resolveMessage(e)));
	}
	
	
}
