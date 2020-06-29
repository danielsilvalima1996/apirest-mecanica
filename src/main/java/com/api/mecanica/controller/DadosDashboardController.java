package com.api.mecanica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.mecanica.model.DadosDashboard;
import com.api.mecanica.service.OrdensServicosService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/dados-dashboard")
public class DadosDashboardController {

	@Autowired
	OrdensServicosService service;

	@ApiOperation(value = "Dados dashboard, totais")
	@GetMapping(produces = { "application/json" })
	public DadosDashboard counts() throws Exception {
		DadosDashboard dd = new DadosDashboard();
		dd.setTotalOS(service.countAll());
		dd.setTotalOSAndamento(service.countByIsFinalizado(0));
		dd.setTotalOSFinalizada(service.countByIsFinalizado(1));
		dd.setTotalOSCancelada(service.countByIsFinalizado(2));
		return dd;
	}

}
