package com.api.mecanica.specification;

import org.springframework.data.jpa.domain.Specification;

import com.api.mecanica.model.Pecas;

/**
 * Specification para o filtro de busca de pecas.
 * @author [cristian.baptistella]
 * @since 2020-06-24
 */
public class PecaSpecification {

	public static Specification<Pecas> codigoPeca(Long idPeca) {
		if(idPeca == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), idPeca);
	}
	
	public static Specification<Pecas> marcaPadraoPeca(String marcaPeca) {
		if(marcaPeca == null) {
			return null;
		}
		
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.<String> get("marca")), "%" + marcaPeca + "%");
	}
	
	public static Specification<Pecas> modeloPadraoPeca(String modeloPeca) {
		if(modeloPeca == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.<String> get("modelo")), "%" + modeloPeca + "%");
	}
	
	public static Specification<Pecas> descricaoPadraoPeca(String descricaoPeca) {
		if(descricaoPeca == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.<String> get("descricao")), "%" + descricaoPeca + "%");
	}
	
	public static Specification<Pecas> isActive(boolean active) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("active"), active);
	}
}
