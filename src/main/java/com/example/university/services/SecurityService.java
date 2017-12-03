package com.example.university.services;

import com.example.university.dao.User;
import com.example.university.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService authenticationService;

	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(SecurityService.class);

	public User findLoggedInUsername() {
		org.springframework.security.core.userdetails.User userDetails = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userRepository.findByEmail(userDetails.getUsername());
	}

	public void autologin(String email, String password) {
		UserDetails userDetails = authenticationService.loadUserByUsername(email);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

		authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		if (usernamePasswordAuthenticationToken.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			logger.debug(String.format("Auto login %s successfully!", email));
		}
	}
}