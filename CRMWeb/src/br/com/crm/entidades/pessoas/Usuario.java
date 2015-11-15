package br.com.crm.entidades.pessoas;

/**
 * Entity Bean para representação de um usuário
 */
public class Usuario extends Pessoa{
	
	/**
	 * Armazena o login do usuário 
	 */
	private String login;
	
	/**
	 * Armazena a senha do usuário
	 */
	private String senha;
	
	/**
	 * Armazena a senha de confirmação do usuário
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
