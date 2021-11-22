package com.api.mecanica.model.dto;

import java.io.Serializable;

public class JwtResponseDTO implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;

	private final String token;

	public JwtResponseDTO(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

}
