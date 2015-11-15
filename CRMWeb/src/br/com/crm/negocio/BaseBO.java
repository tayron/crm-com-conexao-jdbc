package br.com.crm.negocio;

import java.util.List;

import br.com.crm.entidades.pessoas.Pessoa;
import br.com.crm.negocio.excecoes.ExcecaoNegocio;

/**
 * Classe abstrata que define os métodos a serem implementados 
 * pelas classes de negócio que extende de Pessoa.
 */
public abstract class BaseBO<T extends Pessoa> {

	/**
	 * Método que insere um registor no banco de dados
	 * 
	 * @param t
	 * @throws ExcecaoNegocio
	 */
	public abstract void incluir(T t) throws ExcecaoNegocio;
	
	/**
	 * Método que altera um registro no banco de dados
	 * 
	 * @param t
	 * @throws ExcecaoNegocio
	 */
	public abstract void alterar(T t) throws ExcecaoNegocio;
	
	/**
	 * Método que remove um registro do banco de dados
	 * 
	 * @param t
	 * @throws ExcecaoNegocio
	 */
	public abstract void excluir(T t) throws ExcecaoNegocio;
	
	/**
	 * Método que lista todos os registros do banco de dados
	 * 
	 * @param t
	 * @return
	 * @throws ExcecaoNegocio
	 */
	public abstract List<T> listar() throws ExcecaoNegocio;
	
	/**
	 * Métodoque busca recupera uma entidade no banco de dados através do seu id
	 * 
	 * @param t
	 * @return
	 * @throws ExcecaoNegocio
	 */
	public abstract T recuperar(T t) throws ExcecaoNegocio; 
	
	/**
	 * Método que valida se o nome, endereço e cfp estão presentes
	 * 
	 * @param t
	 * @throws ExcecaoNegocio
	 */
	public void validarCamposObrigatorios(T t) throws ExcecaoNegocio{
		if(t.getNome().isEmpty() || 
			t.getEndereco().isEmpty() || 
			t.getCpf().isEmpty()){
			throw new ExcecaoNegocio("Campos obrigatórios não foram preenchidos");
		}
	}
	
}
