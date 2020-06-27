package com.api.mecanica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mecanica.model.OsPecas;
import com.api.mecanica.repository.OsPecasRepository;

@Service
public class OsPecasService {

	@Autowired
	OsPecasRepository repository;

	@Autowired
	OrdensServicosService osService;

	@Autowired
	PecasServiceImpl pecasService;

	public OsPecas createOsPecas(OsPecas os, Long id) throws Exception {
		if (!osService.isAtivoOS(id)) {
			throw new Exception("OS " + id + " Não existe");
		}
		if (!pecasService.isAtivoPeca(os.getIdPecas().getId())) {
			throw new Exception("Peca " + os.getIdPecas().getId() + " Não existe");
		}
		var peca = pecasService.findById(os.getIdPecas().getId());
		var nova = osService.findById(id).get();

		os.setTotal(os.getQuantidade() * peca.get().getValorUnitario());
		os.setOrdensServicos(nova);
		OsPecas pecaRet = repository.save(os);

		osService.addPeca(pecaRet, id);
		return pecaRet;
	}

	public void deleteOsMaoDeObra(OsPecas os, Long id) throws Exception {
		if (!osService.isAtivoOS(id)) {
			throw new Exception("OS " + id + " Não existe");
		}
		if (!pecasService.isAtivoPeca(os.getIdPecas().getId())) {
			throw new Exception("Peca " + os.getId() + " Não existe");
		}
		osService.deletePeca(os, id);
		repository.delete(os);
	}
}
