package com.bruxelas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruxelas.entities.User;
import com.bruxelas.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email); 
	}

}
