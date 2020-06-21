package com.api.mecanica.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.mecanica.model.OrdensServicos;
import com.api.mecanica.service.OrdensServicosService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ordens-servicos")
public class OrdensServicosController {

	@Autowired
	OrdensServicosService service;

	@ApiOperation(value = "Traz uma OS pelo id")
	@GetMapping(value = "{id}", produces = { "application/json" })
	public Optional<OrdensServicos> findById(@PathVariable(value = "id") Long id) {
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
	
	@ApiOperation(value = "Altera uma OS")
	@PutMapping(consumes = { "application/json" }, produces = { "application/json" })
	public OrdensServicos alterOs(@Valid @RequestBody OrdensServicos os) throws Exception {
		return service.alterOS(os);
	}
	
	@ApiOperation(value = "Finaliza uma OS")
	@PutMapping(value = "/finalizar", consumes = { "application/json" }, produces = { "application/json" })
	public OrdensServicos finalizarOs(@Valid @RequestBody OrdensServicos os) throws Exception {
		return service.finalizarOs(os);
	}

}
