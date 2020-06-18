package com.api.mecanica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.mecanica.model.Users;
import com.api.mecanica.service.UsersService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	UsersService service;

	@ApiOperation(value = "Traz uma lista User pelo email")
	@GetMapping(value = "email", produces = { "application/json" })
	public List<Users> findByEmailContainingIgnoreCase(@RequestParam(value = "email") String email) {
		return service.findByEmailContainingIgnoreCase(email);
	}
	
	@ApiOperation(value = "Traz uma lista User pelo username")
	@GetMapping(value = "username", produces = { "application/json" })
	public List<Users> findByUserNameContainingIgnoreCase(@RequestParam(value = "username") String username) {
		return service.findByUserNameContainingIgnoreCase(username);
	}
	
	@ApiOperation(value = "Traz uma lista User pelo active, true ou false")
	@GetMapping(value = "active", produces = { "application/json" })
	public List<Users> findByActive(@RequestParam(value = "active") boolean active) {
		return service.findByActive(active);
	}

	@ApiOperation(value = "Traz um User pelo id")
	@GetMapping(produces = { "application/json" })
	public Optional<Users> findById(@RequestParam(value = "id") Long id) {
		return service.findById(id);
	}
	
	@ApiOperation(value = "Traz uma Lista de User")
	@GetMapping(value = "all", produces = { "application/json" })
	public List<Users> findAll() {
		return service.findAll();
	}

	@ApiOperation(value = "Cria um único User")
	@PostMapping(consumes = { "application/json" }, produces = { "application/json" })
	public Users createUser(@RequestBody Users user) {
		return service.createUser(user);
	}
}
