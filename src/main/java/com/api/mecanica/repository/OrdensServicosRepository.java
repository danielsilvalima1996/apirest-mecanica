package com.api.mecanica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.mecanica.model.OrdensServicos;

public interface OrdensServicosRepository extends JpaRepository<OrdensServicos, Long> {

}
