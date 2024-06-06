package com.spring_project.Ticket_booking_webApp.Dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring_project.Ticket_booking_webApp.Entity.Passenger;

import lombok.Data;

@Data
@Component
public class UserDto {
	private String name;
	private String email;
	private List<Passenger> passengers;

}
