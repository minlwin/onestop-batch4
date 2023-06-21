package com.jdc.learners.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class JwtTokenAdvice implements ResponseBodyAdvice<Object>{

	@Value("${app.jwt.token.name}")
	private String tokenName;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		
		// Extract Authentication Result from Security Context of current thread
		var auth = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());
		
		// Generate token from authentication result
		tokenProvider.generateToken(auth).ifPresent(token -> {
			
			// Type Cast for writable headers
			if(response instanceof ServletServerHttpResponse resp) {
				
				// Add Token to Response header
				resp.getHeaders().add(tokenName, token);
			}
		});
		
		return body;
	}


}