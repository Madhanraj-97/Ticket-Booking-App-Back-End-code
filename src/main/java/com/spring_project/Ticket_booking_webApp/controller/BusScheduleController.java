package com.spring_project.Ticket_booking_webApp.controller;

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
import com.spring_project.Ticket_booking_webApp.Dto.BusScheduleDto;
import com.spring_project.Ticket_booking_webApp.Entity.BusSchedule;
import com.spring_project.Ticket_booking_webApp.service.BusScheduleService;
import com.spring_project.Ticket_booking_webApp.util.ResponseStructure;

@RestController
@RequestMapping("schedule")
public class BusScheduleController {
	@Autowired
	BusScheduleService service;
	@PostMapping
	public ResponseEntity<ResponseStructure<BusScheduleDto>> saveSchedule(@RequestBody BusSchedule schedule) {
		System.out.println(schedule);
		return service.saveSchedule(schedule);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<BusScheduleDto>> findSchedule(@RequestParam int id) {
		return service.findSchedule(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<BusScheduleDto>>updateSchedule(@RequestParam int id, @RequestBody BusSchedule schedule){
		return service.updateSchedule(id, schedule);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<BusScheduleDto>>deleteSchedule(@RequestParam int id){
		return service.deleteSchedule(id);
	}

}
