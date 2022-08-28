package dev.boscolo.hrworker.resourcers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.boscolo.hrworker.services.exceptions.DatabaseException;
import dev.boscolo.hrworker.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		StandardError error = new StandardError();
		Integer httpStatus = HttpStatus.NOT_FOUND.value();
		error.setTimestamp(Instant.now());
		error.setStatus(httpStatus);
		error.setError("Resource Not Found");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(httpStatus).body(error);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(ResourceNotFoundException e, HttpServletRequest request) {
		StandardError error = new StandardError();
		Integer httpStatus = HttpStatus.BAD_REQUEST.value();
		error.setTimestamp(Instant.now());
		error.setStatus(httpStatus);
		error.setError("Database excepetion");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(httpStatus).body(error);
	}

}