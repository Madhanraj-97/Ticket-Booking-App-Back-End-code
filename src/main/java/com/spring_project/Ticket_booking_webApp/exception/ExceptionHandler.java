package com.spring_project.Ticket_booking_webApp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring_project.Ticket_booking_webApp.util.ResponseStructure;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;


@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> AdminNotFound(AdminNotFound e){
		ResponseStructure<String> structure= new ResponseStructure<String>();
		structure.setMessage("A Not present with the given ID");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);	
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	protected ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
		
		ResponseStructure<Object> structure = new ResponseStructure<Object>();
		Map<String,String> hash = new HashMap<String,String>();
		
		for(ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			String field = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			hash.put(field, message);
		}
		structure.setMessage("add proper details");
		structure.setData(hash);
		structure.setStatus(HttpStatus.FORBIDDEN.value());
		
		return new ResponseEntity<Object>(structure,HttpStatus.FORBIDDEN);
		
		
	}
}
