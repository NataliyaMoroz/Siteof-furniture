package com.example.university.services;

import com.example.university.dao.Booking;
import com.example.university.dao.User;
import com.example.university.repositories.BookingRepository;
import com.example.university.repositories.UserRepository;
import com.example.university.utils.UserAlreadyExistException;
import com.example.university.utils.UserIsNotValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private BookingRepository bookingRepository;

	public void loginUser(User user) throws UserIsNotValidException {
		if (notValidUser(user)) throw new UserIsNotValidException();
		securityService.autologin(user.getEmail(), user.getHashPassword());
	}

	private boolean notValidUser(User user) {
		return user.getEmail() == null || user.getHashPassword() == null;
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

	public void submitNewPurchase(Booking purchase) {
		Long userId = getCurrentUser().getId(); // if somehow this statement access without user in session then exception will be thrown
		purchase = purchase.withIdUser(userId);
		bookingRepository.save(purchase);
	}
}
