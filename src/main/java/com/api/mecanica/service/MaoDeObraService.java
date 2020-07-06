package com.api.mecanica.service;

import static org.springframework.data.jpa.domain.Specification.where;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.mecanica.exception.MaoDeObraException;
import com.api.mecanica.model.MaoDeObra;
import com.api.mecanica.repository.MaoDeObraRepository;
import com.api.mecanica.specification.MaoDeObraSpecification;

@Service
public class MaoDeObraService {

	@Autowired
	MaoDeObraRepository repository;

	public Optional<MaoDeObra> findById(Long id) throws MaoDeObraException {
		var os = repository.findById(id);
		if (!os.isPresent()) {
			throw new MaoDeObraException(HttpStatus.NOT_FOUND.value(), "Não tem mão de obra para esse ID");
		}
		return os;
	}

	public List<MaoDeObra> findAll() {
		return repository.findAll();
	}

	public MaoDeObra cadastrarDeMaoObra(MaoDeObra maoDeObra) {
		return repository.save(maoDeObra);
	}

	public MaoDeObra alterMaoDeObra(MaoDeObra maoDeObra) {
		return repository.save(maoDeObra);
	}

	public List<MaoDeObra> findByActive(boolean active) {
		return repository.findByActive(active, Sort.by("descricao"));
	}

	public List<MaoDeObra> findByDescricaoContainingIgnoreCase(String descricao) {
		return repository.findByDescricaoContainingIgnoreCase(descricao);
	}

	public boolean isAtivoMao(Long id) throws MaoDeObraException {
		var mao = findById(id);
		if (mao.isPresent()) {
			return true;
		}
		return false;
	}

	public List<MaoDeObra> findByFiltros(Long id, String descricao, Boolean active) throws Exception {
		List<MaoDeObra> maoDeObra = new ArrayList<>();
		maoDeObra = repository.findAll(where(MaoDeObraSpecification.codigoMaoDeObra(id))
				.and(MaoDeObraSpecification.descricaoMaoDeObra(descricao))
				.and(MaoDeObraSpecification.activeMaoDeObra(active)));

		if (maoDeObra.size() == 0) {
			throw new Exception("Não há dados");
		}
		return maoDeObra;
	}

	public long countByActive(Boolean active) {
		return repository.countByActive(active);
	}

	public long countAll() {
		return repository.count();
	}
	
	public List<MaoDeObra> createMuitasMaos(List<MaoDeObra> maos) throws Exception {
		if (maos.size() < 1) {
			throw new Exception("Não há dados para salvar");
		}
		var dbMaos = repository.saveAll(maos);
		return dbMaos;
	}

}
