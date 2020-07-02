package com.api.mecanica.service;

import static org.springframework.data.jpa.domain.Specification.where;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.api.mecanica.model.OrdensServicos;
import com.api.mecanica.model.OsMaoDeObra;
import com.api.mecanica.model.OsPecas;
import com.api.mecanica.repository.OrdensServicosRepository;
import com.api.mecanica.specification.OrdensServicosSpecification;

@Service
public class OrdensServicosService {

	@Autowired
	OrdensServicosRepository repository;

	public OrdensServicos createOS(OrdensServicos os) {
		os.setEntrada(new Date());
		os.setPlaca(os.getPlaca().toUpperCase());
		os.setIsFinalizado(0);
		os.setTotalOsMaoDeObra(0.0);
		os.setTotalOsPecas(0.0);
		os.setTotalServico(0.0);
		return repository.save(os);
	}

	public List<OrdensServicos> findAll(Long idOS, String nomeClienteOS, String cpfCnpjOS, String observacoesOS,
			Long idVeiculoOS, String placaOS, Long idUsuarioOS, Integer isFinalizadoOS) throws Exception {
		List<OrdensServicos> os = new ArrayList<>();
		os = repository.findAll(where(OrdensServicosSpecification.idOS(idOS))
				.and(OrdensServicosSpecification.nomeClienteOS(nomeClienteOS))
				.and(OrdensServicosSpecification.cpfCnpjOS(cpfCnpjOS))
				.and(OrdensServicosSpecification.observacoesOS(observacoesOS))
				.and(OrdensServicosSpecification.idVeiculoOS(idVeiculoOS))
				.and(OrdensServicosSpecification.placaOS(placaOS))
				.and(OrdensServicosSpecification.idUsuarioOS(idUsuarioOS))
				.and(OrdensServicosSpecification.isFinalizadoOS(isFinalizadoOS)), Sort.by(Sort.Direction.DESC, "id"));

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
		var nova = findById(os.getId()).get();
		if (nova.getIsFinalizado() != 0) {
			throw new Exception("Não se pode alterar uma  OS " + (nova.getIsFinalizado() == 1 ? "Finalizada" : "Cancelada"));
		}
		// total serviço
		os = calculaOs(os);
		return repository.saveAndFlush(os);
	}

	public OrdensServicos finalizarOs(Long id) throws Exception {
		var nova = findById(id).get();

		if (nova.getIsFinalizado() != 0) {
			throw new Exception("OS já " + (nova.getIsFinalizado() == 1 ? "Finalizada" : "Cancelada"));
		}

		nova.setSaida(new Date());
		nova.setIsFinalizado(1);
		return repository.save(nova);
	}
	
	public OrdensServicos cancelarOs(Long id) throws Exception {
		var nova = findById(id).get();

		if (nova.getIsFinalizado() != 0) {
			throw new Exception("OS já " + (nova.getIsFinalizado() == 1 ? "Finalizada" : "Cancelada"));
		}

		nova.setSaida(new Date());
		nova.setIsFinalizado(2);
		return repository.save(nova);
	}

	public OrdensServicos calculaOs(OrdensServicos os) {
		os.setTotalServico(os.getTotalOsMaoDeObra() + os.getTotalOsPecas());
		return os;
	}

	public boolean isAtivoOS(Long id) throws Exception {
		var os = findById(id);
		if (os.isPresent()) {
			if (os.get().getIsFinalizado() != 0) {
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
	
	public long countByIsFinalizado(int active) {
		return repository.countByIsFinalizado(active);
	}
	
	public long countAll() {
		return repository.count();
	}
	
	public Double sumTotalOsByIsFinalizado(int isFinalizado) {
		var ret = repository.sumTotalOsByIsFinalizado(isFinalizado);
		if (ret == null) {
			ret = (double) 0;
		}
		return ret;
	}
	
	public double sumTotalOs() {
		var ret = repository.sumTotalOs();
		if (ret == null) {
			ret = (double) 0;
		}
		return ret;
	}

}
