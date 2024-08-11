package com.firstSpringBoot.restApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Response status can be configured using @ResponseStatus tag
 * Multiple HttpStatus can be configured as required
 * e.g.
 * 
 * NOT_FOUND - 404
 * CREATED - 201
 * CONTINUE
 * BAD_GATEWAY
 * .
 * .
 * .
 * 
 * If not configured default code is 500 Internal Server Error
 * 
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(String message) {
		super(message);
	}

}