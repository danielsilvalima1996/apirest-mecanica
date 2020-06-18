package com.api.mecanica.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.api.mecanica.model.Veiculo;

@Service
public class VeiculoServiceImpl implements VeiculoService{

	@Override
	public List<Veiculo> buscarVeiculos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cadastrarVeiculo(@Valid Veiculo veiculo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Veiculo> buscarVeiculo(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Veiculo> atualizarVeiculo(@Valid Long id, @Valid Veiculo veiculo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Veiculo> excluirVeiculo(@Valid Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
