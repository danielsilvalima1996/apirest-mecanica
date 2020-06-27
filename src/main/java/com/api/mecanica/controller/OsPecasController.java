package com.api.mecanica.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.mecanica.model.OsPecas;
import com.api.mecanica.service.OsPecasService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/os-pecas")
public class OsPecasController {

	@Autowired
	OsPecasService service;

	@ApiOperation(value = "Cria uma OS Peças")
	@PostMapping(value = "{id}", consumes = { "application/json" }, produces = { "application/json" })
	public OsPecas createOs(@Valid @RequestBody OsPecas os, @PathVariable(value = "id") Long id) throws Exception {
		return service.createOsPecas(os, id);
	}

	@ApiOperation(value = "Deleta uma OS Peças")
	@DeleteMapping(value = "{id}", consumes = { "application/json" })
	public void deleteOs(@Valid @RequestBody OsPecas os, @PathVariable(value = "id") Long id) throws Exception {
		service.deleteOsMaoDeObra(os, id);
	}

}
