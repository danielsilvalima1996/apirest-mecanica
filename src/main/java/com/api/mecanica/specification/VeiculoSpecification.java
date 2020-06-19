package com.api.mecanica.specification;

import org.springframework.data.jpa.domain.Specification;

import com.api.mecanica.model.Veiculo;

/**
 * Specification para o filtro de busca de veiculos.
 * @author [cristian.baptistella]
 * @since 2020-06-19
 */
public class VeiculoSpecification {

	public static Specification<Veiculo> codigoVeiculo(Long idVeiculo) {
		if(idVeiculo == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), idVeiculo);
	}
	
	public static Specification<Veiculo> marcaPadraoVeiculo(String marcaVeiculo) {
		if(marcaVeiculo == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("marca"), marcaVeiculo);
	}
	
	public static Specification<Veiculo> modeloPadraoVeiculo(String modeloVeiculo) {
		if(modeloVeiculo == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("modelo"), modeloVeiculo);
	}
	
	public static Specification<Veiculo> anoPadraoVeiculo(Long anoVeiculo) {
		if(anoVeiculo == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("ano"), anoVeiculo);
	}
}
