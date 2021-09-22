package com.varejonline.varejonline.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.varejonline.varejonline.model.Users;
import com.varejonline.varejonline.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	public ResponseEntity<List<Users>> findAll(){
		List<Users> listUsers = usersRepository.findAll();
		return ResponseEntity.status(200).body(listUsers);
	}
	
	public ResponseEntity<Users> login(Users user){
	    List<Users> users = usersRepository.findAll();
	        for (Users other : users) {
	            if (other.equals(user)) {
	                user.setLoggedIn(true);
	                user.setType_user(other.getType_user());
	                user.setId(other.getId());
	                usersRepository.save(user);
	                return ResponseEntity.status(200).build();
	            }
	        }
	        return ResponseEntity.status(404).build();
	}
	
	public ResponseEntity<Users> logout(Users user) {
		List<Users> users = usersRepository.findAll();
			for (Users other : users) {
				if (other.equals(user)) {
					user.setLoggedIn(false);
					user.setType_user(other.getType_user());
					user.setId(other.getId());
					usersRepository.save(user);
					return ResponseEntity.status(200).build();
				}
			}
			return ResponseEntity.status(404).build();
	}
}
