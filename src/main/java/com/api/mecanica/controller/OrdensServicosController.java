package com.api.mecanica.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
	public Optional<OrdensServicos> findById(@PathVariable(value = "id") Long id) throws Exception {
		return service.findById(id);
	}

	@ApiOperation(value = "Traz uma Lista de OS")
	@GetMapping(value = "all", produces = { "application/json" })
	public List<OrdensServicos> findAll(@Param(value = "id") Long id, @Param(value = "nomeCliente") String nomeCliente,
			@Param(value = "cpfCnpj") String cpfCnpj, @Param(value = "observacoes") String observacoes,
			@Param(value = "idVeiculo") Long idVeiculo, @Param(value = "placa") String placa,
			@Param(value = "idUsuario") Long idUsuario, @Param(value = "isFinalizado") Boolean isFinalizado)
			throws Exception {
		return service.findAll(id, nomeCliente, cpfCnpj, observacoes, idVeiculo, placa, idUsuario, isFinalizado);
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
