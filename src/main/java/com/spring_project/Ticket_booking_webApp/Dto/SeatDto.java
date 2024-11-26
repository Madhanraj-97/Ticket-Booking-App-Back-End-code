package com.spring_project.Ticket_booking_webApp.Dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring_project.Ticket_booking_webApp.Entity.Bus;
import com.spring_project.Ticket_booking_webApp.Entity.BusSchedule;
import com.spring_project.Ticket_booking_webApp.Entity.Passenger;
import com.spring_project.Ticket_booking_webApp.Entity.Ticket;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Component

public class SeatDto {
	private int id;
	private int seatNo;
	private boolean status;
}
