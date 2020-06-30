package com.api.mecanica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mecanica.model.DadosDashboard;

@Service
public class DadosDashboardService {
	
	@Autowired
	OrdensServicosService osService;

	public DadosDashboard counts() throws Exception {
		try {
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
		} catch (Exception e) {
			throw new Exception("Error ao obter dados dashboard");
		}
	}

	
}
