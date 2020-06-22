package com.api.mecanica.exception;

public class MaoDeObraException extends BaseException {

	private static final long serialVersionUID = -2813140368676055083L;

	public MaoDeObraException(int errorCode, String errorMessage) {
		super();
		super.setErrorCode(errorCode);
		super.setErrorMessage(errorMessage);
	}
}

