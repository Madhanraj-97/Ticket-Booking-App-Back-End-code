package com.spring_project.Ticket_booking_webApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring_project.Ticket_booking_webApp.Dao.SeatDao;
import com.spring_project.Ticket_booking_webApp.Dto.SeatDto;
import com.spring_project.Ticket_booking_webApp.Entity.Seat;
import com.spring_project.Ticket_booking_webApp.util.ResponseStructure;

@Service
public class SeatService {
	@Autowired
	SeatDao dao;
	
	public ResponseEntity<ResponseStructure<SeatDto>> saveSeat(Seat seat){
		ResponseStructure< SeatDto> structure=new ResponseStructure<SeatDto>();
		Seat saveSeat=dao.saveSeat(seat);
		if(saveSeat!=null) {
			structure.setData(dao.seatDtoConversion(saveSeat));
			structure.setMessage("Seat saved success");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<SeatDto>>(structure,HttpStatus.CREATED);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<SeatDto>> findSeat(int id){
		ResponseStructure<SeatDto> structure=new ResponseStructure<SeatDto>();
		Seat saveSeat=dao.findById(id);
		if(saveSeat!=null) {
			structure.setData(dao.seatDtoConversion(saveSeat));
			structure.setMessage("Seat found with given id ");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<SeatDto>>(structure,HttpStatus.FOUND);
		}
		return null;	
	}
	public ResponseEntity<ResponseStructure<SeatDto>> deleteSeat(int id){
		ResponseStructure<SeatDto> structure=new ResponseStructure<SeatDto>();
		Seat savedSeat=dao.findById(id);
		if(savedSeat!=null) {
			structure.setData(dao.seatDtoConversion(dao.deleteSeat(id)));
			structure.setMessage("Seat deleted with given id ");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<SeatDto>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<SeatDto>> updateSeat(Seat seat,int id){
		ResponseStructure<SeatDto> structure=new ResponseStructure<SeatDto>();
		Seat savedSeat=dao.findById(id);
		if(savedSeat!=null) {
			structure.setData(dao.seatDtoConversion(dao.updateSeat(id, seat)));
			structure.setMessage("Seat updated sucesssfully ");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<SeatDto>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<List<SeatDto>>> getAllSeat(){
		ResponseStructure<List<SeatDto>> structure=new ResponseStructure<List<SeatDto>>();
		List<SeatDto> Seatlist=new ArrayList<SeatDto>();
		for(Seat seat:dao.getAllSeat()) {
			Seatlist.add(dao.seatDtoConversion(seat));
		}
		structure.setData(Seatlist);
		structure.setMessage("found ALL Seat details");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<SeatDto>>>(structure,HttpStatus.FOUND);

	}


}
