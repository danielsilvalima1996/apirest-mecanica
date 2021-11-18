package com.api.mecanica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.mecanica.model.User;
import com.api.mecanica.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService service;

	@ApiOperation(value = "Traz uma lista User pelo email")
	@GetMapping(value = "email", produces = { "application/json" })
	public List<User> findByEmailContainingIgnoreCase(@RequestParam(value = "email") String email) {
		return service.findByEmailContainingIgnoreCase(email);
	}
	
	@ApiOperation(value = "Traz uma lista User pelo username")
	@GetMapping(value = "username", produces = { "application/json" })
	public List<User> findByUserNameContainingIgnoreCase(@RequestParam(value = "username") String username) {
		return service.findByUserNameContainingIgnoreCase(username);
	}
	
	@ApiOperation(value = "Traz uma lista User pelo active, true ou false")
	@GetMapping(value = "active", produces = { "application/json" })
	public List<User> findByActive(@RequestParam(value = "active") boolean active) {
		return service.findByActive(active);
	}

	@ApiOperation(value = "Traz um User pelo id")
	@GetMapping(value = "{id}", produces = { "application/json" })
	public Optional<User> findById(@PathVariable(value = "id") Long id) throws Exception {
		return service.findById(id);
	}
	
	@ApiOperation(value = "Traz uma Lista de User")
	@GetMapping(value = "all", produces = { "application/json" })
	public List<User> findAll() {
		return service.findAll();
	}
	

	@ApiOperation(value = "Busca uma lista de User por ID ou EMAIL")
	@GetMapping(value = "/busca", produces = { "application/json" })
	public List<User> findByEmailContainingOrUserNameContaining(
			@Param(value = "id") Long id,
			@Param(value = "email") String email, 
			@Param(value = "userName") String userName,
			@Param(value = "userName") Boolean active)
			throws Exception {
		return service.findByFiltros(id, email, userName, active);
	}

	@ApiOperation(value = "Cria um único User")
	@PostMapping(consumes = { "application/json" }, produces = { "application/json" })
	public User createUser(@RequestBody User user) throws Exception {
		return service.createUser(user);
	}
	
	@ApiOperation(value = "Altera um único User")
	@PutMapping(consumes = { "application/json" }, produces = { "application/json" })
	public User alterUser(@RequestBody User user) throws Exception {
		return service.alterUser(user);
	}
}
