package com.api.mecanica.specification;

import org.springframework.data.jpa.domain.Specification;

import com.api.mecanica.model.MaoDeObra;


public class MaoDeObraSpecification {
	public static Specification<MaoDeObra> codigoMaoDeObra(Long idMaoDeObra) {
		if(idMaoDeObra == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), idMaoDeObra);
	}
	
	public static Specification<MaoDeObra> descricaoMaoDeObra(String descricaoMaoDeObra) {
		if(descricaoMaoDeObra == null) {
			return null;
		}
		
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.<String> get("descricao")), "%" + descricaoMaoDeObra + "%");
	}
	
	public static Specification<MaoDeObra> activeMaoDeObra(Boolean activeMaoDeObra) {
		if(activeMaoDeObra == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("active"), activeMaoDeObra);
	}
}
