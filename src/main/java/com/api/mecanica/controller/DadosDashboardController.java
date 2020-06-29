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
	OrdensServicosService osService;

	@ApiOperation(value = "Dados dashboard, totais")
	@GetMapping(produces = { "application/json" })
	public DadosDashboard counts() throws Exception {
		DadosDashboard dd = new DadosDashboard();
		
		dd.setQuantidadeOS(osService.countAll());
		dd.setQuantidadeOSAndamento(osService.countByIsFinalizado(0));
		dd.setQuantidadeOSFinalizada(osService.countByIsFinalizado(1));
		dd.setQuantidadeOSCancelada(osService.countByIsFinalizado(2));
		
		dd.setTotalOS(osService.sumTotalOs());
		dd.setTotalOSAndamento(osService.sumTotalOsByIsFinalizado(0));
		dd.setTotalOSFinalizada(osService.sumTotalOsByIsFinalizado(1));
		dd.setTotalOSCancelada(osService.sumTotalOsByIsFinalizado(2));
		return dd;
	}

}
