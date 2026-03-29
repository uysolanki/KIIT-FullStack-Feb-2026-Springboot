package com.kiit.lms.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kiit.lms.controller.ProductController;
import com.kiit.lms.response.APIError;


@ControllerAdvice
@RestControllerAdvice(assignableTypes = {
		ProductController.class
	})
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<APIError>> handleValidationExceptions(MethodArgumentNotValidException ex) 
	{
	 	List<APIError> errors = new ArrayList<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) 
		{
		APIError apiError = new APIError(error.getDefaultMessage(), error.getField(), error.getRejectedValue());
		errors.add(apiError);
		}
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<String> handleResourseMissingExceptions(ResourseNotFoundException ex) 
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
