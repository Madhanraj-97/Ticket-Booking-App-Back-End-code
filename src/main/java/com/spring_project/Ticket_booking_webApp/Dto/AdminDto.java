package com.spring_project.Ticket_booking_webApp.Dto;

import java.util.List;

import org.springframework.stereotype.Component;
import com.spring_project.Ticket_booking_webApp.Entity.Bus;
import lombok.Data;
@Component
@Data
public class AdminDto {
	private int id;
	private String operator;
	private String email;
	private List<Bus> bus;
}
