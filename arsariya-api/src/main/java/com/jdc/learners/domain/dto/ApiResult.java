package com.jdc.learners.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult<T> {


	private ApiStatus status;
	private T result;

	public enum ApiStatus {
		Success,
		Business,
		Auth
	}
	
	public static<T> ApiResult<T> success(T data) {
		return new ApiResult<T>(ApiStatus.Success, data);
	}

	public static<T> ApiResult<T> businessError(T data) {
		return new ApiResult<T>(ApiStatus.Business, data);
	}

	public static<T> ApiResult<T> authError(T data) {
		return new ApiResult<T>(ApiStatus.Auth, data);
	}
}