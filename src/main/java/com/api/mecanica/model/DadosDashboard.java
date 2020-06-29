package com.api.mecanica.model;

import java.io.Serializable;

public class DadosDashboard implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long quantidadeOS;
	private Long quantidadeOSAndamento;
	private Long quantidadeOSFinalizada;
	private Long quantidadeOSCancelada;
	
	private Double totalOS;
	private Double totalOSAndamento;
	private Double totalOSFinalizada;
	private Double totalOSCancelada;
	
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

}
