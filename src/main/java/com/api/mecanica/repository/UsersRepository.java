package com.api.mecanica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.mecanica.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
	Users findByEmail(String email);
	

}
