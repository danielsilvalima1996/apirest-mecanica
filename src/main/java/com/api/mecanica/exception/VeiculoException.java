package com.api.mecanica.exception;

public class VeiculoException extends BaseException {

	private static final long serialVersionUID = -4477402004033172786L;

	public VeiculoException(int errorCode, String errorMessage) {
		super();
		super.setErrorCode(errorCode);
		super.setErrorMessage(errorMessage);
	}
}

