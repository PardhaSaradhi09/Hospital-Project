package org.hospital.controllerAdvice;

import java.util.logging.Logger;

import org.hospital.custom.exceptions.PatientIdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@RestControllerAdvice
public class RestAdvice {


	Logger logger = Logger.getLogger(RestAdvice.class.getName());
	
	
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ErrorDetails> resultNotFoundException(EmptyResultDataAccessException ex, WebRequest request){
		ErrorDetails error = new ErrorDetails("Patient id is not found in the database", "400", "Enter valid patient id" , request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(error ,HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorDetails> deleteException(DataIntegrityViolationException ex, WebRequest request){
		ErrorDetails error = new ErrorDetails(ex.getMessage(), "400", "Cannot delete or update a parent row. You must delete the same patient id in the doctor table, then you can the same patient id in the patient table" , request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(error ,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> Exception(Exception ex, WebRequest request){
		ErrorDetails error = new ErrorDetails(ex.getMessage(), "500", "" , request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(error ,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> NoHandlerFoundException(NoHandlerFoundException ex, WebRequest request){
		ErrorDetails error = new ErrorDetails(ex.getMessage(), "404", "Page not found" , request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(error ,HttpStatus.NOT_FOUND);
	}


	
}
