package com.api.mecanica.service;

import com.api.mecanica.model.dto.DashboardDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
	
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

	public DashboardDTO counts() throws Exception {
		try {
		DashboardDTO dd = new DashboardDTO();
		
		// OS
		dd.setQuantityOS(osService.countAll());
		dd.setQuantityOSInProgress(osService.countByIsFinalizado(0));
		dd.setQuantityOSFinished(osService.countByIsFinalizado(1));
		dd.setQuantityOSCanceled(osService.countByIsFinalizado(2));
		
		dd.setTotalOS(osService.sumTotalOs());
		dd.setTotalOSInProgress(osService.sumTotalOsByIsFinalizado(0));
		dd.setTotalOSFinished(osService.sumTotalOsByIsFinalizado(1));
		dd.setTotalOSCanceled(osService.sumTotalOsByIsFinalizado(2));
		
		// MAO
		dd.setQuantityLabor(maoService.countAll());
		dd.setQuantityLaborActive(maoService.countByActive(true));
		dd.setQuantityLaborInactive(maoService.countByActive(false));
		
		// PECA
		dd.setQuantityPart(pecaService.countAll());
		dd.setQuantityPartActive(pecaService.countByActive(true));
		dd.setQuantityPartInactive(pecaService.countByActive(false));
		
		// VEICULOS
		dd.setQuantityVehicle(veiculoService.countAll());
		dd.setQuantityVehicleActive(veiculoService.countByActive(true));
		dd.setQuantityVehicleInactive(veiculoService.countByActive(false));

		// USERS
		dd.setQuantityUser(usersService.countAll());
		dd.setQuantityUserActive(usersService.countByActive(true));
		dd.setQuantityUserInactive(usersService.countByActive(false));
		
		return dd;
		} catch (Exception e) {
			throw new Exception("Error ao obter dados dashboard");
		}
	}

	
}
