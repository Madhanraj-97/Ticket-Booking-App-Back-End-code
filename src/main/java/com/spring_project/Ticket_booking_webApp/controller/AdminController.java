package com.spring_project.Ticket_booking_webApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.spring_project.Ticket_booking_webApp.Dto.AdminDto;
import com.spring_project.Ticket_booking_webApp.Entity.Admin;
import com.spring_project.Ticket_booking_webApp.Entity.Bus;
import com.spring_project.Ticket_booking_webApp.service.AdminSerice;
import com.spring_project.Ticket_booking_webApp.util.ResponseStructure;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	AdminSerice service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(@RequestBody Admin admin) {
		return service.saveAdmin(admin);
		
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<AdminDto>> findAdmin(@RequestParam int id) {
		return service.findAdmin(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<AdminDto>> removeAdmin(@RequestParam int id) {
		return service.deleteAdmin(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(@RequestBody Admin admin,@RequestParam int id) {
		return service.updateAdmin(admin, id);	
	}
	@GetMapping("getall")
	public ResponseEntity<ResponseStructure<List<AdminDto>>> getAllAdmin() {
		return service.getall();
	}
	@GetMapping("login")
	public ResponseEntity<ResponseStructure<AdminDto>> adminLogin(@RequestParam String email, @RequestParam String password ){
		return service.AdminLogin(email, password);
	}
	
	@PutMapping("addbus")
	public ResponseEntity<ResponseStructure<AdminDto>> addBus(@RequestParam int id, @RequestParam String busno){
		return service.addBus(id, busno);
	}
	
	@PutMapping("savebus")
	public ResponseEntity<ResponseStructure<AdminDto>> saveBus(@RequestParam int id,@RequestBody Bus bus){
		return service.saveBus(id, bus);
	}
	@PutMapping("updatebus")
	public ResponseEntity<ResponseStructure<AdminDto>> updateBus(@RequestParam int id,@RequestBody Bus bus){
		return service.modifyBus(id, bus);
	}
	@DeleteMapping("deletebus")
	public ResponseEntity<ResponseStructure<AdminDto>> removeBus(@RequestParam int id) {
		return service.deleteAdmin(id);
	}
}
    