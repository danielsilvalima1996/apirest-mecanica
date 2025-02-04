package com.api.mecanica.controller;

import com.api.mecanica.constants.AppConstants;
import com.api.mecanica.exception.VeiculoException;
import com.api.mecanica.model.Veiculo;
import com.api.mecanica.service.VeiculoServiceImpl;
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
 * @since 2020-06-18
 */
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/veiculo")
public class VeiculoController implements RestService {


	@Autowired
	private VeiculoServiceImpl veiculoService;

	@PostMapping(AppConstants.CADASTRAR_VEICULO)
	@Operation(summary = "Cadastrar um novo veiculo")
	public ResponseEntity<?> cadastrarEstudante(@Valid @RequestBody Veiculo veiculo) {
		try {

			veiculoService.cadastrarVeiculo(veiculo);

			return ResponseEntity.ok().build();

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}


	@GetMapping(AppConstants.LISTAR_VEICULOS)
	@Operation(summary = "Retorna uma lista de veiculos cadastrados")
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

	@GetMapping(AppConstants.BUSCAR_VEICULOS_ATIVOS)
	@Operation(summary = "Retorna uma lista de veiculos cadastrados")
	public ResponseEntity<List<Veiculo>> obterListaVeiculosAtivos() {

		try {

			final List<Veiculo> veiculosRetornados = veiculoService.buscarVeiculosAtivos(true);

			if(veiculosRetornados.size() > 0) {
				return new ResponseEntity<List<Veiculo>>(veiculosRetornados, HttpStatus.OK);
			}

			return ResponseEntity.notFound().build();

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
	}

	@GetMapping(AppConstants.BUSCAR_VEICULO_POR_ID)
	@Operation(summary = "Retorna dados de um veiculo cadastrado")
	public ResponseEntity<Optional<Veiculo>> obterDadosVeiculo(@Valid @PathVariable Long id) {

		Optional<Veiculo> veiculoRetorno = veiculoService.buscarVeiculo(id);

		if(veiculoRetorno.isPresent()) {
			return ResponseEntity.ok().body(veiculoRetorno);
		}

		return ResponseEntity.notFound().build();

	}

	@PutMapping(AppConstants.ATUALIZAR_VEICULO)
	@Operation(summary = "Atualiza dados de um veiculo já cadastrado")
	public ResponseEntity<?> atualizarVeiculo(@Valid @PathVariable Long id, @Valid @RequestBody Veiculo veiculo) {

		Optional<Veiculo> veiculoRetorno = veiculoService.atualizarVeiculo(id, veiculo);

		if(veiculoRetorno.isPresent()) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();

	}


	@GetMapping(AppConstants.BUSCAR_VEICULO_POR_FILTROS)
	@Operation(summary = "Retorna uma lista de veiculos cadastrados por filtros")
	public ResponseEntity<List<Veiculo>> obterVeiculosPorFiltros(@Parameter(description = "Codigo identificador do veiculo")  @Valid @RequestParam(value = "idVeiculo", required = false) Long idVeiculo,
																 @Parameter(description = "Descricao da marca do veiculo")  @Valid @RequestParam(value = "marcaVeiculo", required = false) String marcaVeiculo,
																 @Parameter(description = "Descricao do modelo do veiculo") @Valid @RequestParam(value = "modeloVeiculo", required = false) String modeloVeiculo,
																 @Parameter(description = "Ano do veiculo") @Valid @RequestParam(value = "anoVeiculo", required = false) Long anoVeiculo,
																 @Parameter(description = "veículo ativo") @Valid @Param(value = "activeVeiculo") Boolean activeVeiculo) {
		
		try {
			
			final List<Veiculo> veiculosRetornados = veiculoService.buscarVeiculosPorFiltro(idVeiculo, marcaVeiculo, modeloVeiculo, anoVeiculo, activeVeiculo);
			
			if(veiculosRetornados.size() > 0) {
				return new ResponseEntity<List<Veiculo>>(veiculosRetornados, HttpStatus.OK);
			} 
			
			
				
			return ResponseEntity.notFound().build();

		} catch (VeiculoException e) {
			return ResponseEntity.status(e.getErrorCode()).build(); 
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
	}
	
	@Operation(summary ="Cria Varios Veiculos")
	@PostMapping(value = "all", consumes = { "application/json" }, produces = { "application/json" })
	public List<Veiculo> createMuitosVeiculos(@RequestBody List<Veiculo> veiculos) throws Exception {
		return veiculoService.createMuitosVeiculos(veiculos);
	}
	
}
