package com.api.mecanica.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.api.mecanica.exception.PecaException;
import com.api.mecanica.model.Pecas;

public interface PecasService {

	List<Pecas> buscarPecas();
	
	List<Pecas> buscarPecasAtivas(boolean active);

	void cadastrarPecas(@Valid Pecas pecas); 
	
	Optional<Pecas> buscarPecaById(Long id);
	
	Optional<Pecas> atualizarPeca(@Valid Long id, @Valid Pecas peca);
	
	List<Pecas> buscarPecasPorMarca(String marca);
	
	List<Pecas> buscarPecasPorDescricao(String descricao);
	
	List<Pecas> buscarPecasPorFiltros(Long idPeca, String marcaPeca, String descricaoPeca, String modeloPeca, Boolean active) throws PecaException;
	
	boolean isAtivoPeca(Long id) throws Exception;
	
	Optional<Pecas> findById(Long id) throws Exception;
	
	List<Pecas> createMuitasPecas(List<Pecas> pecas) throws Exception;
}
