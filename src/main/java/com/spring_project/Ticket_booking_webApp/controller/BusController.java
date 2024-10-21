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

import com.spring_project.Ticket_booking_webApp.Dto.BusDto;
import com.spring_project.Ticket_booking_webApp.Entity.Bus;
import com.spring_project.Ticket_booking_webApp.service.BusService;
import com.spring_project.Ticket_booking_webApp.util.ResponseStructure;

@RestController
@RequestMapping("bus")
public class BusController {
	@Autowired
	BusService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<BusDto>> saveBus(@RequestBody Bus bus, @RequestParam int adminId) {
		return service.saveBus(bus,adminId);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<BusDto>> findBus(@RequestParam int id) {
		return service.findBus(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<BusDto>> removeBus(@RequestParam int id) {
		return service.deleteBus(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<BusDto>> updateBus(@RequestBody Bus bus,@RequestParam int id) {
		return service.updateBus(bus, id);	
	}
	@GetMapping("getall")
	public ResponseEntity<ResponseStructure<List<BusDto>>> getAll(){
		return service.getAllBus();
	}
	@GetMapping("getbus")
	public ResponseEntity<ResponseStructure<BusDto>> findByBusno(@RequestParam String busno){
		return service.findByBusno(busno);
	}
}
