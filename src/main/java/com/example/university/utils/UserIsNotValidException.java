package com.example.university.utils;

public class UserIsNotValidException extends Exception {
	public UserIsNotValidException() {
		super("Provided User has incorrect data");
	}
}
