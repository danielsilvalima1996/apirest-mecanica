package com.api.mecanica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.api.mecanica.model.Pecas;

public interface PecasRepository extends JpaRepository<Pecas, Long>, JpaSpecificationExecutor<Pecas>{

	List<Pecas> findByActive(boolean active);
}
