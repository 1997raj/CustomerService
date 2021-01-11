package com.meru.Customer.exception;

public class InvalidRequestException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5107989374456751816L;

	public InvalidRequestException(final String exceptionMessage)
	{
		super("Invalid request : "+exceptionMessage);
	}
}
