package com.api.mecanica.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PostMapping("/cadastrar-mao-obra")
	@ApiOperation(value="Cadastrar uma nova mao de obra")
	public MaoDeObra cadastrarMaoDeObra(@Valid @RequestBody MaoDeObra maoDeObra) {
//		try {
//			
//			MaoDeObra mao = service.cadastrarDeMaoObra(maoDeObra);
//			
//			return ResponseEntity.ok(mao);
//			
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
		return service.cadastrarDeMaoObra(maoDeObra);
		
	}
	
	

}
