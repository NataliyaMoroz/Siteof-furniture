package com.example.university.services;

import com.example.university.dao.User;
import com.example.university.repositories.UserRepository;
import com.example.university.utils.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private SecurityService securityService;

	@Autowired
	private
	UserRepository userRepository;

	@Autowired
	private
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public void loginUser(User user) {
		securityService.autologin(user.getEmail(), user.getHashPassword());
	}

	public void saveNewUser(User user) throws UserAlreadyExistException {
		if (userRepository.findByEmail(user.getEmail()) != null) {
			throw new UserAlreadyExistException();
		}
		userRepository.save(user.withHashPassword(bCryptPasswordEncoder.encode(user.getHashPassword())));
		securityService.autologin(user.getEmail(), user.getHashPassword());
	}

	public User getCurrentUser() {
		return securityService.findLoggedInUsername().withHashPassword("");
	}
}
