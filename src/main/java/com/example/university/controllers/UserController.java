package com.example.university.controllers;

import com.example.university.services.UserService;
import com.example.university.utils.UserAlreadyExistException;
import com.example.university.dao.User;
import com.example.university.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/be/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/registration")
	public ResponseEntity registerNewUser(@RequestBody User user) throws UserAlreadyExistException {
		userService.saveNewUser(user);
		return ResponseEntity.ok().build();
	}

	@PostMapping(value = "/login")
	public ResponseEntity loginUser(@RequestBody User user) {
		userService.loginUser(user);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/currentUser")
	public ResponseEntity<User> getCurrentUser() {
		return ResponseEntity.ok(userService.getCurrentUser());
	}
}
