package com.example.university.controllers;

import com.example.university.dao.User;
import com.example.university.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping(value = "/save")
	public ResponseEntity saveUser(@RequestBody User user) {
		userRepository.save(user);
		return ResponseEntity.ok().build();
	}
}
