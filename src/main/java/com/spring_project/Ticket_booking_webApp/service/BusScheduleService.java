package com.spring_project.Ticket_booking_webApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring_project.Ticket_booking_webApp.Dao.BusScheduleDao;
import com.spring_project.Ticket_booking_webApp.Dto.BusScheduleDto;
import com.spring_project.Ticket_booking_webApp.Entity.BusSchedule;
import com.spring_project.Ticket_booking_webApp.util.ResponseStructure;

@Service
public class BusScheduleService {
	@Autowired
	BusScheduleDao dao;
	
	public ResponseEntity<ResponseStructure<BusScheduleDto>> saveSchedule(BusSchedule schedule){
		ResponseStructure<BusScheduleDto> structure=new ResponseStructure<BusScheduleDto>();
		BusSchedule saveSchedule=dao.saveSchedule(schedule);
		if(saveSchedule!=null) {
			structure.setData(dao.scheduleDtoConversion(saveSchedule));
			structure.setMessage("schedule saved success");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<BusScheduleDto>>(structure,HttpStatus.CREATED);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<BusScheduleDto>> findSchedule(int id){
		ResponseStructure<BusScheduleDto> structure=new ResponseStructure<BusScheduleDto>();
		BusSchedule savedSchedule=dao.findById(id);
		if(savedSchedule!=null) {
			structure.setData(dao.scheduleDtoConversion(savedSchedule));
			structure.setMessage("BusSchdule found with given id ");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<BusScheduleDto>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<BusScheduleDto>> deleteSchedule(int id){
		ResponseStructure<BusScheduleDto> structure=new ResponseStructure<BusScheduleDto>();
		BusSchedule savedSchedule=dao.findById(id);
		if(savedSchedule!=null) {
			structure.setData(dao.scheduleDtoConversion(dao.deleteSchedule(id)));
			structure.setMessage("BusSchedule deleted with given id ");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<BusScheduleDto>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<BusScheduleDto>> updateSchedule(int id, BusSchedule schedule){
		ResponseStructure<BusScheduleDto> structure=new ResponseStructure<BusScheduleDto>();
		BusSchedule savedSchedule=dao.findById(id);
		if(savedSchedule!=null) {
			structure.setData(dao.scheduleDtoConversion(dao.updateSchedule(schedule,id)));
			structure.setMessage("BusSchedule update with given details");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<BusScheduleDto>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<List<BusScheduleDto>>> searchBus(String from,String to){
		ResponseStructure<List<BusScheduleDto>> structure=new ResponseStructure<List<BusScheduleDto>>();
		List<BusSchedule> list=dao.searchBus(from, to);
		if(list!=null) {
			List<BusScheduleDto> dto=new ArrayList<BusScheduleDto>();
			for(BusSchedule sc:list) {
				dto.add(dao.scheduleDtoConversion(sc));
			}
			structure.setData(dto);
			structure.setMessage("BusSchedule list found");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<BusScheduleDto>>>(structure,HttpStatus.FOUND);
		}
		else{
			structure.setData(null);
			structure.setMessage("BusSchedule list found");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<BusScheduleDto>>>(structure,HttpStatus.FOUND);
		}
	}
	
	
	
	
}
