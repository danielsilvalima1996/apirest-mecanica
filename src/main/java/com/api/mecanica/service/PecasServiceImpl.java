package com.api.mecanica.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mecanica.constants.AppConstants;
import com.api.mecanica.model.Pecas;
import com.api.mecanica.repository.PecasRepository;

@Service
public class PecasServiceImpl implements PecasService{

	@Autowired
	private PecasRepository repository;
	
	@Override
	public List<Pecas> buscarPecas() {
		
		List<Pecas> pecas = new ArrayList<>();
		
		try {
			
			pecas = repository.findAll();
			
		} catch (Exception e) {
			throw e;
		}
		
		return pecas;
	}

	@Override
	public void cadastrarPecas(@Valid Pecas pecas) {
		
		try {
			pecas.setActive(AppConstants.PECA_ATIVA);
			repository.saveAndFlush(pecas);
			
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Optional<Pecas> buscarPecas(Long id) {
		
		return null;
	}

	@Override
	public Optional<Pecas> atualizarPeca(@Valid Long id, @Valid Pecas peca) {
		
		return null;
	}

	@Override
	public List<Pecas> buscarPecasPorFiltro(Long id, String marca, String descricao, boolean active) {
	
		return null;
	}

}
