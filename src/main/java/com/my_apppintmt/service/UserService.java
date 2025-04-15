package com.my_apppintmt.service;

import java.util.List;

import com.my_apppintmt.model.User;

public interface UserService {

	User registerUser(User user);
	
	User getUserById(Long id);
	
	List<User> getAllUsers();
	
	User updateUser(Long id, User userDetails);
	
	void deleteUser(Long id);
	
	User login(String email, String password);
}
