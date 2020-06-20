package com.api.mecanica.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mecanica.model.OrdensServicos;
import com.api.mecanica.repository.OrdensServicosRepository;

@Service
public class OrdensServicosService {

	@Autowired
	OrdensServicosRepository repository;
	
	public OrdensServicos createOS(OrdensServicos os) {
		os.setEntrada(new Date());
		os.setTotalOsMaoDeObra(0.0);
		os.setTotalOsPecas(0.0);
		os.setTotalServico(0.0);
		return repository.save(os);
	}
	
	public List<OrdensServicos> findAll() {
		return repository.findAll();
	}
	
	public Optional<OrdensServicos> findById(Long id) {
		return repository.findById(id);
	}
	
	private OrdensServicos calculaOS(OrdensServicos os) {	
		// total serviço
		os.setTotalOsMaoDeObra(0.0);
		os.setTotalOsPecas(0.0);
		os.setTotalServico(0.0);
		return os;
	}
}
