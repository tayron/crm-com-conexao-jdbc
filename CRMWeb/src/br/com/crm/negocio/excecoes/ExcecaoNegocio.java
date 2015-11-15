package br.com.crm.negocio.excecoes;

/**
 * Classe de exceção para a camada de negócio.
 */
public class ExcecaoNegocio extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param mensagem
	 */
	public ExcecaoNegocio(String mensagem){
		super(mensagem);
	}
}
