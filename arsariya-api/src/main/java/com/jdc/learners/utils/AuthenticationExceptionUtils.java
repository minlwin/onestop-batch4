package com.jdc.learners.utils;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthenticationExceptionUtils {

	public static String resolveMessage(AuthenticationException e) {
		
		var message = "Authentication fails. Please login again.";

		if(e instanceof UsernameNotFoundException) {
			message = "Please check your login id.";
		} else if (e instanceof BadCredentialsException) {
			message = "Please check your password.";
		} else if (e instanceof AccountExpiredException) {
			message = "You can't login because your account is expired.";
		} else if (e instanceof DisabledException) {
			message = "You can't login because your account is disabled.";
		}
		return message;
	}
}
