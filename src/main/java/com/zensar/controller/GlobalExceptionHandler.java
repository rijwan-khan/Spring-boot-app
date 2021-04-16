package com.zensar.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.zensar.exception.CustomErrorDetails;
import com.zensar.exception.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException userNotFoundException,
			WebRequest request) {

		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), userNotFoundException.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(customErrorDetails, HttpStatus.NOT_FOUND);

	}
}
