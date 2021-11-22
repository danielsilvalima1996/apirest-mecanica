package com.api.mecanica.repository;

import com.api.mecanica.model.VehicleModel;

import org.springframework.data.jpa.repository.JpaRepository;
public interface VehicleModelRepository extends JpaRepository<VehicleModel, Long> {
}