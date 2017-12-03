package com.example.university.utils;

public class UserAlreadyExistException extends Exception {
	public UserAlreadyExistException() {
		super("User with this email already exist");
	}
}
