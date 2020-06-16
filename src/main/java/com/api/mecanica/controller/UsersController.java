package com.api.mecanica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.mecanica.model.Users;
import com.api.mecanica.service.UsersService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	UsersService service;
	
	@ApiOperation(value="Retorna um único User")
	@GetMapping(value = "{id}",produces = { "application/json" })
	public Optional<Users> findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	
	@ApiOperation(value="Cria um único User")
	@PostMapping(consumes = { "application/json" },
			produces = { "application/json" })
	public Users createUser(@RequestBody Users user) {
		return service.createUser(user);
	}
	
	@ApiOperation(value="retorna uma lista de Users")
	@GetMapping(produces = { "application/json" })
	public List<Users> findAll() {
		return service.findAll();
	}
}
