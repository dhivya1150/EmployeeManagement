package com.example.project.EmployeeManagement.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
		@ExceptionHandler(ResourceNotFoundException.class)
		public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request)

		{
			ErrorResponse error = new ErrorResponse(
					
					LocalDateTime.now(),
					ex.getMessage(),
					HttpStatus.NOT_FOUND.value(),
					request.getDescription(false)
					 );
			
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler(Exception.class)
			public ResponseEntity <ErrorResponse> handleException(Exception ex,WebRequest request)
		{
			ErrorResponse error = new ErrorResponse(
					
					LocalDateTime.now(),
					ex.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					request.getDescription(false)
					
					);
			
			return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


