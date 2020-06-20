package com.api.mecanica.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pecas")
public class Pecas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "marca")
	@NotBlank(message = "A marca da peca deve ser preenchida")
	@NotNull
	private String marca;

	@NotNull
	@NotBlank(message = "O modelo da peca deve ser preenchido")
	@Column(name = "modelo")
	private String modelo;

	@NotNull
	@NotBlank(message = "A descricao da peca deve ser preenchida")
	@Column(name = "descricao")
	private String descricao;

	@NotNull(message = "O valor da peca deve ser preenchido")
	@Column(name = "valorUnitario")
	private Double valorUnitario;

	@NotNull
	@Column(name = "active")
	private boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}