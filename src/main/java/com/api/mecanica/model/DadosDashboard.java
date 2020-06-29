package com.api.mecanica.model;

import java.io.Serializable;

public class DadosDashboard implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long totalOS;
	private Long totalOSAndamento;
	private Long totalOSFinalizada;
	private Long totalOSCancelada;
	
	public DadosDashboard() {
		
	}

	public Long getTotalOS() {
		return totalOS;
	}

	public void setTotalOS(Long totalOS) {
		this.totalOS = totalOS;
	}

	public Long getTotalOSAndamento() {
		return totalOSAndamento;
	}

	public void setTotalOSAndamento(Long totalOSAndamento) {
		this.totalOSAndamento = totalOSAndamento;
	}

	public Long getTotalOSFinalizada() {
		return totalOSFinalizada;
	}

	public void setTotalOSFinalizada(Long totalOSFinalizada) {
		this.totalOSFinalizada = totalOSFinalizada;
	}

	public Long getTotalOSCancelada() {
		return totalOSCancelada;
	}

	public void setTotalOSCancelada(Long totalOSCancelada) {
		this.totalOSCancelada = totalOSCancelada;
	}

}
