package com.api.mecanica.specification;

import org.springframework.data.jpa.domain.Specification;

import com.api.mecanica.model.OrdensServicos;

public class OrdensServicosSpecification {

	public static Specification<OrdensServicos> idOS(Long id) {
		if (id == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
	}

	public static Specification<OrdensServicos> nomeClienteOS(String nomeCliente) {
		if (nomeCliente == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.like(criteriaBuilder.lower(root.<String>get("nomeCliente")), "%" + nomeCliente + "%");
	}

	public static Specification<OrdensServicos> cpfCnpjOS(String cpfCnpj) {
		if (cpfCnpj == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.like(criteriaBuilder.lower(root.<String>get("cpfCnpj")), "%" + cpfCnpj + "%");
	}

	public static Specification<OrdensServicos> observacoesOS(String observacoes) {
		if (observacoes == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.like(criteriaBuilder.lower(root.<String>get("observacoes")), "%" + observacoes + "%");
	}

	public static Specification<OrdensServicos> idVeiculoOS(Long idVeiculo) {
		if (idVeiculo == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("idVeiculo"), idVeiculo);
	}

	public static Specification<OrdensServicos> placaOS(String placa) {
		if (placa == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.like(criteriaBuilder.lower(root.<String>get("placa")), "%" + placa + "%");
	}

	public static Specification<OrdensServicos> idUsuarioOS(Long idUsuario) {
		if (idUsuario == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("idUsuario"), idUsuario);
	}

	public static Specification<OrdensServicos> isFinalizadoOS(Integer isFinalizado) {
		if (isFinalizado == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("isFinalizado"), isFinalizado);
	}

}
