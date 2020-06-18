package com.api.mecanica.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mecanica.constants.AppConstants;
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
			veiculoAtualizado.setActive(veiculo.isActive());
			
			return Optional.of(veiculoRepository.saveAndFlush(veiculoAtualizado));
			
		} else {
			return Optional.empty();
		}
	}

	@Override
	public void cadastrarVeiculo(@Valid Veiculo veiculo) {

		try {
			veiculo.setActive(AppConstants.VEICULO_ATIVO);
			veiculoRepository.saveAndFlush(veiculo);
			
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public List<Veiculo> buscarVeiculosPorFiltro(Long idVeiculo, String marcaVeiculo, String modeloVeiculo,
			Long anoVeiculo) {
		
		if(idVeiculo != null && marcaVeiculo == null && modeloVeiculo == null && anoVeiculo == null) {
			System.out.println("só veiculo");
		} else if(marcaVeiculo != null && idVeiculo == null && modeloVeiculo == null && anoVeiculo == null) {
			System.out.println("só marca");
		} else if(modeloVeiculo != null && marcaVeiculo == null && idVeiculo == null && anoVeiculo == null) {
			System.out.println("só modelo");
		} else if(anoVeiculo != null && modeloVeiculo == null && marcaVeiculo == null && idVeiculo == null) {
			System.out.println("só ano");
		} else if(marcaVeiculo != null && idVeiculo != null && modeloVeiculo == null && anoVeiculo == null) {
			System.out.println("marca e id");
		} else if(marcaVeiculo != null && idVeiculo != null && modeloVeiculo != null && anoVeiculo == null) {
			System.out.println("marca, id e modelo");
		} else if(marcaVeiculo != null && idVeiculo != null && anoVeiculo != null && modeloVeiculo == null) {
			System.out.println("marca, id e ano");
		} else if(marcaVeiculo != null && idVeiculo != null && modeloVeiculo != null && anoVeiculo != null) {
			System.out.println("todos");
		} 
		
		return null;
	}

}
