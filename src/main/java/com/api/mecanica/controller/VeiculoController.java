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
import org.springframework.web.bind.annotation.RestController;

import com.api.mecanica.constants.AppConstants;
import com.api.mecanica.model.Veiculo;
import com.api.mecanica.service.VeiculoServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * @author [cristian.baptistella]
 * @since 2020-06-18
 */
@RestController
@CrossOrigin(origins="*")
@Api(value="API REST Veiculo")
@RequestMapping("/api/veiculo")
public class VeiculoController implements RestService {


	@Autowired
	private VeiculoServiceImpl veiculoService;
	
	@PostMapping(AppConstants.CADASTRAR_VEICULO)
	@ApiOperation(value="Cadastrar um novo veiculo")
	public ResponseEntity<?> cadastrarEstudante(@Valid @RequestBody Veiculo veiculo) {
		try {
			
			veiculoService.cadastrarVeiculo(veiculo);
			
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@GetMapping(AppConstants.LISTAR_VEICULOS)
	@ApiOperation(value="Retorna uma lista de veiculos cadastrados")
	public ResponseEntity<List<Veiculo>> obterListaVeiculos() {
		
		try {
			
			final List<Veiculo> veiculosRetornados = veiculoService.buscarVeiculos();
			
			if(veiculosRetornados.size() > 0) {
				return new ResponseEntity<List<Veiculo>>(veiculosRetornados, HttpStatus.OK);
			} 
				
			return ResponseEntity.notFound().build();

		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
	}
	
	@GetMapping(AppConstants.BUSCAR_VEICULO)
	@ApiOperation(value="Retorna dado de um veiculo cadastrado")
	public ResponseEntity<Optional<Veiculo>> obterDadosVeiculo(@Valid @PathVariable Long id) {
		
		Optional<Veiculo> veiculoRetorno = veiculoService.buscarVeiculo(id);
		
		if(veiculoRetorno.isPresent()) {
			return ResponseEntity.ok().body(veiculoRetorno);
		} 
		
		return ResponseEntity.notFound().build();
	
	}
	
	@PutMapping(AppConstants.ATUALIZAR_VEICULO)
	@ApiOperation(value="Atualiza dados de um veiculo já cadastrado")
	public ResponseEntity<?> atualizarVeiculo(@Valid @PathVariable Long id, @Valid @RequestBody Veiculo veiculo) {
		
		Optional<Veiculo> veiculoRetorno = veiculoService.atualizarVeiculo(id, veiculo); 
		
		if(veiculoRetorno.isPresent()) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}

	
}
