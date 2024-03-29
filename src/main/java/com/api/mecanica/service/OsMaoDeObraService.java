package com.api.mecanica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mecanica.model.OsMaoDeObra;
import com.api.mecanica.repository.OsMaoDeObraRepository;

@Service
public class OsMaoDeObraService {

	@Autowired
	OsMaoDeObraRepository repository;

	@Autowired
	OrdensServicosService osService;

	@Autowired
	MaoDeObraService maoService;

	public OsMaoDeObra createOsMaoDeObra(OsMaoDeObra os, Long id) throws Exception {
		if (!osService.isAtivoOS(id)) {
			throw new Exception("OS " + id + " Não existe");
		}
		if (!maoService.isAtivoMao(os.getIdMaoDeObra().getId())) {
			throw new Exception("Mão de obra " + os.getId() + " Não existe");
		}
		var mao = maoService.findById(os.getIdMaoDeObra().getId());
		var nova = osService.findById(id).get();

		os.setValorUnitario(mao.get().getValorUnitario());
		os.setTotal(os.getQuantidade() * os.getValorUnitario());
		os.setOrdensServicos(nova);
		OsMaoDeObra maoRet = repository.save(os);
		
		osService.addMao(maoRet, id);

		return maoRet;
	}

	public void deleteOsMaoDeObra(OsMaoDeObra os, Long id) throws Exception {
		if (!osService.isAtivoOS(id)) {
			throw new Exception("OS " + id + " Não existe");
		}
		if (!maoService.isAtivoMao(os.getIdMaoDeObra().getId())) {
			throw new Exception("Mão de obra " + os.getId() + " Não existe");
		}
		try {
		osService.deleteMao(os, id);
		repository.delete(os);
		} catch (Exception e) {
			throw new Exception("Erro ao excluir mão de obra " + os.getId());
		}
	}
}
