package com.spring_project.Ticket_booking_webApp.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring_project.Ticket_booking_webApp.Dto.AdminDto;
import com.spring_project.Ticket_booking_webApp.Entity.Admin;
import com.spring_project.Ticket_booking_webApp.repositry.AdminRepository;

@Repository
public class AdminDao {
	@Autowired
	AdminRepository repo;

	public Admin saveAdmin(Admin admin) {
		return repo.save(admin);
	}

	public Admin findById(int id) {
		Optional<Admin> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public Admin deleteAdmin(int id) {
		Admin admin = findById(id);
		if (admin != null) {
			repo.delete(admin);
			return admin;
		} else {
			return null;
		}
	}

	public Admin updateAdmin(Admin admin) {
			return repo.save(admin);
	}

	public List<Admin> getallAdmin() {
		return repo.findAll();
	}

	public AdminDto dtoConversion(Admin admin) {
		AdminDto dto = new AdminDto();
		dto.setId(admin.getId());
		dto.setBus(admin.getBus());
		dto.setEmail(admin.getEmail());
		dto.setOperator(admin.getOperator());
		return dto;

	}

	public Admin adminLogin(String email, String password) {
		return repo.findByEmailAndPassword(email, password);		
	}

}
