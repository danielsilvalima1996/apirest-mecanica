package com.api.mecanica.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.api.mecanica.exception.VeiculoException;
import com.api.mecanica.model.Veiculo;

public interface VeiculoService {

	List<Veiculo> buscarVeiculos();
	
	List<Veiculo> buscarVeiculosAtivos(boolean active);

	void cadastrarVeiculo(@Valid Veiculo veiculo);

	Optional<Veiculo> buscarVeiculo(Long id);

	Optional<Veiculo> atualizarVeiculo(@Valid Long id, @Valid Veiculo veiculo);
	
	List<Veiculo> buscarVeiculosPorFiltro(Long idVeiculo, String marcaVeiculo, String modeloVeiculo, Long anoVeiculo, Boolean activeVeiculo) throws VeiculoException;
	
	List<Veiculo> createMuitosVeiculos(List<Veiculo> veiculos) throws VeiculoException, Exception;
	
	
	
}
