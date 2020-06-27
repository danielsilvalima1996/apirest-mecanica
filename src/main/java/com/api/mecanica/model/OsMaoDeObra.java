package com.api.mecanica.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.internal.util.stereotypes.Immutable;

@Entity
@Table(name = "os_mao_de_obra")
public class OsMaoDeObra implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Immutable
	@Column(name = "total")
	private Double total;

	@NotNull
	@Column(name = "quantidade")
	private int quantidade;

	@NotNull
	@ManyToOne()
	@JoinColumn(name = "id_mao_de_obra")
	private MaoDeObra idMaoDeObra;
	
	@ManyToOne
	@JoinColumn(name = "ordens_servicos_id")
	private OrdensServicos ordensServicos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public MaoDeObra getIdMaoDeObra() {
		return idMaoDeObra;
	}

	public void setIdMaoDeObra(MaoDeObra idMaoDeObra) {
		this.idMaoDeObra = idMaoDeObra;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setOrdensServicos(OrdensServicos ordensServicos) {
		this.ordensServicos = ordensServicos;
	}

}
