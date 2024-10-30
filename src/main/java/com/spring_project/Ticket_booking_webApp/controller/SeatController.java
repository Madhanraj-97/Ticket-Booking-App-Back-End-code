package com.spring_project.Ticket_booking_webApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring_project.Ticket_booking_webApp.Dto.SeatDto;
import com.spring_project.Ticket_booking_webApp.Entity.Seat;
import com.spring_project.Ticket_booking_webApp.service.SeatService;
import com.spring_project.Ticket_booking_webApp.util.ResponseStructure;

@RestController
@RequestMapping("seat")
public class SeatController {
	
	@Autowired
	SeatService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<SeatDto>> saveSeat(@RequestBody Seat seat) {
		return service.saveSeat(seat);
		
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<SeatDto>> findSeat(@RequestParam int id) {
		return service.findSeat(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<SeatDto>> removeSeat(@RequestParam int id) {
		return service.deleteSeat(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<SeatDto>> updateSeat(@RequestBody Seat seat,@RequestParam int id) {
		return service.updateSeat(seat, id);	
	}
	@GetMapping("getall")
	public ResponseEntity<ResponseStructure<List<SeatDto>>> getAllSeat() {
		return service.getAllSeat();
	}
	
	@DeleteMapping("deleteseats")
	public ResponseEntity<ResponseStructure<Integer>> deleteAllSeats(){
		return service.deleteSeatsWithoutBus();
	}
}

