package com.shubhi.smartreceipt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubhi.smartreceipt.model.User;
import com.shubhi.smartreceipt.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public User getUserById(Integer id) {
		return userRepository.getOne(id);
	}

	public void deleteUser(Integer userId) {
		User user = new User();
		user.setUserId(userId);
		userRepository.delete(user);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

}
