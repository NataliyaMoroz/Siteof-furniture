package com.example.university.controllers.controlleradvices;

import com.example.university.utils.UserAlreadyExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.example")
public class DefaultExceptionHandler {

	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity userExistException(Exception e) {
		return ResponseEntity
				.badRequest()
				.body(e.getMessage());
	}
}
