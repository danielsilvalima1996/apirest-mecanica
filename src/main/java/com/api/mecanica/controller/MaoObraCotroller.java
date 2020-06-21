package com.api.mecanica.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.mecanica.model.MaoDeObra;
import com.api.mecanica.service.MaoDeObraService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/mao-obra")
public class MaoObraCotroller {
	
	@Autowired
	MaoDeObraService service;
	
	@ApiOperation(value="Retorna uma lista de mão de obra cadastrada")
	@GetMapping(value = "all", produces = { "application/json" })
	public List<MaoDeObra> findAll() {
		return service.findAll();
	}
	
	@ApiOperation(value = "Traz uma mão de obra pelo id")
	@GetMapping(produces = { "application/json" })
	public Optional<MaoDeObra> findById(@RequestParam(value = "id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping("/cadastrar")
	@ApiOperation(value="Cadastra uma nova mao de obra")
	public MaoDeObra cadastrarMaoDeObra(@Valid @RequestBody MaoDeObra maoDeObra) {
		return service.cadastrarDeMaoObra(maoDeObra);
	}
	
	@ApiOperation(value="Atualiza uma mão de obra já cadastrada")
	@PutMapping("/atualizar")
	public MaoDeObra atualizarMaoDeObra(@RequestBody MaoDeObra maoDeObra) {
		return service.alterMaoDeObra(maoDeObra);
	}
	
	@ApiOperation(value="Traz uma lista de mão de obras ativas")
	@GetMapping(value="active")
	public List<MaoDeObra> findByActive(@RequestParam(value="active") boolean active){
	return service.findByActive(active);
	}
	
	@ApiOperation(value="Traz uma lista de mão de obras pela descrição")
	@GetMapping(value="descricao",produces = { "application/json" })
	public List<MaoDeObra> findByDescricao(@RequestParam(value="descricao") String descricao){
	return service.findByDescricao(descricao);
	}
	}
	
