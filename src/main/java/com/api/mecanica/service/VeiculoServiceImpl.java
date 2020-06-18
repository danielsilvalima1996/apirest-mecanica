package com.api.mecanica.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mecanica.model.Veiculo;
import com.api.mecanica.repository.VeiculoRepository;
@Service
public class VeiculoServiceImpl implements VeiculoService{

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Override
	public List<Veiculo> buscarVeiculos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cadastrarVeiculo(@Valid Veiculo veiculo) {

		try {
			veiculoRepository.saveAndFlush(veiculo);
			
		} catch (Exception e) {
			throw e;
		}
		
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
