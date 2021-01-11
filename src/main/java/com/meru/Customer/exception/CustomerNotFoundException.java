package com.meru.Customer.exception;

public class CustomerNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(final String exceptionMessage)
	{
		super(exceptionMessage);
	}

}
