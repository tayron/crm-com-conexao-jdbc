/**
 * 
 */
package br.com.crm.entidades.pessoas;

/**
 * Entity Bean para representação de uma entidade abstrata
 */
public abstract class EntidadeAbstrata {
	
	/**
	 * Armazena o código de indentifição
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
