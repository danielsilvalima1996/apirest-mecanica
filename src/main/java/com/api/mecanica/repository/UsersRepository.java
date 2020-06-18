package com.api.mecanica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.mecanica.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
	Users findByEmail(String email);
	
	List<Users> findByEmailLike(String email);
	
	List<Users> findByEmailContainingIgnoreCase(String email);
	

}
