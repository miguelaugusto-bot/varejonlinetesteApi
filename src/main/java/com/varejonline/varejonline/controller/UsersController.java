package com.varejonline.varejonline.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varejonline.varejonline.model.Users;
import com.varejonline.varejonline.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService userService;
	
	@GetMapping
	public ResponseEntity<List<Users>> getAll(){	
		return userService.findAll();
	}
	
	 @PostMapping("/login")
	    public ResponseEntity<Users> loginUser(@Valid @RequestBody Users user) {
		 return userService.login(user);
	 }
	 
	 @PostMapping("/logout")
	    public ResponseEntity<Users> logoutUser(@Valid @RequestBody Users user) {
		 return userService.logout(user);
	 }
}
