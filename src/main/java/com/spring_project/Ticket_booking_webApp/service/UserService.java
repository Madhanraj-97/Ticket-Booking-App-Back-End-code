package com.spring_project.Ticket_booking_webApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring_project.Ticket_booking_webApp.Dao.BusScheduleDao;
import com.spring_project.Ticket_booking_webApp.Dao.UserDao;
import com.spring_project.Ticket_booking_webApp.Dto.BusScheduleDto;
import com.spring_project.Ticket_booking_webApp.Dto.UserDto;
import com.spring_project.Ticket_booking_webApp.Entity.BusSchedule;
import com.spring_project.Ticket_booking_webApp.Entity.User;
import com.spring_project.Ticket_booking_webApp.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	UserDao dao;
	@Autowired
	BusScheduleDao scheduleDao;
	
	public ResponseEntity<ResponseStructure<UserDto>> saveUser(User user){
		ResponseStructure< UserDto> structure=new ResponseStructure<UserDto>();
		User saveUser=dao.saveUser(user);
		if(saveUser!=null) {
			structure.setData(dao.userDtoConversion(saveUser));
			structure.setMessage("User saved success");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.CREATED);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<UserDto>> findUser(int id){
		ResponseStructure<UserDto> structure=new ResponseStructure<UserDto>();
		User saveUser=dao.findById(id);
		if(saveUser!=null) {
			structure.setData(dao.userDtoConversion(saveUser));
			structure.setMessage("User found with given id ");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.FOUND);
		}
		return null;	
	}
	public ResponseEntity<ResponseStructure<UserDto>> deleteUser(int id){
		ResponseStructure<UserDto> structure=new ResponseStructure<UserDto>();
		User savedUser=dao.findById(id);
		if(savedUser!=null) {
			structure.setData(dao.userDtoConversion(dao.deleteUser(id)));
			structure.setMessage("User deleted with given id ");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<UserDto>> updateUser(User user,int id){
		ResponseStructure<UserDto> structure=new ResponseStructure<UserDto>();
		User savedUser=dao.findById(id);
		if(savedUser!=null) {
			structure.setData(dao.userDtoConversion(dao.updateUser(id, user)));
			structure.setMessage("User updated sucesssfully ");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<UserDto>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<List<UserDto>>> getAllUser(){
		ResponseStructure<List<UserDto>> structure=new ResponseStructure<List<UserDto>>();
		List<UserDto> Userlist=new ArrayList<UserDto>();
		for(User User:dao.getAllUser()) {
			Userlist.add(dao.userDtoConversion(User));
		}
		structure.setData(Userlist);
		structure.setMessage("found ALL User details");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<UserDto>>>(structure,HttpStatus.FOUND);
	}
	public ResponseEntity<ResponseStructure<List<BusScheduleDto>>> searchBus(String from,String to){
		ResponseStructure<List<BusScheduleDto>> structure=new ResponseStructure<List<BusScheduleDto>>();
		List<BusSchedule> list=scheduleDao.searchBus(from, to);
		if(list!=null) {
			List<BusScheduleDto> dto=new ArrayList<BusScheduleDto>();
			for(BusSchedule sc:list) {
				dto.add(scheduleDao.scheduleDtoConversion(sc));
			}
			structure.setData(dto);
			structure.setMessage("BusSchedule list found");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<BusScheduleDto>>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	
}
