package com.api.mecanica.repository;

import com.api.mecanica.model.ClientVehicle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientVehicleRepository extends JpaRepository<ClientVehicle, Long> {
    
}
