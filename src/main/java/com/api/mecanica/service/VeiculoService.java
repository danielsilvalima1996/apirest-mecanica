package com.api.mecanica.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.api.mecanica.model.Veiculo;

public interface VeiculoService {

	List<Veiculo> buscarVeiculos();

	void cadastrarVeiculo(@Valid Veiculo veiculo);

	Optional<Veiculo> buscarVeiculo(Long id);

	Optional<Veiculo> atualizarVeiculo(@Valid Long id, @Valid Veiculo veiculo);
	
	Optional<Veiculo> excluirVeiculo(@Valid Long id);

}
