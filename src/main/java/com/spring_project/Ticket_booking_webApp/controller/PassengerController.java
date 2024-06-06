package com.spring_project.Ticket_booking_webApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring_project.Ticket_booking_webApp.Dto.PassengerDto;
import com.spring_project.Ticket_booking_webApp.Entity.Passenger;
import com.spring_project.Ticket_booking_webApp.service.PassengerService;
import com.spring_project.Ticket_booking_webApp.util.ResponseStructure;

@RestController
@RequestMapping("passenger")
public class PassengerController {
	
	@Autowired
	PassengerService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<PassengerDto>> savePassenger(@RequestBody Passenger passenger) {
		return service.savePassenger(passenger);
		
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<PassengerDto>> findPassenger(@RequestParam int id) {
		return service.findPassenger(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<PassengerDto>> removePassenger(@RequestParam int id) {
		return service.deletePassenger(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<PassengerDto>> updatePassenger(@RequestBody Passenger passenger,@RequestParam int id) {
		return service.updatePassenger(passenger, id);	
	}
	@GetMapping("getall")
	public ResponseEntity<ResponseStructure<List<PassengerDto>>> getAllPassenger() {
		return service.getAllPassenger();
	}
}
