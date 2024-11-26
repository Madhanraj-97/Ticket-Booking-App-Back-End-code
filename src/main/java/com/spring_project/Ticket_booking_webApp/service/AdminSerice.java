package com.spring_project.Ticket_booking_webApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring_project.Ticket_booking_webApp.Dao.AdminDao;
import com.spring_project.Ticket_booking_webApp.Dao.BusDao;
import com.spring_project.Ticket_booking_webApp.Dao.BusScheduleDao;
import com.spring_project.Ticket_booking_webApp.Dao.SeatDao;
import com.spring_project.Ticket_booking_webApp.Dto.AdminDto;
import com.spring_project.Ticket_booking_webApp.Entity.Admin;
import com.spring_project.Ticket_booking_webApp.Entity.Bus;
import com.spring_project.Ticket_booking_webApp.Entity.BusSchedule;
import com.spring_project.Ticket_booking_webApp.exception.AdminNotFound;
import com.spring_project.Ticket_booking_webApp.util.ResponseStructure;

@Service
public class AdminSerice {
	@Autowired
	AdminDao dao;
	@Autowired
	BusDao busDao;
	@Autowired
	SeatDao seats;
	@Autowired
	BusScheduleDao scheduleDao;

	public ResponseEntity<ResponseStructure<AdminDto>> deleteBus(int id) {
		Bus bus = busDao.findById(id);

		// get the admin id from bus
		int adminId = bus.getAdmin().getId();

		// response object initialize
		ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();

//		//logic for remove bus from admin object 
		Admin dbAdmin = dao.findById(adminId);

		dbAdmin.setBus(dbAdmin.getBus().stream().filter(b -> b.getId() != bus.getId()).collect(Collectors.toList()));
		dbAdmin = dao.updateAdmin(dbAdmin);
		busDao.deleteBus(id);

		structure.setData(dao.dtoConversion(dbAdmin));
		structure.setMessage("remove bus form admin object sucessfully");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<AdminDto>> saveAdmin(Admin admin) {
		ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();
		Admin savedAdmin = dao.saveAdmin(admin);
		if (savedAdmin != null) {
			structure.setData(dao.dtoConversion(savedAdmin));
			structure.setMessage("Admin saved success");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.CREATED);

		}
		throw new AdminNotFound("Admin not saved");
	}

	public ResponseEntity<ResponseStructure<AdminDto>> findAdmin(int id) {
		ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();
		Admin exAdmin = dao.findById(id);
		if (exAdmin != null) {
			structure.setData(dao.dtoConversion(exAdmin));
			structure.setMessage("admin found with the given id");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.FOUND);
		}
		throw new AdminNotFound("Admin Not Found Given Id");
	}

	public ResponseEntity<ResponseStructure<AdminDto>> deleteAdmin(int id) {
		ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();

		Admin exAdmin = dao.findById(id);
		if (exAdmin != null) {
			structure.setData(dao.dtoConversion(dao.deleteAdmin(id)));
			structure.setMessage("adhar deleted with the given id");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.OK);

		}
		throw new AdminNotFound("Admin Not Found Given Id");
	}

	public ResponseEntity<ResponseStructure<AdminDto>> updateAdmin(Admin admin, int id) {

		ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();

		Admin exAdmin = dao.findById(id);
		if (exAdmin != null) {
			structure.setData(dao.dtoConversion(dao.updateAdmin(admin)));
			structure.setMessage("admin updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.OK);
		}
		throw new AdminNotFound("Admin Not Found Given Id");
	}

	public ResponseEntity<ResponseStructure<List<AdminDto>>> getall() {
		ResponseStructure<List<AdminDto>> structure = new ResponseStructure<List<AdminDto>>();
		List<AdminDto> adminlist = new ArrayList<AdminDto>();
		for (Admin admin : dao.getallAdmin()) {
			adminlist.add(dao.dtoConversion(admin));
		}
		structure.setData(adminlist);
		structure.setMessage("found adhar details");
		structure.setStatus(HttpStatus.FOUND.value());

		return new ResponseEntity<ResponseStructure<List<AdminDto>>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<AdminDto>> AdminLogin(String email, String password) {
		ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();

		Admin exAdmin = dao.adminLogin(email, password);
		if (exAdmin != null) {
			structure.setData(dao.dtoConversion(exAdmin));
			structure.setMessage("admin login successfully");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.OK);
		}
		throw new AdminNotFound("incorrect email or password");
	}

	/* establis relationship between admin and bus with help of busno */

	public ResponseEntity<ResponseStructure<AdminDto>> addBus(int id, String busno) {
		Bus bus = busDao.findByBusNo(busno);
		if (bus != null) {
			ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();
			Admin exAdmin = dao.findById(id);
			if (exAdmin != null) {
				bus.setAdmin(exAdmin);
//				busDao.updateBus(bus, bus.getId());
				List<Bus> buslist = new ArrayList<Bus>(exAdmin.getBus());
				buslist.add(bus);
				exAdmin.setBus(buslist);
				structure.setData(dao.dtoConversion(dao.updateAdmin(exAdmin)));
				structure.setMessage("bus added with admin successfully");
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.OK);
			}
			throw new AdminNotFound("incorrect invalid admin id ");

		}
		throw new AdminNotFound("incorrect bus no ");
	}

	public ResponseEntity<ResponseStructure<AdminDto>> saveBus(int id, Bus bus) {
		ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();
		Admin existAdmin = dao.findById(id);
		if (existAdmin != null) {
			bus.setAdmin(existAdmin);
			bus = busDao.saveBus(bus);
			List<Bus> busList = new ArrayList<Bus>(existAdmin.getBus());
			busList.add(bus);
			existAdmin.setBus(busList);
			dao.updateAdmin(existAdmin);
			structure.setData(dao.dtoConversion(existAdmin));
			structure.setMessage("bus save with admin successfully");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.OK);
		}
		throw new AdminNotFound("save new bus sucessfully");
	}

	public ResponseEntity<ResponseStructure<AdminDto>> modifyBus(int id, Bus bus) {
		ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();
		Bus existingBus = busDao.findById(id);
		bus.setAdmin(existingBus.getAdmin());

		if (bus.getSeatcapacity() != existingBus.getSeatcapacity()) {
			seats.removeBus(id);
			Admin admin = dao.findById(busDao.updateBus(bus).getAdmin().getId());
			seats.deleteSeats();
			structure.setData(dao.dtoConversion(admin));
			structure.setMessage("bus deatails update with admin successfully");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.OK);

		} else {
			Admin admin = dao.findById(busDao.updateBus(bus).getAdmin().getId());

			structure.setData(dao.dtoConversion(admin));
			structure.setMessage("bus deatails update with admin successfully");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.OK);
		}
	}

	public ResponseEntity<ResponseStructure<AdminDto>> saveSchedule(BusSchedule schedule, int id) {
		ResponseStructure<AdminDto> structure = new ResponseStructure<AdminDto>();
		Bus dbBus = busDao.findById(id);
		schedule.setSeat(scheduleDao.seats(dbBus.getSeatcapacity(), schedule));
		schedule.setBus(dbBus);
		List<BusSchedule> schedules=dbBus.getSchedules();
		schedules.add(schedule);
		dbBus.setSchedules(schedules);
		dbBus=busDao.saveBus(dbBus);
		structure.setData(dao.dtoConversion(dbBus.getAdmin()));
		structure.setMessage("schedule deatails updated successfully with bus ");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.OK);
		
	}

}
