package com.api.mecanica.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.api.mecanica.model.Veiculo;

public interface VeiculoRepository extends  JpaRepository<Veiculo, Long>, JpaSpecificationExecutor<Veiculo>{

	List<Veiculo> findByActive(boolean active);
	
	long countByActive(Boolean active);
	
	long count();
	
}