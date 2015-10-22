package net.wmann.cloud.storage.webservice.controller;

import javax.servlet.http.HttpServletRequest;

import net.wmann.cloud.storage.webservice.Error;
import net.wmann.cloud.storage.webservice.exception.DuplicateEmailException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<Integer> illegalArgument(HttpServletRequest req, Exception e) {
		return new ResponseEntity<>(Error.INVALID_ARGUMENTS.getCode(), HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(value = DuplicateEmailException.class)
    public ResponseEntity<Integer> duplicateEmail(HttpServletRequest req, Exception e) {
		return new ResponseEntity<>(Error.DUPLICATE_USER.getCode(), HttpStatus.BAD_REQUEST);
    }

}
