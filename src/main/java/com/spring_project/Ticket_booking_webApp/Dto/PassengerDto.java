package com.spring_project.Ticket_booking_webApp.Dto;

import org.springframework.stereotype.Component;

import com.spring_project.Ticket_booking_webApp.Entity.Bus;
import com.spring_project.Ticket_booking_webApp.Entity.Seat;

import lombok.Data;

@Data
@Component
public class PassengerDto {
	private String name;
	private int age;
	private long phoneNo;
	private Seat Seat;
	private Bus bus;
}
 