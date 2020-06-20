package com.api.mecanica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mecanica.model.MaoObra;
import com.api.mecanica.repository.MaoObraRepository;

@Service
public class MaoObraService {

	@Autowired
	MaoObraRepository repository;
	
	public List<MaoObra> findAll() {
		return repository.findAll();
	}
	
}
