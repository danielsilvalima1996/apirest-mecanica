package com.api.mecanica.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class OsMaoObraController {

	@Autowired
	OsMaoDeObraService service;

	@ApiOperation(value = "Cria uma OS Mão de Obra")
	@PostMapping(consumes = { "application/json" }, produces = { "application/json" })
	public OsMaoDeObra createOsMaoObra(@Valid @RequestBody OsMaoDeObra osMaoDeObra) {
		return service.createOsMaoDeObra(osMaoDeObra);
	}

	@ApiOperation(value = "Deleta uma OS Mão de Obra")
	@PostMapping(consumes = { "application/json" })
	public void deleteOsMaoDeObra(@Valid @RequestBody OsMaoDeObra osMaoDeObra) {
		service.deleteOsMaoDeObra(osMaoDeObra);
	}

}
