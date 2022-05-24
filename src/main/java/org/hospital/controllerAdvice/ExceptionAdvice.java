package org.hospital.controllerAdvice;

import java.util.logging.Logger;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionAdvice {
	
	
	Logger logger = Logger.getLogger(ExceptionAdvice.class.getName());
	
	@ExceptionHandler(value=Exception.class)
	public String handleException(Exception e, Model mv) {
		logger.info("error is"+e.getMessage());
		e.printStackTrace();
		//mv.addAttribute("error", e.getMessage());
		return "error";
	}
	
	@ExceptionHandler( {EmptyResultDataAccessException.class})
	public String resultNotFoundException(EmptyResultDataAccessException e, Model mv) {
		logger.info("error is"+e.getMessage());
		mv.addAttribute("emptyResult", "Result not found in the database. Please enter valid patient id");
		return "error";
	}
	
	@ExceptionHandler(value=DataIntegrityViolationException.class)
	public String deleteException(DataIntegrityViolationException e, Model mv) {
		logger.info("error is"+e.getMessage());
		mv.addAttribute("deleteError", "Cannot delete or update a parent row. You must delete the same patient id in the doctor table, then you can the same patient id in the patient table ");
		return "error";
	}
	
	@ExceptionHandler( {NumberFormatException.class, BindException.class})
	public String resultNotFound(NumberFormatException e, Model mv) {
		logger.info("error is"+e.getLocalizedMessage());
		mv.addAttribute("NumberFormatException", "error is for input string. please enter valid patient id");
		return "error";
	}
	
	@ExceptionHandler(value= {ConversionFailedException.class})
	public String NotFound(NumberFormatException e, Model mv) {
		logger.info("error is"+e.getLocalizedMessage());
		mv.addAttribute("date", "date not");
		return "error";
	}
	
	@ExceptionHandler(value= {IllegalStateException.class})
	public String dNotFound(NumberFormatException e, Model mv) {
		logger.info("error is"+e.getLocalizedMessage());
		mv.addAttribute("date", "date not");
		return "error";
	}
	


}
