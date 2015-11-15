/**
 * 
 */
package br.com.crm.entidades.pessoas;

/**
 * Entity Bean para representa��o de uma entidade abstrata
 */
public abstract class EntidadeAbstrata {
	
	/**
	 * Armazena o c�digo de indentifi��o
	 */
	private Integer id;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}	
}
