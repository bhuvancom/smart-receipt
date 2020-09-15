package com.shubhi.smartreceipt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubhi.smartreceipt.model.User;
import com.shubhi.smartreceipt.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Iterable<User> getAllUser() {
		return userRepository.findAll();
	}

}
