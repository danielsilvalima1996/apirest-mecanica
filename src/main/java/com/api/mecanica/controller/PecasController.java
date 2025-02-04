package com.api.mecanica.controller;

import com.api.mecanica.constants.AppConstants;
import com.api.mecanica.exception.PecaException;
import com.api.mecanica.model.Pecas;
import com.api.mecanica.service.PecasServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author [cristian.baptistella]
 * @since 2020-06-20
 */
@RestController
@CrossOrigin(origins="*")
@RequestMapping(value = "/api/peca")
public class PecasController implements RestService{

	@Autowired
	private PecasServiceImpl service;
	
	@PostMapping(AppConstants.CADASTRAR_PECA)
	@Operation(summary = "Cadastrar uma nova peca")
	public ResponseEntity<?> cadastrarPeca(@Valid @RequestBody Pecas peca) {
		try {
			
			service.cadastrarPecas(peca);
			
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GetMapping(AppConstants.LISTAR_PECAS)
	@Operation(summary = "Retorna uma lista de pecas cadastradas")
	public ResponseEntity<List<Pecas>> obterListaPecas() {
		
		try {
			
			final List<Pecas> pecasRetornadas = service.buscarPecas();
			
			if(pecasRetornadas.size() > 0) {
				return new ResponseEntity<List<Pecas>>(pecasRetornadas, HttpStatus.OK);
			} 
				
			return ResponseEntity.notFound().build();

		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
	}
	
	@GetMapping(AppConstants.LISTAR_PECAS_ATIVAS)
	@Operation(summary = "Retorna uma lista de pecas cadastradas")
	public ResponseEntity<List<Pecas>> obterListaPecasAtivas() {
		
		try {
			
			final List<Pecas> pecasRetornadas = service.buscarPecasAtivas(true);
			
			if(pecasRetornadas.size() > 0) {
				return new ResponseEntity<List<Pecas>>(pecasRetornadas, HttpStatus.OK);
			} 
				
			return ResponseEntity.notFound().build();

		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
	}
	
	
	@PutMapping(AppConstants.ATUALIZAR_PECA)
	@Operation(summary = "Atualiza dados de uma peca já cadastrado")
	public ResponseEntity<?> atualizarPeca(@Valid @PathVariable Long id, @Valid @RequestBody Pecas peca) {
		
		Optional<Pecas> pecaRetorno = service.atualizarPeca(id, peca);
		
		if(pecaRetorno.isPresent()) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@GetMapping(AppConstants.BUSCAR_PECA_POR_ID)
	@Operation(summary = "Retorna dados de uma peca cadastrado")
	public ResponseEntity<Optional<Pecas>> obterDadosPecas(@Valid @PathVariable Long id) {
		
		Optional<Pecas> pecaRetorno = service.buscarPecaById(id);
		
		if(pecaRetorno.isPresent()) {
			return ResponseEntity.ok().body(pecaRetorno);
		} 
		
		return ResponseEntity.notFound().build();
	
	}
	
	
	
	@GetMapping(AppConstants.BUSCAR_PECA_POR_MARCA)
	@Operation(summary = "Retorna uma lista de pecas por marca")
	public ResponseEntity<List<Pecas>> obterListaPecasPorMarca(@Valid @PathVariable String marca) {
		
		try {
			
			final List<Pecas> pecasRetornadas = service.buscarPecasPorMarca(marca);
			
			if(pecasRetornadas.size() > 0) {
				return new ResponseEntity<List<Pecas>>(pecasRetornadas, HttpStatus.OK);
			} 
				
			return ResponseEntity.notFound().build();

		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
	}
	
	@GetMapping(AppConstants.BUSCAR_PECA_POR_DESCRICAO)
	@Operation(summary = "Retorna uma lista de pecas por descricao")
	public ResponseEntity<List<Pecas>> obterListaPecasPorDescricao(@Valid @PathVariable String descricao) {
		
		try {
			
			final List<Pecas> pecasRetornadas = service.buscarPecasPorDescricao(descricao);
			
			if(pecasRetornadas.size() > 0) {
				return new ResponseEntity<List<Pecas>>(pecasRetornadas, HttpStatus.OK);
			} 
				
			return ResponseEntity.notFound().build();

		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
	}
	
	@GetMapping(AppConstants.BUSCAR_PECA_POR_FILTROS)
	@Operation(summary = "Retorna uma lista de veiculos cadastrado por filtros")
	public ResponseEntity<List<Pecas>> obterPecaPorFiltros(@Parameter(description="Codigo identificador da peca") @Valid @RequestParam(value = "idPeca", required = false) Long idPeca,
														   @Parameter(description="Descrição da peca") @Valid @RequestParam(value = "descricaoPeca", required = false) String descricaoPeca,
														   @Parameter(description="Modelo da peca") @Valid @RequestParam(value = "modeloPeca", required = false) String modeloPeca,
														   @Parameter(description="Atividade da peca") @Valid @Param(value = "active") Boolean active,
														   @Parameter(description="Marca da peca") @Valid @RequestParam(value = "marcaPeca", required = false) String marcaPeca) {
		
		try {
			
			final List<Pecas> pecasRetornada = service.buscarPecasPorFiltros( idPeca,  marcaPeca,  descricaoPeca,  modeloPeca,  active);
			
			if(pecasRetornada.size() > 0) {
				return new ResponseEntity<List<Pecas>>(pecasRetornada, HttpStatus.OK);
			}
			
			return ResponseEntity.notFound().build();

		} catch (PecaException e) {
			return ResponseEntity.status(e.getErrorCode()).build(); 
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Operation(summary = "Cria Varias Peças")
	@PostMapping(value = "all", consumes = { "application/json" }, produces = { "application/json" })
	public List<Pecas> createMuitasPecas(@RequestBody List<Pecas> pecas) throws Exception {
		return service.createMuitasPecas(pecas);
	}

	
}
