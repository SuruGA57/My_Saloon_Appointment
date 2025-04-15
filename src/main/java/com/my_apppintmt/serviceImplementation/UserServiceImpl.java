package com.my_apppintmt.serviceImplementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my_apppintmt.model.User;
import com.my_apppintmt.repository.UserRepository;
import com.my_apppintmt.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElseThrow(()->new RuntimeException(" User not Found...!!!"));
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
//update User
	@Override
	public User updateUser(Long id, User userDetails) {
		// TODO Auto-generated method stub
		User user = getUserById(id);
		
		// check here for existing mail 
		Optional<User> userWIthmail =userRepository.findByEmail(userDetails.getEmail());
		if(userWIthmail !=null && userWIthmail.get().getId().equals(id)){
			throw new RuntimeException("Email Already exists");	
		}
		user.setUserName(userDetails.getUserName());
		user.setAddress(userDetails.getAddress());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		user.setRole(userDetails.getRole());
		user.setUpdatedAt(LocalDateTime.now());
		
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		User user= getUserById(id);
		userRepository.delete(user);
	}

	@Override
	public User login(String email, String password) {
		// TODO Auto-generated method stub
		
		return userRepository.findByEmail(email)
				.filter(user->user.getPassword().equals(password))
				.orElseThrow(()->new RuntimeException("Invalid Scrediantials"));
	}

	
	
}
