package com.api.mecanica.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.api.mecanica.model.Pecas;

public interface PecasService {

	List<Pecas> buscarPecas();
	
	void cadastrarPecas(@Valid Pecas pecas); 
	
	Optional<Pecas> buscarPecas(Long id);
	
	Optional<Pecas> atualizarPeca(@Valid Long id, @Valid Pecas peca);
	
	List<Pecas> buscarPecasPorFiltro(Long id, String marca, String descricao, boolean active);
}
