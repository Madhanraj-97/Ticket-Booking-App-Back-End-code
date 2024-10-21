package com.spring_project.Ticket_booking_webApp.service;

import java.util.ArrayList;
import java.util.List;import org.hibernate.query.sqm.mutation.internal.temptable.BeforeUseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring_project.Ticket_booking_webApp.Dao.BusDao;
import com.spring_project.Ticket_booking_webApp.Dto.AdminDto;
import com.spring_project.Ticket_booking_webApp.Dto.BusDto;
import com.spring_project.Ticket_booking_webApp.Entity.Bus;
import com.spring_project.Ticket_booking_webApp.Entity.Seat;
import com.spring_project.Ticket_booking_webApp.util.ResponseStructure;

@Service
public class BusService {
	@Autowired
	BusDao dao;
	
	public ResponseEntity<ResponseStructure<BusDto>> saveBus(Bus bus,int adminId){
		ResponseStructure<BusDto> structure=new ResponseStructure<BusDto>();
		Bus savedBus=dao.saveBus(bus,adminId);
		if(savedBus!=null) {
			structure.setData(dao.busDtoConversion(savedBus));
			structure.setMessage("Bus saved success");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<BusDto>>(structure,HttpStatus.CREATED);
		}
		return null;
		
	}
	
	/* Find bus with id */
	
	public ResponseEntity<ResponseStructure<BusDto>> findBus(int id){
		ResponseStructure<BusDto> structure=new ResponseStructure<BusDto>();
		Bus savedBus=dao.findById(id);
		if(savedBus!=null) {
			structure.setData(dao.busDtoConversion(savedBus));
			structure.setMessage("Bus found with given id ");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<BusDto>>(structure,HttpStatus.FOUND);
		}
		return null;
		
	}
	
	public ResponseEntity<ResponseStructure<BusDto>> deleteBus(int id){
		ResponseStructure<BusDto> structure=new ResponseStructure<BusDto>();
		Bus savedBus=dao.findById(id);
		if(savedBus!=null) {
			structure.setData(dao.busDtoConversion(dao.deleteBus(id)));
			structure.setMessage("Bus deleted with given id ");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<BusDto>>(structure,HttpStatus.OK);
		}
		return null;
	}
	
	
	public ResponseEntity<ResponseStructure<BusDto>> updateBus(Bus bus,int id){
		ResponseStructure<BusDto> structure=new ResponseStructure<BusDto>();
		Bus savedBus=dao.findById(id);
		if(savedBus!=null) {
			structure.setData(dao.busDtoConversion(dao.updateBus(bus, id)));
			structure.setMessage("Bus updated sucesssfully ");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<BusDto>>(structure,HttpStatus.OK);
		}
		return null;
		
	}
	
	public ResponseEntity<ResponseStructure<List<BusDto>>> getAllBus(){
		ResponseStructure<List<BusDto>> structure=new ResponseStructure<List<BusDto>>();
		List<BusDto> buslist=new ArrayList<BusDto>();
		for(Bus bus:dao.getAllBus()) {
			buslist.add(dao.busDtoConversion(bus));
		}
		structure.setData(buslist);
		structure.setMessage("found bus details");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<BusDto>>>(structure,HttpStatus.FOUND);

	}
	/* Find bus with Busno */
	
	public ResponseEntity<ResponseStructure<BusDto>> findByBusno(String Busno){
		ResponseStructure<BusDto> structure=new ResponseStructure<BusDto>();
		Bus savedBus=dao.findByBusNo(Busno);
		if(savedBus!=null) {
			structure.setData(dao.busDtoConversion(savedBus));
			structure.setMessage("Bus found with given Busno ");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<BusDto>>(structure,HttpStatus.FOUND);
		}
		return null;
	}
}