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
	public Optional<Pecas> buscarPecaById(Long id) {
		
		Optional<Pecas> peca = repository.findById(id);
		
		if(peca.isPresent()) {
			return peca;
		} else {
			return Optional.empty();
		}
	} 

	@Override
	public Optional<Pecas> atualizarPeca(@Valid Long id, @Valid Pecas peca) {
		
		Optional<Pecas> dadosAtuais = repository.findById(id);
		
		if(dadosAtuais.isPresent()) {
			
			Pecas pecaAtualizada = dadosAtuais.get();
			pecaAtualizada.setDescricao(peca.getDescricao());
			pecaAtualizada.setMarca(peca.getMarca());
			pecaAtualizada.setModelo(peca.getModelo());
			pecaAtualizada.setValorUnitario(peca.getValorUnitario());
			pecaAtualizada.setActive(peca.isActive());
			
			return Optional.of(repository.saveAndFlush(pecaAtualizada));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public List<Pecas> buscarPecasPorMarca(String marca) {

		
		List<Pecas> peca = new ArrayList<>();
		
		try {
			peca = repository.findByMarcaContainingIgnoreCase(marca);
		} catch (Exception e) {
			
			throw e;
		}
		
		return peca;

		
	}

	@Override
	public List<Pecas> buscarPecasAtivas(boolean active) {
		
		List<Pecas> pecas = new ArrayList<>();
		
		try {
			
			pecas = repository.findByActive(active);
			
		} catch (Exception e) {
			throw e;
		}
		
		return pecas;
	}

}
