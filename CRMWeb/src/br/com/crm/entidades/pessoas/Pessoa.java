package br.com.crm.entidades.pessoas;

/**
 * Entity Bean para representa��o de uma pessoa
 */
public class Pessoa extends EntidadeAbstrata {
	
	/**
	 * Armazena o nome da pessoa
	 */
	private String nome;
	
	/**
	 * Armaneza o cpf da pessoa
	 */
	private String cpf;
	
	/**
	 * Armazena o endere�o da pessoa
	 */
	private String endereco;
	
	/**
	 * Armazena o status da pessoa, se ela est� ativa ou n�o.
	 */
	private Boolean ativo;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the ativo
	 */
	public Boolean getAtivo() {
		return ativo;
	}

	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
