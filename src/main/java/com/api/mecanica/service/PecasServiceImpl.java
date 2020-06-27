package com.api.mecanica.service;

import static org.springframework.data.jpa.domain.Specification.where;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.mecanica.constants.AppConstants;
import com.api.mecanica.exception.PecaException;
import com.api.mecanica.model.Pecas;
import com.api.mecanica.repository.PecasRepository;
import com.api.mecanica.specification.PecaSpecification;

@Service
public class PecasServiceImpl implements PecasService {

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

		if (peca.isPresent()) {
			return peca;
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Optional<Pecas> atualizarPeca(@Valid Long id, @Valid Pecas peca) {

		Optional<Pecas> dadosAtuais = repository.findById(id);

		if (dadosAtuais.isPresent()) {

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

	@Override
	public List<Pecas> buscarPecasPorDescricao(String descricao) {

		List<Pecas> peca = new ArrayList<>();

		try {
			peca = repository.findByDescricaoContainingIgnoreCase(descricao);

		} catch (Exception e) {

			throw e;
		}

		return peca;
	}

	@Override
	public List<Pecas> buscarPecasPorFiltros(Long idPeca, String marcaPeca, String descricaoPeca, String modeloPeca,
			boolean active) throws PecaException {

		List<Pecas> pecas = new ArrayList<>();
		active = true;

		try {
			pecas = repository.findAll(where(PecaSpecification.codigoPeca(idPeca))
					.and(PecaSpecification.marcaPadraoPeca(marcaPeca))
					.and(PecaSpecification.modeloPadraoPeca(modeloPeca))
					.and(PecaSpecification.descricaoPadraoPeca(descricaoPeca)).and(PecaSpecification.isActive(active)));

			if (pecas.size() == 0) {
				throw new PecaException(HttpStatus.NOT_FOUND.value(), "Peca não encontrada");
			}

		} catch (PecaException e) {
			throw e;
		} catch (Exception e) {
			throw new PecaException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro ao buscar peça");
		}

		return pecas;
	}

	@Override
	public boolean isAtivoPeca(Long id) throws Exception {
		var peca = findById(id);
		if (peca.isPresent()) {
			return true;
		}
		return false;
	}

	@Override
	public Optional<Pecas> findById(Long id) throws Exception {
		var os = repository.findById(id);
		if (!os.isPresent()) {
			throw new Exception("Não tem peça para esse ID");
		}
		return os;
	}

}
