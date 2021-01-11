package com.meru.Customer.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseBody
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler{

	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public final ExceptionResponseEntity handleCustomerNotFoundException(CustomerNotFoundException exception, WebRequest request)
	{
		System.out.println("Inside Controller advice");
		ExceptionResponseEntity error = new ExceptionResponseEntity(new Date(), exception.getMessage(), request.getDescription(false));
		return error;
	}
	
	@ExceptionHandler(InvalidRequestException.class)
	public final ResponseEntity<ExceptionResponseEntity> handleInvalidRequestException(InvalidRequestException exception, WebRequest request)
	{
		ExceptionResponseEntity error = new ExceptionResponseEntity(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponseEntity>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponseEntity> handleAllOtherException(Exception exception, WebRequest request)
	{
		ExceptionResponseEntity error = new ExceptionResponseEntity(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponseEntity>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
