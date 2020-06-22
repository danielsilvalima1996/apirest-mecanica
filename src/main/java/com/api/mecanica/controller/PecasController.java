package com.api.mecanica.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.mecanica.constants.AppConstants;
import com.api.mecanica.exception.VeiculoException;
import com.api.mecanica.model.Pecas;
import com.api.mecanica.model.Veiculo;
import com.api.mecanica.service.PecasServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author [cristian.baptistella]
 * @since 2020-06-20
 */
@RestController
@CrossOrigin(origins="*")
@Api(value="API REST Pecas")
@RequestMapping("/api/peca")
public class PecasController implements RestService{

	@Autowired
	private PecasServiceImpl service;
	
	@PostMapping(AppConstants.CADASTRAR_PECA)
	@ApiOperation(value="Cadastrar uma nova peca")
	public ResponseEntity<?> cadastrarPeca(@Valid @RequestBody Pecas peca) {
		try {
			
			service.cadastrarPecas(peca);
			
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GetMapping(AppConstants.LISTAR_PECAS)
	@ApiOperation(value="Retorna uma lista de pecas cadastradas")
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
	@ApiOperation(value="Retorna uma lista de pecas cadastradas")
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
	@ApiOperation(value="Atualiza dados de uma peca já cadastrado")
	public ResponseEntity<?> atualizarPeca(@Valid @PathVariable Long id, @Valid @RequestBody Pecas peca) {
		
		Optional<Pecas> pecaRetorno = service.atualizarPeca(id, peca);
		
		if(pecaRetorno.isPresent()) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@GetMapping(AppConstants.BUSCAR_PECA_POR_ID)
	@ApiOperation(value="Retorna dados de uma peca cadastrado")
	public ResponseEntity<Optional<Pecas>> obterDadosPecas(@Valid @PathVariable Long id) {
		
		Optional<Pecas> pecaRetorno = service.buscarPecaById(id);
		
		if(pecaRetorno.isPresent()) {
			return ResponseEntity.ok().body(pecaRetorno);
		} 
		
		return ResponseEntity.notFound().build();
	
	}
	
	
	
	@GetMapping(AppConstants.BUSCAR_PECA_POR_MARCA)
	@ApiOperation(value="Retorna uma lista de pecas por marca")
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
	

	
}
