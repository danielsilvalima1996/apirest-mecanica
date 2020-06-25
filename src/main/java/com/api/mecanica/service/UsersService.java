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
	
	public Optional<Users> findById(Long id) throws Exception {
		var user = repository.findById(id);
		if (!user.isPresent()) {
			throw new Exception("Usuário não encontrado");
		}
		user.get().setPassword("");
		return user;
	}
	
	public Users findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public List<Users> findByEmailContainingIgnoreCase(String email) {
		var users = repository.findByEmailContainingIgnoreCase(email);
		if (users.size() > 0) {
			users.forEach(u -> u.setPassword(""));
		}
		return users;
	}
	
	public List<Users> findByUserNameContainingIgnoreCase(String userName) {
		var users = repository.findByUserNameContainingIgnoreCase(userName);
		if (users.size() > 0) {
			users.forEach(u -> u.setPassword(""));
		}
		return users;
	}
	
	public List<Users> findByActive(boolean active) {
		var users = repository.findByActive(active);
		if (users.size() > 0) {
			users.forEach(u -> u.setPassword(""));
		}
		return users;
	}
	
	public List<Users> findAll() {
		var users = repository.findAll();
		if (users.size() > 0) {
			users.forEach(u -> u.setPassword(""));
		}
		return users;
	}

	public Users createUser(Users user) throws Exception {
		var dbUser = findByEmail(user.getEmail());
		if (dbUser != null) {
			throw new Exception("Email já cadastrado");
		}
		String result = bc.encode(user.getPassword());
		user.setPassword(result);
		String avatar = "https://api.adorable.io/avatars/64/" + user.getEmail() + ".png";
		user.setAvatar(avatar);
		return repository.save(user);
	}
	
	public Users alterUser(Users user) throws Exception {
		var dbUser = repository.findById(user.getId());
		if (!dbUser.isPresent()) {
			throw new Exception("Usuário não encotrado, impossível alterar");
		}
		if (user.getPassword() != "") {
			String result = bc.encode(user.getPassword());
			user.setPassword(result);
		} else {			
			user.setPassword(dbUser.get().getPassword().toString());
		}
		String avatar = "https://api.adorable.io/avatars/64/" + user.getEmail() + ".png";
		user.setAvatar(avatar);
		return repository.saveAndFlush(user);
	}

}
