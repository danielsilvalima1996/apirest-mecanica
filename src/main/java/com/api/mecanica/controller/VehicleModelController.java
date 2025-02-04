package com.api.mecanica.controller;

import java.util.List;

import com.api.mecanica.model.VehicleModel;
import com.api.mecanica.service.VehicleModelService;

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

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/vehicle-model")
public class VehicleModelController {

	@Autowired
	VehicleModelService service;

	@Operation(summary ="Traz uma Marca pelo id")
	@GetMapping(value = "{id}", produces = { "application/json" })
	public ResponseEntity<VehicleModel> findById(@PathVariable(value = "id") Long id) throws Exception {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@Operation(summary ="Traz uma Lista de Marcas")
	@GetMapping(produces = { "application/json" })
	public ResponseEntity<List<VehicleModel>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	

	@Operation(summary ="Cria uma marca")
	@PostMapping(consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<VehicleModel> createVehicleModel(@RequestBody VehicleModel vehicleModel) throws Exception {
		return ResponseEntity.ok(service.createVehicleModel(vehicleModel));
	}
	
	@Operation(summary ="Altera uma Marca")
	@PutMapping(consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<VehicleModel> alterVehicleModel(@RequestBody VehicleModel vehicleModel) throws Exception {
		return ResponseEntity.ok(service.alterVehicleModel(vehicleModel));
	}
}
