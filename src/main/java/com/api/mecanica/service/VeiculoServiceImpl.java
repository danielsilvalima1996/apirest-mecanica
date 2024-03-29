package com.api.mecanica.service;

import static org.springframework.data.jpa.domain.Specification.where;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.mecanica.constants.AppConstants;
import com.api.mecanica.exception.VeiculoException;
import com.api.mecanica.model.Veiculo;
import com.api.mecanica.repository.VeiculoRepository;
import com.api.mecanica.specification.VeiculoSpecification;


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
			Long anoVeiculo, Boolean activeVeiculo) throws VeiculoException {
		
		List<Veiculo> veiculos = new ArrayList<>();
		
		try {
										
			veiculos = this.veiculoRepository.findAll(
					where(VeiculoSpecification.codigoVeiculo(idVeiculo))
					.and(VeiculoSpecification.marcaPadraoVeiculo(marcaVeiculo))
					.and(VeiculoSpecification.modeloPadraoVeiculo(modeloVeiculo))
					.and(VeiculoSpecification.anoPadraoVeiculo(anoVeiculo))
					.and(VeiculoSpecification.activePadraoVeiculo(activeVeiculo)));
			
			
			if(veiculos.size() == 0) {
				throw new VeiculoException(HttpStatus.NOT_FOUND.value(), "Veiculo não encontrado");
			}
			
		} catch (VeiculoException e) {
			throw e;
		} catch (Exception e) {
			throw new VeiculoException(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
		
		return veiculos;
	}

	@Override
	public List<Veiculo> buscarVeiculosAtivos(boolean active) {
		
		List<Veiculo> veiculos = new ArrayList<>();
		
		try {
			
			veiculos = veiculoRepository.findByActive(active, Sort.by("marca", "modelo"));
			
		} catch (Exception e) {
			throw e;
		}
		
		return veiculos;
	}
	
	public long countByActive(Boolean active) {
		return veiculoRepository.countByActive(active);
	}

	public long countAll() {
		return veiculoRepository.count();
	}

	@Override
	public List<Veiculo> createMuitosVeiculos(List<Veiculo> veiculos) throws Exception {
		if (veiculos.size() < 1) {
			throw new Exception("Não há dados para salvar");
		}
		var dbVeiculos = veiculoRepository.saveAll(veiculos);
		return dbVeiculos;
	}

	

}
