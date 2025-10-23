package com.example.project.EmployeeManagement.Exception;

import java.time.LocalDateTime;

public class ErrorResponse 
{
	private LocalDateTime timestamp;
	private String message;
	private int statuscode;
	private String details;
	
	public ErrorResponse(LocalDateTime timestamp, String message, int statuscode, String details) 
	{
		this.timestamp = timestamp;
		this.message = message;
		this.statuscode = statuscode;
		this.details = details;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public String getDetails() {
		return details;
	}
	
	
	
	

}




