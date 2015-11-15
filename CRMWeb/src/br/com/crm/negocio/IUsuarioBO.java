package br.com.crm.negocio;

import br.com.crm.negocio.excecoes.ExcecaoNegocio;

/**
 * Interface DAO que define as opera��es b�sicas a serem implementadas pela classe UsuarioBO 
 */
public interface IUsuarioBO {
	
	/**
	 * M�tood que consulta um usu�rio no banco pelo seu login e senha
	 * 
	 * @param login
	 * @param senha
	 * @return
	 * @throws ExcecaoNegocio
	 */
	public Boolean consultar(String login, String senha) throws ExcecaoNegocio;
	
}