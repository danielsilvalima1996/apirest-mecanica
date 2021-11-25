package com.api.mecanica.service;

import java.util.List;

import com.api.mecanica.model.Labor;
import com.api.mecanica.repository.LaborRepository;
import com.api.mecanica.service.interfaces.ILaborService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaborService implements ILaborService {
	
	@Autowired
	LaborRepository repository;

	@Override
	public Labor findById(Long id) {
		var labor = repository.findById(id);
		if(labor.isPresent())
			return labor.get();
		return null;		
	}

	@Override
	public List<Labor> findAll() {
		return repository.findAll();
	}

	@Override
	public Labor createLabor(Labor labor) {
		Labor dbLabor = repository.save(labor);
		return dbLabor;
	}

	@Override
	public Labor alterLabor(Labor labor) {
		Labor dbLabor = repository.save(labor);
		return dbLabor;
	}

	@Override
	public Long countLabor() {
		return repository.count();
	}
	
}
