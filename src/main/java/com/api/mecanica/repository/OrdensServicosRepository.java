package com.api.mecanica.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.mecanica.model.OrdensServicos;

public interface OrdensServicosRepository extends JpaRepository<OrdensServicos, Long> {

	List<OrdensServicos> findAll(Specification<OrdensServicos> and);

}
