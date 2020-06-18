package com.api.mecanica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.mecanica.model.Users;
import com.api.mecanica.repository.UsersRepository;

@Service
public class UsersService {
	
	private static final BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
	
	@Autowired
	UsersRepository repository;
	
	public Optional<Users> findById(Long id) {
		return repository.findById(id);
	}
	
	public Users findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public List<Users> findByEmailContainingIgnoreCase(String email) {
		return repository.findByEmailLike("%" + email + "%");
//		return repository.findByEmailContainingIgnoreCase(email);
	}
	
	public List<Users> findAll() {
		return repository.findAll();
	}

	public Users createUser(Users user) {
		String result = bc.encode(user.getPassword());
		user.setPassword(result);
		return repository.save(user);
	}

}
