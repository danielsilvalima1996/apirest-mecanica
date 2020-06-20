package com.api.mecanica.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "os_pecas")
public class OsPecas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "quantidade")
	@NotNull
	private Integer quantidade;

	@NotNull
	@Column(name = "total")
	private Double total;

	@ManyToOne()
	@JoinColumn(name = "id_ordens_servico")
	private OrdensServicos idOrdemServico;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "pecas_itens_os",
			joinColumns = @JoinColumn(name = "pecas_id"), 
			inverseJoinColumns = @JoinColumn(name = "os_pecas_id"))
	private List<Pecas> idPecas;

	@NotNull
	@Column(name = "valor_unitario")
	private Double valorUnitario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public OrdensServicos getIdOrdemServico() {
		return idOrdemServico;
	}

	public void setIdOrdemServico(OrdensServicos idOrdemServico) {
		this.idOrdemServico = idOrdemServico;
	}

	public List<Pecas> getIdPecas() {
		return idPecas;
	}

	public void setIdPecas(List<Pecas> idPecas) {
		this.idPecas = idPecas;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

}
