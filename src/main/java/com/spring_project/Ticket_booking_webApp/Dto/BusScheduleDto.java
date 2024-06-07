package com.spring_project.Ticket_booking_webApp.Dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring_project.Ticket_booking_webApp.Entity.Bus;
import lombok.Data;

@Component
@Data
public class BusScheduleDto {
	private String sourceCity;
	private String destinationCity;
	private int distance;
	private String estimatedTime;
	private Bus bus;

}
