package com.api.mecanica.model;

import java.io.Serializable;

public class Dashboard implements Serializable {

	private static final long serialVersionUID = 1L;

	// OS
	private Long quantityOS;
	private Long quantityOSInProgress;
	private Long quantityOSFinished;
	private Long quantityOSCanceled;

	private Double totalOS;
	private Double totalOSInProgress;
	private Double totalOSFinished;
	private Double totalOSCanceled;

	// Mão de obra
	private Long quantityLabor;
	private Long quantityLaborActive;
	private Long quantityLaborInactive;

	// Parts
	private Long quantityPart;
	private Long quantityPartActive;
	private Long quantityPartInactive;

	// Vehicle
	private Long quantityVehicle;
	private Long quantityVehicleActive;
	private Long quantityVehicleInactive;

	// User
	private Long quantityUser;
	private Long quantityUserActive;
	private Long quantityUserInactive;

	public Dashboard() {

	}

	public Dashboard(Long quantityOS, Long quantityOSInProgress, Long quantityOSFinished, Long quantityOSCanceled,
			Double totalOS, Double totalOSInProgress, Double totalOSFinished, Double totalOSCanceled,
			Long quantityLabor, Long quantityLaborActive, Long quantityLaborInactive, Long quantityPart,
			Long quantityPartActive, Long quantityPartInactive, Long quantityVehicle, Long quantityVehicleActive,
			Long quantityVehicleInactive, Long quantityUser, Long quantityUserActive, Long quantityUserInactive) {
		this.quantityOS = quantityOS;
		this.quantityOSInProgress = quantityOSInProgress;
		this.quantityOSFinished = quantityOSFinished;
		this.quantityOSCanceled = quantityOSCanceled;
		this.totalOS = totalOS;
		this.totalOSInProgress = totalOSInProgress;
		this.totalOSFinished = totalOSFinished;
		this.totalOSCanceled = totalOSCanceled;
		this.quantityLabor = quantityLabor;
		this.quantityLaborActive = quantityLaborActive;
		this.quantityLaborInactive = quantityLaborInactive;
		this.quantityPart = quantityPart;
		this.quantityPartActive = quantityPartActive;
		this.quantityPartInactive = quantityPartInactive;
		this.quantityVehicle = quantityVehicle;
		this.quantityVehicleActive = quantityVehicleActive;
		this.quantityVehicleInactive = quantityVehicleInactive;
		this.quantityUser = quantityUser;
		this.quantityUserActive = quantityUserActive;
		this.quantityUserInactive = quantityUserInactive;
	}

	public Long getQuantityOS() {
		return quantityOS;
	}

	public void setQuantityOS(Long quantityOS) {
		this.quantityOS = quantityOS;
	}

	public Long getQuantityOSInProgress() {
		return quantityOSInProgress;
	}

	public void setQuantityOSInProgress(Long quantityOSInProgress) {
		this.quantityOSInProgress = quantityOSInProgress;
	}

	public Long getQuantityOSFinished() {
		return quantityOSFinished;
	}

	public void setQuantityOSFinished(Long quantityOSFinished) {
		this.quantityOSFinished = quantityOSFinished;
	}

	public Long getQuantityOSCanceled() {
		return quantityOSCanceled;
	}

	public void setQuantityOSCanceled(Long quantityOSCanceled) {
		this.quantityOSCanceled = quantityOSCanceled;
	}

	public Double getTotalOS() {
		return totalOS;
	}

	public void setTotalOS(Double totalOS) {
		this.totalOS = totalOS;
	}

	public Double getTotalOSInProgress() {
		return totalOSInProgress;
	}

	public void setTotalOSInProgress(Double totalOSInProgress) {
		this.totalOSInProgress = totalOSInProgress;
	}

	public Double getTotalOSFinished() {
		return totalOSFinished;
	}

	public void setTotalOSFinished(Double totalOSFinished) {
		this.totalOSFinished = totalOSFinished;
	}

	public Double getTotalOSCanceled() {
		return totalOSCanceled;
	}

	public void setTotalOSCanceled(Double totalOSCanceled) {
		this.totalOSCanceled = totalOSCanceled;
	}

	public Long getQuantityLabor() {
		return quantityLabor;
	}

	public void setQuantityLabor(Long quantityLabor) {
		this.quantityLabor = quantityLabor;
	}

	public Long getQuantityLaborActive() {
		return quantityLaborActive;
	}

	public void setQuantityLaborActive(Long quantityLaborActive) {
		this.quantityLaborActive = quantityLaborActive;
	}

	public Long getQuantityLaborInactive() {
		return quantityLaborInactive;
	}

	public void setQuantityLaborInactive(Long quantityLaborInactive) {
		this.quantityLaborInactive = quantityLaborInactive;
	}

	public Long getQuantityPart() {
		return quantityPart;
	}

	public void setQuantityPart(Long quantityPart) {
		this.quantityPart = quantityPart;
	}

	public Long getQuantityPartActive() {
		return quantityPartActive;
	}

	public void setQuantityPartActive(Long quantityPartActive) {
		this.quantityPartActive = quantityPartActive;
	}

	public Long getQuantityPartInactive() {
		return quantityPartInactive;
	}

	public void setQuantityPartInactive(Long quantityPartInactive) {
		this.quantityPartInactive = quantityPartInactive;
	}

	public Long getQuantityVehicle() {
		return quantityVehicle;
	}

	public void setQuantityVehicle(Long quantityVehicle) {
		this.quantityVehicle = quantityVehicle;
	}

	public Long getQuantityVehicleActive() {
		return quantityVehicleActive;
	}

	public void setQuantityVehicleActive(Long quantityVehicleActive) {
		this.quantityVehicleActive = quantityVehicleActive;
	}

	public Long getQuantityVehicleInactive() {
		return quantityVehicleInactive;
	}

	public void setQuantityVehicleInactive(Long quantityVehicleInactive) {
		this.quantityVehicleInactive = quantityVehicleInactive;
	}

	public Long getQuantityUser() {
		return quantityUser;
	}

	public void setQuantityUser(Long quantityUser) {
		this.quantityUser = quantityUser;
	}

	public Long getQuantityUserActive() {
		return quantityUserActive;
	}

	public void setQuantityUserActive(Long quantityUserActive) {
		this.quantityUserActive = quantityUserActive;
	}

	public Long getQuantityUserInactive() {
		return quantityUserInactive;
	}

	public void setQuantityUserInactive(Long quantityUserInactive) {
		this.quantityUserInactive = quantityUserInactive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((quantityLabor == null) ? 0 : quantityLabor.hashCode());
		result = prime * result + ((quantityLaborActive == null) ? 0 : quantityLaborActive.hashCode());
		result = prime * result + ((quantityLaborInactive == null) ? 0 : quantityLaborInactive.hashCode());
		result = prime * result + ((quantityOS == null) ? 0 : quantityOS.hashCode());
		result = prime * result + ((quantityOSCanceled == null) ? 0 : quantityOSCanceled.hashCode());
		result = prime * result + ((quantityOSFinished == null) ? 0 : quantityOSFinished.hashCode());
		result = prime * result + ((quantityOSInProgress == null) ? 0 : quantityOSInProgress.hashCode());
		result = prime * result + ((quantityPart == null) ? 0 : quantityPart.hashCode());
		result = prime * result + ((quantityPartActive == null) ? 0 : quantityPartActive.hashCode());
		result = prime * result + ((quantityPartInactive == null) ? 0 : quantityPartInactive.hashCode());
		result = prime * result + ((quantityUser == null) ? 0 : quantityUser.hashCode());
		result = prime * result + ((quantityUserActive == null) ? 0 : quantityUserActive.hashCode());
		result = prime * result + ((quantityUserInactive == null) ? 0 : quantityUserInactive.hashCode());
		result = prime * result + ((quantityVehicle == null) ? 0 : quantityVehicle.hashCode());
		result = prime * result + ((quantityVehicleActive == null) ? 0 : quantityVehicleActive.hashCode());
		result = prime * result + ((quantityVehicleInactive == null) ? 0 : quantityVehicleInactive.hashCode());
		result = prime * result + ((totalOS == null) ? 0 : totalOS.hashCode());
		result = prime * result + ((totalOSCanceled == null) ? 0 : totalOSCanceled.hashCode());
		result = prime * result + ((totalOSFinished == null) ? 0 : totalOSFinished.hashCode());
		result = prime * result + ((totalOSInProgress == null) ? 0 : totalOSInProgress.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dashboard other = (Dashboard) obj;
		if (quantityLabor == null) {
			if (other.quantityLabor != null)
				return false;
		} else if (!quantityLabor.equals(other.quantityLabor))
			return false;
		if (quantityLaborActive == null) {
			if (other.quantityLaborActive != null)
				return false;
		} else if (!quantityLaborActive.equals(other.quantityLaborActive))
			return false;
		if (quantityLaborInactive == null) {
			if (other.quantityLaborInactive != null)
				return false;
		} else if (!quantityLaborInactive.equals(other.quantityLaborInactive))
			return false;
		if (quantityOS == null) {
			if (other.quantityOS != null)
				return false;
		} else if (!quantityOS.equals(other.quantityOS))
			return false;
		if (quantityOSCanceled == null) {
			if (other.quantityOSCanceled != null)
				return false;
		} else if (!quantityOSCanceled.equals(other.quantityOSCanceled))
			return false;
		if (quantityOSFinished == null) {
			if (other.quantityOSFinished != null)
				return false;
		} else if (!quantityOSFinished.equals(other.quantityOSFinished))
			return false;
		if (quantityOSInProgress == null) {
			if (other.quantityOSInProgress != null)
				return false;
		} else if (!quantityOSInProgress.equals(other.quantityOSInProgress))
			return false;
		if (quantityPart == null) {
			if (other.quantityPart != null)
				return false;
		} else if (!quantityPart.equals(other.quantityPart))
			return false;
		if (quantityPartActive == null) {
			if (other.quantityPartActive != null)
				return false;
		} else if (!quantityPartActive.equals(other.quantityPartActive))
			return false;
		if (quantityPartInactive == null) {
			if (other.quantityPartInactive != null)
				return false;
		} else if (!quantityPartInactive.equals(other.quantityPartInactive))
			return false;
		if (quantityUser == null) {
			if (other.quantityUser != null)
				return false;
		} else if (!quantityUser.equals(other.quantityUser))
			return false;
		if (quantityUserActive == null) {
			if (other.quantityUserActive != null)
				return false;
		} else if (!quantityUserActive.equals(other.quantityUserActive))
			return false;
		if (quantityUserInactive == null) {
			if (other.quantityUserInactive != null)
				return false;
		} else if (!quantityUserInactive.equals(other.quantityUserInactive))
			return false;
		if (quantityVehicle == null) {
			if (other.quantityVehicle != null)
				return false;
		} else if (!quantityVehicle.equals(other.quantityVehicle))
			return false;
		if (quantityVehicleActive == null) {
			if (other.quantityVehicleActive != null)
				return false;
		} else if (!quantityVehicleActive.equals(other.quantityVehicleActive))
			return false;
		if (quantityVehicleInactive == null) {
			if (other.quantityVehicleInactive != null)
				return false;
		} else if (!quantityVehicleInactive.equals(other.quantityVehicleInactive))
			return false;
		if (totalOS == null) {
			if (other.totalOS != null)
				return false;
		} else if (!totalOS.equals(other.totalOS))
			return false;
		if (totalOSCanceled == null) {
			if (other.totalOSCanceled != null)
				return false;
		} else if (!totalOSCanceled.equals(other.totalOSCanceled))
			return false;
		if (totalOSFinished == null) {
			if (other.totalOSFinished != null)
				return false;
		} else if (!totalOSFinished.equals(other.totalOSFinished))
			return false;
		if (totalOSInProgress == null) {
			if (other.totalOSInProgress != null)
				return false;
		} else if (!totalOSInProgress.equals(other.totalOSInProgress))
			return false;
		return true;
	}

}
