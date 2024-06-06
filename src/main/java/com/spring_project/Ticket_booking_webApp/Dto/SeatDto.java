package com.spring_project.Ticket_booking_webApp.Dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring_project.Ticket_booking_webApp.Entity.Bus;
import com.spring_project.Ticket_booking_webApp.Entity.Passenger;

import lombok.Data;

@Data
@Component

public class SeatDto {
	private int seatNo;
	private Passenger passenger;
	@JsonIgnore
	private Bus bus;
}
