package com.api.mecanica.service;

import static org.springframework.data.jpa.domain.Specification.where;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.mecanica.model.Users;
import com.api.mecanica.repository.UsersRepository;
import com.api.mecanica.specification.UsersSpecification;

@Service
public class UsersService {

	private static final BCryptPasswordEncoder bc = new BCryptPasswordEncoder();

	@Autowired
	UsersRepository repository;

	public Optional<Users> findById(Long id) throws Exception {
		var user = repository.findById(id);
		if (!user.isPresent()) {
			throw new Exception("Usuário " + id + " não encontrado");
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
		var users = repository.findByActive(active, Sort.by("userName"));
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
		user.setActive(true);
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

	public List<Users> findByFiltros(Long id, String email, String userName, Boolean active) throws Exception {
		List<Users> users = new ArrayList<>();
		users = repository.findAll(where(UsersSpecification.codigoUsers(id)).and(UsersSpecification.emailUsers(email))
				.and(UsersSpecification.userNameUsers(userName)).and(UsersSpecification.activeUsers(active)));

		if (users.size() == 0) {
			throw new Exception("Não há dados");
		}
		users.forEach(x -> x.setPassword(""));
		return users;
	}

	public long countByActive(Boolean active) {
		return repository.countByActive(active);
	}

	public long countAll() {
		return repository.count();
	}

}
