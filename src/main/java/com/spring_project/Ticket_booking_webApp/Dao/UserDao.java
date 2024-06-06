package com.spring_project.Ticket_booking_webApp.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring_project.Ticket_booking_webApp.Dto.UserDto;
import com.spring_project.Ticket_booking_webApp.Entity.User;
import com.spring_project.Ticket_booking_webApp.repositry.UserRepository;

@Repository
public class UserDao {
	@Autowired
	UserRepository repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User findById(int id) {
		Optional<User> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public User deleteUser(int id) {
		User existUser = findById(id);
		if (existUser != null) {
			repo.delete(existUser);
			return existUser;
		} else {
			return null;
		}
	}

	public User updateUser(int id, User user) {
		User existUser = findById(id);
		if (existUser != null) {
			user.setId(id);
			return repo.save(user);
		} else {
			return null;
		}
	}
	public List<User> getAllUser(){
		return repo.findAll();
	}
	
	public UserDto userDtoConversion(User u) {
		UserDto dto=new UserDto();
		dto.setEmail(u.getEmail());
		dto.setName(u.getName());
		dto.setPassengers(u.getPassengers());
		return dto;
	}
}
