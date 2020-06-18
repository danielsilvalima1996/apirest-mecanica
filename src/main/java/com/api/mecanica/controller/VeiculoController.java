package com.api.mecanica.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.mecanica.model.Veiculo;
import com.api.mecanica.service.VeiculoServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="API REST Veiculo")
@RequestMapping("/api/veiculo")
public class VeiculoController implements RestService {

	private static final String CADASTRAR_VEICULO = "/cadastrar-veiculo";

	@Autowired
	private VeiculoServiceImpl veiculoService;
	
	@PostMapping(CADASTRAR_VEICULO)
	@ApiOperation(value="Cadastrar um novo veiculo")
	public ResponseEntity<?> cadastrarEstudante(@Valid @RequestBody Veiculo veiculo) {
		try {
			
			veiculoService.cadastrarVeiculo(veiculo);
			
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
