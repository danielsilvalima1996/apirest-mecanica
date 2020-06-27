package com.api.mecanica.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.internal.util.stereotypes.Immutable;

@Entity
@Table(name = "ordens_servico")
public class OrdensServicos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "entrada")
	@Immutable
	private Date entrada;

	@Column(name = "saida")
	private Date saida;

	@Column(name = "nome_cliente")
	@NotNull
	private String nomeCliente;

	@Column(name = "cpf_cnpj")
	@NotNull
	@Size(min = 11, max = 14)
	private String cpfCnpj;

	@Column(name = "ddd", length = 2)
	@NotNull
	private String ddd;

	@Column(name = "telefone")
	@NotNull
	@Size(min = 8, max = 9)
	private String telefone;

	@Column(name = "observacoes", length = 500)
	@NotNull
	private String observacoes;

	@ManyToOne()
	@JoinColumn(name = "id_veiculo")
	private Veiculo idVeiculo;

	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "ordensServicos", fetch = FetchType.EAGER)
	private List<OsMaoDeObra> idOsMaoDeObra = new ArrayList<OsMaoDeObra>();

	@Column(name = "total_os_mao_de_obra")
	private Double totalOsMaoDeObra;

	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "ordensServicos", fetch = FetchType.EAGER)
	private List<OsPecas> idOsPecas = new ArrayList<OsPecas>();

	@Column(name = "total_os_pecas")
	private Double totalOsPecas;

	@Column(name = "total_servico")
	private Double totalServico;

	@ManyToOne()
	@JoinColumn(name = "id_usuario")
	private Users idUsuario;

	@Column(name = "is_finalizado")
	@Immutable
	private Boolean isFinalizado;

	public OrdensServicos() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public void setSaida(Date saida) {
		this.saida = saida;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Veiculo getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Veiculo idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public List<OsMaoDeObra> getIdOsMaoDeObra() {
		return idOsMaoDeObra;
	}

	public void setIdOsMaoDeObra(List<OsMaoDeObra> idOsMaoDeObra) {
		this.idOsMaoDeObra = idOsMaoDeObra;
	}

	public Double getTotalOsMaoDeObra() {
		return totalOsMaoDeObra;
	}

	public void setTotalOsMaoDeObra(Double totalOsMaoDeObra) {
		this.totalOsMaoDeObra = totalOsMaoDeObra;
	}

	public List<OsPecas> getIdOsPecas() {
		return idOsPecas;
	}

	public void setIdOsPecas(List<OsPecas> idOsPecas) {
		this.idOsPecas = idOsPecas;
	}

	public Double getTotalOsPecas() {
		return totalOsPecas;
	}

	public void setTotalOsPecas(Double totalOsPecas) {
		this.totalOsPecas = totalOsPecas;
	}
//
	public Double getTotalServico() {
		return totalServico;
	}

	public void setTotalServico(Double totalServico) {
		this.totalServico = totalServico;
	}

	public Users getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Users idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Boolean getIsFinalizado() {
		return isFinalizado;
	}

	public void setIsFinalizado(Boolean isFinalizado) {
		this.isFinalizado = isFinalizado;
	}

}
