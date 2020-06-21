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
		os.setIsFinalizado(false);
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
	
	public OrdensServicos alterOS(OrdensServicos os) throws Exception {	
		var nova = findById(os.getId());
		if (nova.get().getIsFinalizado()) {
			throw new Exception("Não se pode alterar uma  OS Finalizada");			
		}
		// total serviço
		os = calculaOs(os);
		return repository.saveAndFlush(os);
	}
	
	public OrdensServicos finalizarOs(OrdensServicos os) throws Exception {
		var nova = findById(os.getId());
		
		if (nova.get().getIsFinalizado()) {
			throw new Exception("OS já Finalizada");			
		}
		
		os.setSaida(new Date());
		os.setIsFinalizado(true);
		os = calculaOs(os);
		return repository.saveAndFlush(os);
	}
	
	public OrdensServicos calculaOs(OrdensServicos os) {
		os.setTotalServico(os.getTotalOsMaoDeObra() + os.getTotalOsPecas() + os.getTotalServico());
		return os;
	}
}
