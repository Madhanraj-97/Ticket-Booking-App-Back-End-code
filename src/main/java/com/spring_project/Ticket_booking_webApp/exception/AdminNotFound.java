package com.spring_project.Ticket_booking_webApp.exception;

public class AdminNotFound extends RuntimeException {
	String message;

	public AdminNotFound(String message) {
		super();
		this.message = message;
	}
	
}
