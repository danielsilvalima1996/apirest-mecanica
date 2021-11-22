package com.api.mecanica.controller;

import com.api.mecanica.model.dto.DashboardDTO;
import com.api.mecanica.service.DashboardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/dashboard")
public class DashboardController {

	@Autowired
	DashboardService service;

	@ApiOperation(value = "Dados dashboard, totais")
	@GetMapping(produces = { "application/json" })
	public DashboardDTO counts() throws Exception {
		return service.counts();
	}

}
