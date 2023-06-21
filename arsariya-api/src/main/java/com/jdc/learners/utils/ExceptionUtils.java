package com.jdc.learners.utils;

import jakarta.persistence.EntityNotFoundException;

public class ExceptionUtils {

	public static<T extends Number> EntityNotFoundException idNotFound(Class<?> type, T id) {
		return new EntityNotFoundException("There is no %s with id %d.".formatted(type.getSimpleName(), id));
	}

	public static EntityNotFoundException keyNotFound(Class<?> type, String field, String key) {
		return new EntityNotFoundException("There is no %s with %s [%s].".formatted(type.getSimpleName(), field, key));
	}	
}
