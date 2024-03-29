package com.api.mecanica.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.mecanica.model.MaoDeObra;

public interface MaoDeObraRepository extends JpaRepository<MaoDeObra, Long> {

	List<MaoDeObra> findByActive(boolean active, Sort sort);
	
	List<MaoDeObra> findByDescricaoContainingIgnoreCase(String descricao);
	
	List<MaoDeObra> findAll(Specification<MaoDeObra> specification);
	
	long countByActive(Boolean active);
	
	long count();
	
}
