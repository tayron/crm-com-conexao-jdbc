package br.com.crm.visao.excecoes;

import br.com.crm.util.IConstantes;

public class ExcecaoVisao extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcecaoVisao(String msg) {
		super(IConstantes.MSG_EXCECAO_VISAO+msg);
	}
}
