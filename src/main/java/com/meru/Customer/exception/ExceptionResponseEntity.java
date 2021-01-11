package com.meru.Customer.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponseEntity {


	public ExceptionResponseEntity(Date timestamp, String errorMessage, String requestUrl) {
		super();
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
		this.requestUrl = requestUrl;
	}

	private Date timestamp;
	
	private String errorMessage;
	
	private String requestUrl;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
}
