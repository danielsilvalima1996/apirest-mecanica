package com.api.mecanica.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.mecanica.model.OrdensServicos;
import com.api.mecanica.service.OrdensServicosService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.OPTIONS })
@RequestMapping("/api/ordens-servicos")
public class OrdensServicosController {

	@Autowired
	OrdensServicosService service;

//	@ApiOperation(value = "Traz uma lista User pelo email")
//	@GetMapping(value = "email", produces = { "application/json" })
//	public List<Users> findByEmailContainingIgnoreCase(@RequestParam(value = "email") String email) {
//		return service.findByEmailContainingIgnoreCase(email);
//	}
//	
//	@ApiOperation(value = "Traz uma lista User pelo username")
//	@GetMapping(value = "username", produces = { "application/json" })
//	public List<Users> findByUserNameContainingIgnoreCase(@RequestParam(value = "username") String username) {
//		return service.findByUserNameContainingIgnoreCase(username);
//	}
//	
//	@ApiOperation(value = "Traz uma lista User pelo active, true ou false")
//	@GetMapping(value = "active", produces = { "application/json" })
//	public List<Users> findByActive(@RequestParam(value = "active") boolean active) {
//		return service.findByActive(active);
//	}

	@ApiOperation(value = "Traz uma OS pelo id")
	@GetMapping(produces = { "application/json" })
	public Optional<OrdensServicos> findById(@RequestParam(value = "id") Long id) {
		return service.findById(id);
	}

	@ApiOperation(value = "Traz uma Lista de OS")
	@GetMapping(value = "all", produces = { "application/json" })
	public List<OrdensServicos> findAll() {
		return service.findAll();
	}

	@ApiOperation(value = "Cria uma OS")
	@PostMapping(consumes = { "application/json" }, produces = { "application/json" })
	public OrdensServicos createOs(@Valid @RequestBody OrdensServicos os) {
		return service.createOS(os);
	}

}
