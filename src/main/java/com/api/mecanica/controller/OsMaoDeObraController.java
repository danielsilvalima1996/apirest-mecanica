package com.api.mecanica.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.mecanica.model.OsMaoDeObra;
import com.api.mecanica.service.OsMaoDeObraService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/os-mao-obra")
public class OsMaoDeObraController {
	
	@Autowired
	OsMaoDeObraService service;
	
	@ApiOperation(value = "Cria uma OS Mao de Obra")
	@PostMapping(value = "{id}", consumes = { "application/json" }, produces = { "application/json" })
	public OsMaoDeObra createOs(@Valid @RequestBody OsMaoDeObra os, @PathVariable(value = "id") Long id) throws Exception {
		return service.createOsMaoDeObra(os, id);
	}

}
