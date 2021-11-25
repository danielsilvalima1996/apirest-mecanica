package com.api.mecanica.controller;

import java.util.List;

import com.api.mecanica.model.Labor;
import com.api.mecanica.service.LaborService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/labor")
public class LaborController {

	@Autowired
	LaborService service;

	@ApiOperation(value = "Traz uma Mão de Obra pelo id")
	@GetMapping(value = "{id}", produces = { "application/json" })
	public ResponseEntity<Labor> findById(@PathVariable(value = "id") Long id) throws Exception {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@ApiOperation(value = "Traz uma Lista de Mão de Obras")
	@GetMapping(produces = { "application/json" })
	public ResponseEntity<List<Labor>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	

	@ApiOperation(value = "Cria uma Mão de Obra")
	@PostMapping(consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Labor> createLabor(@RequestBody Labor labor) throws Exception {
		return ResponseEntity.ok(service.createLabor(labor));
	}
	
	@ApiOperation(value = "Altera uma Mão de Obra")
	@PutMapping(consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Labor> alterLabor(@RequestBody Labor labor) throws Exception {
		return ResponseEntity.ok(service.alterLabor(labor));
	}
}
