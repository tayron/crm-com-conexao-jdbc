package br.com.crm.modelo;

import br.com.crm.modelo.excecoes.ExcecaoModelo;

/**
 * Interface DAO que define as opera��es b�sicas a serem implementadas pelo UsuarioDAO
 */
public interface IUsuarioDAO {
	
	/**
	 * M�todo que pesquisa por um usu�rio atrav�s de seu login e senha
	 * 
	 * @param login
	 * @param senha
	 * @return
	 * @throws ExcecaoModelo
	 */
	public Boolean consultar(String login, String senha)throws ExcecaoModelo;
}
