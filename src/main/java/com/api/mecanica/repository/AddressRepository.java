package com.api.mecanica.repository;

import java.util.List;

import com.api.mecanica.model.Address;
import com.api.mecanica.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByClient(Client client);
    
}
