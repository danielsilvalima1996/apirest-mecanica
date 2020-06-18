package com.api.mecanica.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode
@ToString
@Entity
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "A marca do veiculo deve ser preenchida")
	@NotNull
	private String marca;
	
	@NotBlank(message = "O modelo do veiculo deve ser preenchido")
	@NotNull
	private String modelo;
	
	@NotBlank(message = "O ano do veiculo deve ser preenchido")
	@NotNull
	private Integer ano;
	
	@NotBlank(message = "O tipo de combustivel do veiculo deve ser preenchido")
	@NotNull
	private String tipoCombustivel;

}
