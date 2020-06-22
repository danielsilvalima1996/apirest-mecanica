package com.api.mecanica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mecanica.model.OsMaoDeObra;
import com.api.mecanica.repository.OsMaoDeObraRepository;

@Service
public class OsMaoDeObraService {

	@Autowired
	OsMaoDeObraRepository repository;
	
	public OsMaoDeObra createOsMaoDeObra(OsMaoDeObra os) {
		return repository.save(os);
	}
	
	public void deleteOsMaoDeObra(OsMaoDeObra os) {
		repository.delete(os);
	}
}
