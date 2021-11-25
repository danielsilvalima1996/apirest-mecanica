package com.api.mecanica.repository;

import com.api.mecanica.model.Labor;

import org.springframework.data.jpa.repository.JpaRepository;
public interface LaborRepository extends JpaRepository<Labor, Long> {
}