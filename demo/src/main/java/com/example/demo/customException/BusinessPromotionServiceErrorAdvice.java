package com.example.demo.customException;

import java.sql.SQLException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BusinessPromotionServiceErrorAdvice extends ResponseEntityExceptionHandler {


	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ BusinessPromotionServiceException.class, SQLException.class, RuntimeException.class })
	protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
		String bodyOfResponse = "Internal server error";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ BusinessPromotionValidationException.class})
	protected ResponseEntity<Object> handleConflictValidation(Exception ex, WebRequest request) {
		String bodyOfResponse = "Illegal input provided";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

}
