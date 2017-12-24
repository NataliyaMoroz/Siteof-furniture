package com.example.university.controllers;

import com.example.university.dao.Booking;
import com.example.university.redis.repository.RedisRepository;
import com.example.university.redis.user.UserSettings;
import com.example.university.redis.user.UserSettingsEvelope;
import com.example.university.services.UserService;
import com.example.university.utils.UserAlreadyExistException;
import com.example.university.dao.User;
import com.example.university.utils.UserIsNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/be/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RedisRepository redisRepository;

	@PostMapping(value = "/registration")
	public ResponseEntity registerNewUser(@RequestBody User user) throws UserAlreadyExistException {
		userService.saveNewUser(user);
		return ResponseEntity.ok().build();
	}

	@PostMapping(value = "/login")
	public ResponseEntity loginUser(@RequestBody User user) throws UserIsNotValidException {
		userService.loginUser(user);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/currentUser")
	public ResponseEntity<User> getCurrentUser() {
		return ResponseEntity.ok(userService.getCurrentUser());
	}

	@PostMapping(value = "/buy")
	public ResponseEntity buy(@RequestBody Booking purchase) {
		userService.submitNewPurchase(purchase);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value="/review/{category}/{furnitureId}")
	public ResponseEntity userHasAccessToReviewThisItem(@PathVariable String category, @PathVariable Integer furnitureId) {
		return ResponseEntity.ok(userService.userHasAccessToReviewThisItem(category, furnitureId));
	}

	@GetMapping(value = "/userSettings")
	public ResponseEntity getUserSettings(){
		return ResponseEntity.ok(redisRepository.findUserSettings(userService.getCurrentUser().getId()));
	}

	@PostMapping(value = "/userSettings")
	public ResponseEntity saveUserSettings(@RequestBody UserSettings userSettings) {
		redisRepository.add(new UserSettingsEvelope(userService.getCurrentUser().getId(), userSettings));
		return ResponseEntity.ok().build();
	}
}
