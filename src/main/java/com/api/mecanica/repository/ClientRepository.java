package com.api.mecanica.repository;

import com.api.mecanica.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {	

}
