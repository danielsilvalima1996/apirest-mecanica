package com.api.mecanica.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.api.mecanica.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
