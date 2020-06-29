package com.api.mecanica.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.mecanica.model.OrdensServicos;

public interface OrdensServicosRepository extends JpaRepository<OrdensServicos, Long> {

	List<OrdensServicos> findAll(Specification<OrdensServicos> and, Sort sort);
	
	long countByIsFinalizado(int isFinalizado);
	
	long count();
	
	@Query(value = "SELECT SUM(os.total_servico) FROM ordens_servicos os where os.is_finalizado = :isFinalizado", nativeQuery = true)
	Double sumTotalOsByIsFinalizado(@Param("isFinalizado") int isFinalizado);
	
	@Query(value = "SELECT SUM(total_servico) FROM ordens_servicos ", nativeQuery = true)
	double sumTotalOs();
	
	
}
