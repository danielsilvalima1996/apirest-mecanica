package com.api.mecanica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.mecanica.constants.AppConstants;
import com.api.mecanica.model.MaoObra;
import com.api.mecanica.model.Users;
import com.api.mecanica.repository.MaoObraRepository;
import com.api.mecanica.service.MaoObraService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/mao-obra")
public class MaoObraCotroller {
	
	@Autowired
	MaoObraService service;
	

	
	@ApiOperation(value="Retorna uma lista de mão de obra cadastrada")
	@GetMapping(value = "all", produces = { "application/json" })
	public List<MaoObra> findAll() {
		return service.findAll();
	}
	
	

}
