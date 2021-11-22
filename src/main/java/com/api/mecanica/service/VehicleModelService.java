package com.api.mecanica.service;

import java.util.List;

import com.api.mecanica.model.VehicleModel;
import com.api.mecanica.repository.VehicleModelRepository;
import com.api.mecanica.service.interfaces.IVehicleModelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleModelService implements IVehicleModelService {
	
	@Autowired
	VehicleModelRepository repository;

	@Override
	public VehicleModel findById(Long id) {
		var vehicleModel = repository.findById(id);
		if(vehicleModel.isPresent())
			return vehicleModel.get();
		return null;		
	}

	@Override
	public List<VehicleModel> findAll() {
		return repository.findAll();
	}

	@Override
	public VehicleModel createVehicleModel(VehicleModel vehicleModel) {
		VehicleModel dbvehicleModel = repository.save(vehicleModel);
		return dbvehicleModel;
	}

	@Override
	public VehicleModel alterVehicleModel(VehicleModel vehicleModel) {
		VehicleModel dbvehicleModel = repository.save(vehicleModel);
		return dbvehicleModel;
	}

	@Override
	public Long countVehicleModel() {
		return repository.count();
	}
	
}
