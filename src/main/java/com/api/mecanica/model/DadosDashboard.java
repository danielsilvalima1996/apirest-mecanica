package com.api.mecanica.model;

import java.io.Serializable;

public class DadosDashboard implements Serializable {

	private static final long serialVersionUID = 1L;

	// OS
	private Long quantidadeOS;
	private Long quantidadeOSAndamento;
	private Long quantidadeOSFinalizada;
	private Long quantidadeOSCancelada;

	private Double totalOS;
	private Double totalOSAndamento;
	private Double totalOSFinalizada;
	private Double totalOSCancelada;

	// Mão de obra
	private Long quantidadeMao;
	private Long quantidadeMaoAtiva;
	private Long quantidadeMaoInativa;

	// Peças
	private Long quantidadePeca;
	private Long quantidadePecaAtiva;
	private Long quantidadePecaInativa;

	// Veiculo
	private Long quantidadeVeiculo;
	private Long quantidadeVeiculoAtiva;
	private Long quantidadeVeiculoInativa;

	// User
	private Long quantidadeUser;
	private Long quantidadeUserAtiva;
	private Long quantidadeUserInativa;

	public DadosDashboard() {

	}

	public Long getQuantidadeOS() {
		return quantidadeOS;
	}

	public void setQuantidadeOS(Long quantidadeOS) {
		this.quantidadeOS = quantidadeOS;
	}

	public Long getQuantidadeOSAndamento() {
		return quantidadeOSAndamento;
	}

	public void setQuantidadeOSAndamento(Long quantidadeOSAndamento) {
		this.quantidadeOSAndamento = quantidadeOSAndamento;
	}

	public Long getQuantidadeOSFinalizada() {
		return quantidadeOSFinalizada;
	}

	public void setQuantidadeOSFinalizada(Long quantidadeOSFinalizada) {
		this.quantidadeOSFinalizada = quantidadeOSFinalizada;
	}

	public Long getQuantidadeOSCancelada() {
		return quantidadeOSCancelada;
	}

	public void setQuantidadeOSCancelada(Long quantidadeOSCancelada) {
		this.quantidadeOSCancelada = quantidadeOSCancelada;
	}

	public Double getTotalOS() {
		return totalOS;
	}

	public void setTotalOS(Double totalOS) {
		this.totalOS = totalOS;
	}

	public Double getTotalOSAndamento() {
		return totalOSAndamento;
	}

	public void setTotalOSAndamento(Double totalOSAndamento) {
		this.totalOSAndamento = totalOSAndamento;
	}

	public Double getTotalOSFinalizada() {
		return totalOSFinalizada;
	}

	public void setTotalOSFinalizada(Double totalOSFinalizada) {
		this.totalOSFinalizada = totalOSFinalizada;
	}

	public Double getTotalOSCancelada() {
		return totalOSCancelada;
	}

	public void setTotalOSCancelada(Double totalOSCancelada) {
		this.totalOSCancelada = totalOSCancelada;
	}

	public Long getQuantidadeMao() {
		return quantidadeMao;
	}

	public void setQuantidadeMao(Long quantidadeMao) {
		this.quantidadeMao = quantidadeMao;
	}

	public Long getQuantidadeMaoAtiva() {
		return quantidadeMaoAtiva;
	}

	public void setQuantidadeMaoAtiva(Long quantidadeMaoAtiva) {
		this.quantidadeMaoAtiva = quantidadeMaoAtiva;
	}

	public Long getQuantidadeMaoInativa() {
		return quantidadeMaoInativa;
	}

	public void setQuantidadeMaoInativa(Long quantidadeMaoInativa) {
		this.quantidadeMaoInativa = quantidadeMaoInativa;
	}

	public Long getQuantidadePeca() {
		return quantidadePeca;
	}

	public void setQuantidadePeca(Long quantidadePeca) {
		this.quantidadePeca = quantidadePeca;
	}

	public Long getQuantidadePecaAtiva() {
		return quantidadePecaAtiva;
	}

	public void setQuantidadePecaAtiva(Long quantidadePecaAtiva) {
		this.quantidadePecaAtiva = quantidadePecaAtiva;
	}

	public Long getQuantidadePecaInativa() {
		return quantidadePecaInativa;
	}

	public void setQuantidadePecaInativa(Long quantidadePecaInativa) {
		this.quantidadePecaInativa = quantidadePecaInativa;
	}

	public Long getQuantidadeVeiculo() {
		return quantidadeVeiculo;
	}

	public void setQuantidadeVeiculo(Long quantidadeVeiculo) {
		this.quantidadeVeiculo = quantidadeVeiculo;
	}

	public Long getQuantidadeVeiculoAtiva() {
		return quantidadeVeiculoAtiva;
	}

	public void setQuantidadeVeiculoAtiva(Long quantidadeVeiculoAtiva) {
		this.quantidadeVeiculoAtiva = quantidadeVeiculoAtiva;
	}

	public Long getQuantidadeVeiculoInativa() {
		return quantidadeVeiculoInativa;
	}

	public void setQuantidadeVeiculoInativa(Long quantidadeVeiculoInativa) {
		this.quantidadeVeiculoInativa = quantidadeVeiculoInativa;
	}

	public Long getQuantidadeUser() {
		return quantidadeUser;
	}

	public void setQuantidadeUser(Long quantidadeUser) {
		this.quantidadeUser = quantidadeUser;
	}

	public Long getQuantidadeUserAtiva() {
		return quantidadeUserAtiva;
	}

	public void setQuantidadeUserAtiva(Long quantidadeUserAtiva) {
		this.quantidadeUserAtiva = quantidadeUserAtiva;
	}

	public Long getQuantidadeUserInativa() {
		return quantidadeUserInativa;
	}

	public void setQuantidadeUserInativa(Long quantidadeUserInativa) {
		this.quantidadeUserInativa = quantidadeUserInativa;
	}

}
