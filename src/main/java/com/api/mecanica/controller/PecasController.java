package com.api.mecanica.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.mecanica.constants.AppConstants;
import com.api.mecanica.model.Pecas;
import com.api.mecanica.model.Veiculo;
import com.api.mecanica.service.PecasServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
	
}
