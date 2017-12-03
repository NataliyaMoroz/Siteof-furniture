package com.example.university;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/be/test")
public class TestController {

	@GetMapping(value = "/authenticated")
	public ResponseEntity testAuthenticated() {
		return ResponseEntity.ok("OK");
	}

	@GetMapping(value = "/unauthenticated")
	public ResponseEntity testUnauthenticated() {
		return ResponseEntity.ok("OK");
	}
}
