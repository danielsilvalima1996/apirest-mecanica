package com.api.mecanica.constants;

/**
 * @author [cristian.baptistella]
 * @since 2020-06-18
 */
public interface AppConstants {

	/*
	 * Atributos de veículos
	 */
	public static final String CADASTRAR_VEICULO = "/cadastrar-veiculo";
	public static final String LISTAR_VEICULOS = "/listar-veiculos";
	public static final String BUSCAR_VEICULO = "/buscar-veiculo/{id}";
	public static final String ATUALIZAR_VEICULO = "/atualizar-veiculo/{id}";
	public static final String BUSCAR_POR_MARCA_VEIC = "/buscar-por-marca/{marca}";
	public static final String BUSCAR_POR_MODELO_VEIC = "/buscar-por-marca/{modelo}";
	public static final String BUSCAR_POR_ANO_VEIC = "/buscar-por-marca/{ano}";
	public static final String BUSCAR_POR_FILTROS = "/buscar-por-filtros";

	
	
	public static final boolean VEICULO_ATIVO = true;
	public static final boolean VEICULO_INATIVO = false;
	


}
