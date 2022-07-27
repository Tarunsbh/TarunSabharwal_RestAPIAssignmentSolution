package com.employeemanagement.app.service;

import java.util.List;

import com.employeemanagement.app.model.User;


public interface UserService {

	List<User> getAllUsers();
	
	User getUserById(Integer userId);
	
	User saveUser(User user);
	
	void deleteUserById(Integer userId);
	
}
