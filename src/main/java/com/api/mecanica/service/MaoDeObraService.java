package com.api.mecanica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mecanica.model.MaoDeObra;
import com.api.mecanica.repository.MaoDeObraRepository;

@Service
public class MaoDeObraService {

	@Autowired
	MaoDeObraRepository repository;

	public Optional<MaoDeObra> findById(Long id) {
		return repository.findById(id);
	}
	
	public List<MaoDeObra> findAll() {
		return repository.findAll();
	}

	public MaoDeObra cadastrarDeMaoObra(MaoDeObra maoDeObra) {
		return repository.save(maoDeObra);
	}
	
	public MaoDeObra alterMaoDeObra(MaoDeObra maoDeObra) {
		return repository.save(maoDeObra);
	}
	
	public List<MaoDeObra> findByActive(boolean active){
		return repository.findByActive(active);
	}
	
	public List<MaoDeObra> findByDescricao(String descricao){
		return repository.findByDescricao(descricao);
	}
}
