package com.api.mecanica.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mecanica.model.OrdensServicos;
import com.api.mecanica.model.OsMaoDeObra;
import com.api.mecanica.model.OsPecas;
import com.api.mecanica.repository.OrdensServicosRepository;

@Service
public class OrdensServicosService {

	@Autowired
	OrdensServicosRepository repository;

	public OrdensServicos createOS(OrdensServicos os) {
		os.setEntrada(new Date());
		os.setIsFinalizado(false);
		os.setTotalOsMaoDeObra(0.0);
		os.setTotalOsPecas(0.0);
		os.setTotalServico(0.0);
		return repository.save(os);
	}

	public List<OrdensServicos> findAll() throws Exception {
		var os = repository.findAll();
		if (os.size() == 0) {
			throw new Exception("Não há dados");
		}
		return os;
	}

	public Optional<OrdensServicos> findById(Long id) throws Exception {
		var os = repository.findById(id);
		if (!os.isPresent()) {
			throw new Exception("Não há OS com o ID " + id);
		}
		return os;
	}

	public OrdensServicos alterOS(OrdensServicos os) throws Exception {
		var nova = findById(os.getId());
		if (nova.get().getIsFinalizado()) {
			throw new Exception("Não se pode alterar uma  OS Finalizada");
		}
		// total serviço
		os = calculaOs(os);
		return repository.saveAndFlush(os);
	}

	public OrdensServicos finalizarOs(OrdensServicos os) throws Exception {
		var nova = findById(os.getId());

		if (nova.get().getIsFinalizado()) {
			throw new Exception("OS já Finalizada");
		}

		os.setSaida(new Date());
		os.setIsFinalizado(true);
		os = calculaOs(os);
		return repository.saveAndFlush(os);
	}

	public OrdensServicos calculaOs(OrdensServicos os) {
		os.setTotalServico(os.getTotalOsMaoDeObra() + os.getTotalOsPecas());
		return os;
	}

	public boolean isAtivoOS(Long id) throws Exception {
		var os = findById(id);
		if (os.isPresent()) {
			if (os.get().getIsFinalizado()) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

	public void addMao(OsMaoDeObra mao, Long id) throws Exception {
		var os = findById(id).get();

		os.setTotalOsMaoDeObra(os.getTotalOsMaoDeObra() + mao.getTotal());

		os = calculaOs(os);

		List<OsMaoDeObra> list = os.getIdOsMaoDeObra();
		list.add(mao);

		os.setIdOsMaoDeObra(list);

		repository.save(os);
	}

	public void deleteMao(OsMaoDeObra mao, Long id) throws Exception {
		var os = findById(id).get();

		os.setTotalOsMaoDeObra(os.getTotalOsMaoDeObra() - mao.getTotal());

		os = calculaOs(os);

		List<OsMaoDeObra> list = os.getIdOsMaoDeObra();
		list.remove(mao);

		os.setIdOsMaoDeObra(list);

		repository.save(os);
	}

	public void addPeca(OsPecas peca, Long id) throws Exception {
		var os = findById(id).get();

		os.setTotalOsPecas(os.getTotalOsPecas() + peca.getTotal());

		os = calculaOs(os);

		List<OsPecas> list = os.getIdOsPecas();
		list.add(peca);

		os.setIdOsPecas(list);

		repository.save(os);
	}

	public void deletePeca(OsPecas peca, Long id) throws Exception {
		var os = findById(id).get();

		os.setTotalOsPecas(os.getTotalOsPecas() - peca.getTotal());

		os = calculaOs(os);

		List<OsPecas> list = os.getIdOsPecas();
		list.remove(peca);

		os.setIdOsPecas(list);

		repository.save(os);
	}

}
