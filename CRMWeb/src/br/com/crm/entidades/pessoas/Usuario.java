package br.com.crm.entidades.pessoas;

/**
 * Entity Bean para representa��o de um usu�rio
 */
public class Usuario extends Pessoa{
	
	/**
	 * Armazena o login do usu�rio 
	 */
	private String login;
	
	/**
	 * Armazena a senha do usu�rio
	 */
	private String senha;
	
	/**
	 * Armazena a senha de confirma��o do usu�rio
	 */
	private String confirmaSenha;

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the confirmaSenha
	 */
	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	/**
	 * @param confirmaSenha the confirmaSenha to set
	 */
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}	
}
