package com.my_apppintmt.model;

import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String userName;
	
	private String address;
	
	private String  email;
	
	private String password;

	private String role;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime  updatedAt;
}
