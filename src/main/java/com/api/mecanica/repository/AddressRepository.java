package com.api.mecanica.repository;

import com.api.mecanica.model.Address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
