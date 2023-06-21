package com.jdc.learners.utils;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdc.learners.domain.dto.ApiResult;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RestSecurityExceptionHandler implements AccessDeniedHandler, AuthenticationEntryPoint{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		writeResponse(response, ApiResult.authError(List.of("You can't access to this request.")));
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		writeResponse(response, ApiResult.authError(List.of("You need to login for this request.")));
	}
	
	private void writeResponse(HttpServletResponse response, ApiResult<List<String>> message) throws IOException {
		var mapper = new ObjectMapper();
		var result = mapper.writeValueAsString(message);
		response.setStatus(HttpStatus.FORBIDDEN.value());
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(result);
	}
	
}
