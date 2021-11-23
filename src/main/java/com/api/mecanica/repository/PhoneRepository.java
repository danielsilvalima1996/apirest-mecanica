package com.api.mecanica.repository;

import java.util.List;

import com.api.mecanica.model.Client;
import com.api.mecanica.model.Phone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    
    List<Phone> findByClient(Client client);

}
