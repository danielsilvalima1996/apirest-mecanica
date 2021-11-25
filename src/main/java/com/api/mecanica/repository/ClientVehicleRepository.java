package com.api.mecanica.repository;

import java.util.List;

import com.api.mecanica.model.Client;
import com.api.mecanica.model.ClientVehicle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientVehicleRepository extends JpaRepository<ClientVehicle, Long> {

    List<ClientVehicle> findByClient(Client client);
    
}
