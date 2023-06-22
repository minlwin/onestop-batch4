package com.jdc.learners.utils;

import jakarta.persistence.EntityNotFoundException;

public class ExceptionUtils {

	public static<T extends Number> EntityNotFoundException idNotFound(String type, T id) {
		return new EntityNotFoundException("There is no %s with id %d.".formatted(type, id));
	}

	public static EntityNotFoundException keyNotFound(String type, String field, String key) {
		return new EntityNotFoundException("There is no %s with %s [%s].".formatted(type, field, key));
	}	
}
