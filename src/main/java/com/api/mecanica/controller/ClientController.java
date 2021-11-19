package com.api.mecanica.controller;

import java.util.List;

import com.api.mecanica.model.Client;
import com.api.mecanica.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/client")
public class ClientController {

	@Autowired
	ClientService service;

	@ApiOperation(value = "Traz um Cliente pelo id")
	@GetMapping(value = "{id}", produces = { "application/json" })
	public Client findById(@PathVariable(value = "id") Long id) throws Exception {
		return service.findById(id);
	}
	
	@ApiOperation(value = "Traz uma Lista de Clientes")
	@GetMapping(produces = { "application/json" })
	public List<Client> findAll() {
		return service.findAll();
	}
	

	@ApiOperation(value = "Cria um Cliente")
	@PostMapping(consumes = { "application/json" }, produces = { "application/json" })
	public Client createClient(@RequestBody Client client) throws Exception {
		return service.createClient(client);
	}
	
	@ApiOperation(value = "Altera um Cliente")
	@PutMapping(consumes = { "application/json" }, produces = { "application/json" })
	public Client alterClient(@RequestBody Client client) throws Exception {
		return service.alterClient(client);
	}
}
