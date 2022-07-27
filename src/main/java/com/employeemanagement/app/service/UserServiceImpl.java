package com.employeemanagement.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.app.model.Role;
import com.employeemanagement.app.model.User;
import com.employeemanagement.app.repository.RoleRepository;
import com.employeemanagement.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Integer userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		if (userOptional.isPresent()) {
			return userOptional.get();
		}
		return null;
	}

	@Override
	public User saveUser(User user) {

		List<Role> roles = user.getRoles();

		if (roles != null) {
			for (Role role : roles) {
				roleRepository.save(role);
			}
		}
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Integer userId) {
		User user = getUserById(userId);
		userRepository.delete(user);
	}

}
