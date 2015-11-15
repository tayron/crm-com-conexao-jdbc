package br.com.crm.entidades.pessoas;

/**
 * Entity Bean para representação de um cliente
 */
public class Cliente extends Pessoa{

	/**
	 * Armazena o telefone de contato
	 */
	private String telefone;
	
	/**
	 * Armazena um nome para contato
	 */
	private String contato;

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the contato
	 */
	public String getContato() {
		return contato;
	}

	/**
	 * @param contato the contato to set
	 */
	public void setContato(String contato) {
		this.contato = contato;
	}	
}
