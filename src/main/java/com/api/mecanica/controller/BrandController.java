package com.api.mecanica.controller;

import com.api.mecanica.model.Brand;
import com.api.mecanica.service.BrandService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/brand")
public class BrandController {

	@Autowired
	BrandService service;

	@Operation(summary = "Traz uma Marca pelo id")
	@GetMapping(value = "{id}", produces = { "application/json" })
	public ResponseEntity<Brand> findById(@PathVariable(value = "id") Long id) throws Exception {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@Operation(summary ="Traz uma Lista de Marcas")
	@GetMapping(produces = { "application/json" })
	public ResponseEntity<List<Brand>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	

	@Operation(summary ="Cria uma marca")
	@PostMapping(consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) throws Exception {
		return ResponseEntity.ok(service.createBrand(brand));
	}
	
	@Operation(summary ="Altera uma Marca")
	@PutMapping(consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Brand> alterBrand(@RequestBody Brand brand) throws Exception {
		return ResponseEntity.ok(service.alterBrand(brand));
	}
}
