package com.spring_project.Ticket_booking_webApp.Dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring_project.Ticket_booking_webApp.Entity.BusSchedule;
import com.spring_project.Ticket_booking_webApp.Entity.Seat;

import lombok.Data;
@Data
@Component
public class BusDto {
	private String busno;
	private int seatcapacity;
	private String operator;
	private String ac;
	private BusSchedule schedule;
	private Seat [] seat=new Seat [seatcapacity];
}
 