package com.api.mecanica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mecanica.model.MaoDeObra;
import com.api.mecanica.repository.MaoDeObraRepository;

@Service
public class MaoDeObraService {

	@Autowired
	MaoDeObraRepository repository;

	public List<MaoDeObra> findAll() {
		return repository.findAll();
	}

	public MaoDeObra cadastrarDeMaoObra(MaoDeObra maoDeObra) {
		return repository.save(maoDeObra);
	}

}
