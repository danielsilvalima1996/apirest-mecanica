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
	public static final String BUSCAR_VEICULO_POR_ID = "/buscar-veiculo/{id}";
	public static final String ATUALIZAR_VEICULO = "/atualizar-veiculo/{id}";
	public static final String BUSCAR_VEICULOS_ATIVOS = "/buscar-veiculos-ativos";
	public static final String BUSCAR_POR_FILTROS = "/buscar-por-filtros";
	
	public static final boolean VEICULO_ATIVO = true;
	public static final boolean VEICULO_INATIVO = false;
	
	/*
	 * Atributos de Peças
	 */
	public static final String CADASTRAR_PECA = "/cadastrar-peca";
	public static final String ATUALIZAR_PECA = "/atualizar-peca/{id}";
	public static final String LISTAR_PECAS = "/listar-pecas";
	public static final String LISTAR_PECAS_ATIVAS = "/listar-pecas-ativas";
	public static final String BUSCAR_PECA_POR_ID = "/buscar-peca/{id}";

	public static final boolean PECA_ATIVA = true;
	public static final boolean PECA_INATIVA = false;

}
