package com.api.mecanica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.mecanica.model.Pecas;

public interface PecasRepository extends JpaRepository<Pecas, Long> {

}
