package com.api.mecanica.service;

import java.util.ArrayList;
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
		
		List<Veiculo> veiculos = new ArrayList<>();
		
		try {
			
			veiculos = veiculoRepository.findAll();
			
		} catch (Exception e) {
			throw e;
		}
		
		return veiculos;
	}

	@Override
	public Optional<Veiculo> buscarVeiculo(Long id) {
		
		Optional<Veiculo> veiculo = veiculoRepository.findById(id);
		
		if(veiculo.isPresent()) {
			return veiculo;
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Optional<Veiculo> atualizarVeiculo(@Valid Long id, @Valid Veiculo veiculo) {
		
		Optional<Veiculo> dadosAtuais = veiculoRepository.findById(id);
		
		if(dadosAtuais.isPresent()) {
			
			Veiculo veiculoAtualizado = dadosAtuais.get();
			
			veiculoAtualizado.setMarca(veiculo.getMarca());
			veiculoAtualizado.setModelo(veiculo.getModelo());
			veiculoAtualizado.setModelo(veiculo.getModelo());
			veiculoAtualizado.setTipoCombustivel(veiculo.getTipoCombustivel());
			veiculoAtualizado.setAno(veiculo.getAno());
			
			return Optional.of(veiculoRepository.saveAndFlush(veiculoAtualizado));
			
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Optional<Veiculo> excluirVeiculo(@Valid Long id) {

		Optional<Veiculo> dadosVeiculo = veiculoRepository.findById(id);
		
		if(dadosVeiculo.isPresent()) {
			veiculoRepository.delete(dadosVeiculo.get());
			return dadosVeiculo;
		} else {
			return Optional.empty();
		}
	}

	@Override
	public void cadastrarVeiculo(@Valid Veiculo veiculo) {

		try {
			veiculoRepository.saveAndFlush(veiculo);
			
		} catch (Exception e) {
			throw e;
		}
		
	}

}
