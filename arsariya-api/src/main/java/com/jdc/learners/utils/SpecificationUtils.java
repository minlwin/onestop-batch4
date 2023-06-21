package com.jdc.learners.utils;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class SpecificationUtils {

	public static<T> Specification<T> withFrom(Optional<LocalDate> data) {
		if(data.isPresent()) {
			return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("audit").get("createAt"), data.get().atStartOfDay());
		}
		
		return Specification.where(null);
	}	

	public static<T> Specification<T> withTo(Optional<LocalDate> data) {
		if(data.isPresent()) {
			return (root, query, cb) -> cb.lessThan(root.get("audit").get("createAt"), data.get().plusDays(1).atStartOfDay());
		}
		
		return Specification.where(null);
	}
	
	public static<T> Specification<T> withName(Optional<String> data) {
		if(data.filter(StringUtils::hasLength).isPresent()) {
			return (root, query, cb) -> cb.like(cb.lower(root.get("name")), data.get().toLowerCase().concat("%")); 
		}
		
		return Specification.where(null);		
	}	

}
