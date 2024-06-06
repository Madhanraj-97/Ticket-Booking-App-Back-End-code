package com.spring_project.Ticket_booking_webApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring_project.Ticket_booking_webApp.Dao.PassengerDao;
import com.spring_project.Ticket_booking_webApp.Dto.PassengerDto;
import com.spring_project.Ticket_booking_webApp.Entity.Passenger;
import com.spring_project.Ticket_booking_webApp.util.ResponseStructure;

@Service
public class PassengerService {
	@Autowired
	PassengerDao dao;
	
	public ResponseEntity<ResponseStructure<PassengerDto>> savePassenger(Passenger passenger){
		ResponseStructure< PassengerDto> structure=new ResponseStructure<PassengerDto>();
		Passenger savePassenger=dao.savePassenger(passenger);
		if(savePassenger!=null) {
			structure.setData(dao.passengerDtoConversion(savePassenger));
			structure.setMessage("Passenger saved success");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<PassengerDto>>(structure,HttpStatus.CREATED);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<PassengerDto>> findPassenger(int id){
		ResponseStructure<PassengerDto> structure=new ResponseStructure<PassengerDto>();
		Passenger savePassenger=dao.findById(id);
		if(savePassenger!=null) {
			structure.setData(dao.passengerDtoConversion(savePassenger));
			structure.setMessage("Passenger found with given id ");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<PassengerDto>>(structure,HttpStatus.FOUND);
		}
		return null;	
	}
	public ResponseEntity<ResponseStructure<PassengerDto>> deletePassenger(int id){
		ResponseStructure<PassengerDto> structure=new ResponseStructure<PassengerDto>();
		Passenger savedPassenger=dao.findById(id);
		if(savedPassenger!=null) {
			structure.setData(dao.passengerDtoConversion(dao.deletePassenger(id)));
			structure.setMessage("Passenger deleted with given id ");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<PassengerDto>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<PassengerDto>> updatePassenger(Passenger passenger,int id){
		ResponseStructure<PassengerDto> structure=new ResponseStructure<PassengerDto>();
		Passenger savedPassenger=dao.findById(id);
		if(savedPassenger!=null) {
			structure.setData(dao.passengerDtoConversion(dao.updatePassenger(id, passenger)));
			structure.setMessage("Passenger updated sucesssfully ");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<PassengerDto>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<List<PassengerDto>>> getAllPassenger(){
		ResponseStructure<List<PassengerDto>> structure=new ResponseStructure<List<PassengerDto>>();
		List<PassengerDto> Passengerlist=new ArrayList<PassengerDto>();
		for(Passenger Passenger:dao.getAllPassenger()) {
			Passengerlist.add(dao.passengerDtoConversion(Passenger));
		}
		structure.setData(Passengerlist);
		structure.setMessage("found ALL Passenger details");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<PassengerDto>>>(structure,HttpStatus.FOUND);

	}


}
