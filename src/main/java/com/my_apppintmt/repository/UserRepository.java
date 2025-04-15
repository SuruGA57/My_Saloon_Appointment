package com.my_apppintmt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my_apppintmt.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	 Optional<User> findByEmail(String email);

}
