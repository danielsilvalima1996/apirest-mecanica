package com.api.mecanica.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.api.mecanica.model.Veiculo;

public interface VeiculoRepository extends  JpaRepository<Veiculo, Long>, JpaSpecificationExecutor<Veiculo>{

}


/*public interface VeiculoRepository extends CrudRepository<Veiculo, Long>,
	JpaSpecificationExecutor<Veiculo> {
}*/