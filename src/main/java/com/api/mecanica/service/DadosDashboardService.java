package com.api.mecanica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mecanica.model.DadosDashboard;

@Service
public class DadosDashboardService {
	
	@Autowired
	OrdensServicosService osService;
	
	@Autowired
	MaoDeObraService maoService;
	
	@Autowired
	PecasServiceImpl pecaService;
	
	@Autowired
	VeiculoServiceImpl veiculoService;
	
	@Autowired
	UserService usersService;

	public DadosDashboard counts() throws Exception {
		try {
		DadosDashboard dd = new DadosDashboard();
		
		// OS
		dd.setQuantidadeOS(osService.countAll());
		dd.setQuantidadeOSAndamento(osService.countByIsFinalizado(0));
		dd.setQuantidadeOSFinalizada(osService.countByIsFinalizado(1));
		dd.setQuantidadeOSCancelada(osService.countByIsFinalizado(2));
		
		dd.setTotalOS(osService.sumTotalOs());
		dd.setTotalOSAndamento(osService.sumTotalOsByIsFinalizado(0));
		dd.setTotalOSFinalizada(osService.sumTotalOsByIsFinalizado(1));
		dd.setTotalOSCancelada(osService.sumTotalOsByIsFinalizado(2));
		
		// MAO
		dd.setQuantidadeMao(maoService.countAll());
		dd.setQuantidadeMaoAtiva(maoService.countByActive(true));
		dd.setQuantidadeMaoInativa(maoService.countByActive(false));
		
		// PECA
		dd.setQuantidadePeca(pecaService.countAll());
		dd.setQuantidadePecaAtiva(pecaService.countByActive(true));
		dd.setQuantidadePecaInativa(pecaService.countByActive(false));
		
		// VEICULOS
		dd.setQuantidadeVeiculo(veiculoService.countAll());
		dd.setQuantidadeVeiculoAtiva(veiculoService.countByActive(true));
		dd.setQuantidadeVeiculoInativa(veiculoService.countByActive(false));

		// USERS
		dd.setQuantidadeUser(usersService.countAll());
		dd.setQuantidadeUserAtiva(usersService.countByActive(true));
		dd.setQuantidadeUserInativa(usersService.countByActive(false));
		
		return dd;
		} catch (Exception e) {
			throw new Exception("Error ao obter dados dashboard");
		}
	}

	
}
