package com.wal.monkeys.exception;

import java.util.Date;

public class ExceptionResponse {
	
	private Date TimeStamp;
	private String message;
	private String details;
	public ExceptionResponse(Date timeStamp, String message, String details) {
		super();
		TimeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}
	
	public Date getTimeStamp() {
		return TimeStamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	
	

}
