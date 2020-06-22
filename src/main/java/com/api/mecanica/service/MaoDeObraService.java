package com.api.mecanica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.mecanica.exception.MaoDeObraException;
import com.api.mecanica.model.MaoDeObra;
import com.api.mecanica.repository.MaoDeObraRepository;

@Service
public class MaoDeObraService {

	@Autowired
	MaoDeObraRepository repository;

	public Optional<MaoDeObra> findById(Long id) throws MaoDeObraException {
		var os = repository.findById(id);
		if(!os.isPresent()) {
			throw new MaoDeObraException(HttpStatus.NOT_FOUND.value(), "Não tem mão de obra para esse ID");
		}
		return os;
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
	
	public List<MaoDeObra> findByDescricaoContainingIgnoreCase(String descricao) {
		return repository.findByDescricaoContainingIgnoreCase(descricao);
	}
}
