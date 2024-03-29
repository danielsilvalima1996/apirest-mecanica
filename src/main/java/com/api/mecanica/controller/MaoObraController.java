package com.api.mecanica.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

import com.api.mecanica.exception.MaoDeObraException;
import com.api.mecanica.model.MaoDeObra;
import com.api.mecanica.service.MaoDeObraService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/mao-obra")
public class MaoObraController {

	@Autowired
	MaoDeObraService service;

	@ApiOperation(value = "Retorna uma lista de mão de obra cadastrada")
	@GetMapping(value = "all", produces = { "application/json" })
	public ResponseEntity<List<MaoDeObra>> findAll() {

		try {
			final List<MaoDeObra> maoObraRetornadas = service.findAll();

			if (maoObraRetornadas.size() > 0) {
				return new ResponseEntity<List<MaoDeObra>>(maoObraRetornadas, HttpStatus.OK);
			}
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@ApiOperation(value = "Traz uma mão de obra pelo id")
	@GetMapping(value = "{id}", produces = { "application/json" })
	public ResponseEntity<MaoDeObra> findById(@PathVariable(value = "id") Long id) {
		try {
			return service.findById(id).map(x -> ResponseEntity.ok().body(x)).orElse(ResponseEntity.notFound().build());
		} catch (MaoDeObraException e) {
			return ResponseEntity.status(e.getErrorCode()).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/cadastrar")
	@ApiOperation(value = "Cadastra uma nova mao de obra")
	public ResponseEntity<MaoDeObra> cadastrarMaoDeObra(@Valid @RequestBody MaoDeObra maoDeObra) {
		try {

			service.cadastrarDeMaoObra(maoDeObra);

			return ResponseEntity.ok().build();

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@ApiOperation(value = "Atualiza uma mão de obra já cadastrada")
	@PutMapping("/atualizar")
	public MaoDeObra atualizarMaoDeObra(@RequestBody MaoDeObra maoDeObra) {
		return service.alterMaoDeObra(maoDeObra);
	}

	@ApiOperation(value = "Traz uma lista de mão de obras ativas")
	@GetMapping(value = "active")
	public List<MaoDeObra> findByActive(@RequestParam(value = "active") boolean active) {
		return service.findByActive(active);
	}

	@ApiOperation(value = "Traz uma lista de mão de obras pela descrição")
	@GetMapping(value = "descricao", produces = { "application/json" })
	public List<MaoDeObra> findByDescricaoContainingIgnoreCase(@RequestParam(value = "descricao") String descricao) {
		return service.findByDescricaoContainingIgnoreCase(descricao);
	}

	@ApiOperation(value = "Busca uma lista de Mão de Obras por ID ou Descrição")
	@GetMapping(value = "/busca", produces = { "application/json" })
	public List<MaoDeObra> findByFiltros(@Param(value = "id") Long id, @Param(value = "descricao") String descricao,
			@Param(value = "active") Boolean active) throws Exception {
		return service.findByFiltros(id, descricao, active);
	}
	
	@ApiOperation(value = "Cria Varias Mãos de Obras")
	@PostMapping(value = "all", consumes = { "application/json" }, produces = { "application/json" })
	public List<MaoDeObra> createMuitasMaos(@RequestBody List<MaoDeObra> maos) throws Exception {
		return service.createMuitasMaos(maos);
	}
}
