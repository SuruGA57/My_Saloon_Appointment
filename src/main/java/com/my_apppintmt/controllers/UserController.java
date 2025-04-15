package com.my_apppintmt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my_apppintmt.model.User;
import com.my_apppintmt.repository.UserRepository;
import com.my_apppintmt.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
 
	
	// Register
    @PostMapping("/register")
    public ResponseEntity<User> registerUser( @RequestBody User user) {
        
        return ResponseEntity.ok(userService.registerUser(user));
    }
	
    //Login
   public ResponseEntity<?> login (@RequestParam String email, @RequestParam String password){
	   try {
           return ResponseEntity.ok(userService.login(email, password));
       } catch (Exception e) {
           return ResponseEntity.status(401).body("Invalid email or password");
       }
   }
   
   
//   get user by ID
   @GetMapping("/{id}")
   public ResponseEntity<User> getUserById(@PathVariable Long id) {
       return ResponseEntity.ok(userService.getUserById(id));
   }

   //List all Users
   @GetMapping
   public ResponseEntity<List<User>> getAllUsers() {
       return ResponseEntity.ok(userService.getAllUsers());
   }

   //Update User
   @PutMapping("/{id}")
   public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
	   try {
	        return ResponseEntity.ok(userService.updateUser(id, user));
	    } catch (RuntimeException ex) {
	        return ResponseEntity.badRequest().body(ex.getMessage());
	    } 
	  }
   
//Delete user
   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
       userService.deleteUser(id);
       return ResponseEntity.ok("User deleted successfully");
   }
    
	//Demo  Register
//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser( @RequestBody User user) {
//        userRepository.save(user);
//        return ResponseEntity.status(201).body("User registered successfully");
//    }
	
    // demo users
    @GetMapping("/user")
	public User getUser() {
		User user = new User();
		
		user.setAddress("pune");
		user.setEmail("S@gmail.com");
		user.setPassword("1234");
		user.setRole("user");
		user.setUserName("sureaj");
		
		return user;
	}
}
