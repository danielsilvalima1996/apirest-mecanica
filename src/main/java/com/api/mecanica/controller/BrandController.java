package com.api.mecanica.controller;

import java.util.List;

import com.api.mecanica.model.Brand;
import com.api.mecanica.service.BrandService;

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
@RequestMapping("/api/brand")
public class BrandController {

	@Autowired
	BrandService service;

	@ApiOperation(value = "Traz uma Marca pelo id")
	@GetMapping(value = "{id}", produces = { "application/json" })
	public ResponseEntity<Brand> findById(@PathVariable(value = "id") Long id) throws Exception {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@ApiOperation(value = "Traz uma Lista de Marcas")
	@GetMapping(produces = { "application/json" })
	public ResponseEntity<List<Brand>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	

	@ApiOperation(value = "Cria uma marca")
	@PostMapping(consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) throws Exception {
		return ResponseEntity.ok(service.createBrand(brand));
	}
	
	@ApiOperation(value = "Altera uma Marca")
	@PutMapping(consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Brand> alterBrand(@RequestBody Brand brand) throws Exception {
		return ResponseEntity.ok(service.alterBrand(brand));
	}
}
