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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring_project.Ticket_booking_webApp.Dto.BusScheduleDto;
import com.spring_project.Ticket_booking_webApp.Dto.UserDto;
import com.spring_project.Ticket_booking_webApp.Entity.User;
import com.spring_project.Ticket_booking_webApp.service.BusScheduleService;
import com.spring_project.Ticket_booking_webApp.service.UserService;
import com.spring_project.Ticket_booking_webApp.util.ResponseStructure;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<UserDto>> saveUser(@RequestBody User User) {
		return service.saveUser(User);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<UserDto>> findUser(@RequestParam int id) {
		return service.findUser(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<UserDto>> removeUser(@RequestParam int id) {
		return service.deleteUser(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<UserDto>> updateUser(@RequestBody User User,@RequestParam int id) {
		return service.updateUser(User, id);	
	}
	@GetMapping("getall")
	public ResponseEntity<ResponseStructure<List<UserDto>>> getAllUser() {
		return service.getAllUser();
	}
	
	@GetMapping("searchbus")
	public ResponseEntity<ResponseStructure<List<BusScheduleDto>>> searchBus(@RequestParam String from,@RequestParam String to ){
		return service.searchBus(from, to);
	}
}
