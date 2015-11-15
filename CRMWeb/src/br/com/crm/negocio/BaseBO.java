package br.com.crm.negocio;

import java.util.List;

import br.com.crm.entidades.pessoas.Pessoa;
import br.com.crm.negocio.excecoes.ExcecaoNegocio;

/**
 * Classe abstrata que define os m�todos a serem implementados 
 * pelas classes de neg�cio que extende de Pessoa.
 */
public abstract class BaseBO<T extends Pessoa> {

	/**
	 * M�todo que insere um registor no banco de dados
	 * 
	 * @param t
	 * @throws ExcecaoNegocio
	 */
	public abstract void incluir(T t) throws ExcecaoNegocio;
	
	/**
	 * M�todo que altera um registro no banco de dados
	 * 
	 * @param t
	 * @throws ExcecaoNegocio
	 */
	public abstract void alterar(T t) throws ExcecaoNegocio;
	
	/**
	 * M�todo que remove um registro do banco de dados
	 * 
	 * @param t
	 * @throws ExcecaoNegocio
	 */
	public abstract void excluir(T t) throws ExcecaoNegocio;
	
	/**
	 * M�todo que lista todos os registros do banco de dados
	 * 
	 * @param t
	 * @return
	 * @throws ExcecaoNegocio
	 */
	public abstract List<T> listar() throws ExcecaoNegocio;
	
	/**
	 * M�todoque busca recupera uma entidade no banco de dados atrav�s do seu id
	 * 
	 * @param t
	 * @return
	 * @throws ExcecaoNegocio
	 */
	public abstract T recuperar(T t) throws ExcecaoNegocio; 
	
	/**
	 * M�todo que valida se o nome, endere�o e cfp est�o presentes
	 * 
	 * @param t
	 * @throws ExcecaoNegocio
	 */
	public void validarCamposObrigatorios(T t) throws ExcecaoNegocio{
		if(t.getNome().isEmpty() || 
			t.getEndereco().isEmpty() || 
			t.getCpf().isEmpty()){
			throw new ExcecaoNegocio("Campos obrigat�rios n�o foram preenchidos");
		}
	}
	
}
