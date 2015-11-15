package br.com.crm.negocio;

import br.com.crm.negocio.excecoes.ExcecaoNegocio;

/**
 * Interface DAO que define as operações básicas a serem implementadas pela classe UsuarioBO 
 */
public interface IUsuarioBO {
	
	/**
	 * Métood que consulta um usuário no banco pelo seu login e senha
	 * 
	 * @param login
	 * @param senha
	 * @return
	 * @throws ExcecaoNegocio
	 */
	public Boolean consultar(String login, String senha) throws ExcecaoNegocio;
	
}