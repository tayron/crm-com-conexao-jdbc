package br.com.crm.negocio.excecoes;

/**
 * Classe de exce��o para a camada de neg�cio.
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
