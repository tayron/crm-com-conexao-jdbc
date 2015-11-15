package br.com.crm.modelo;

import java.util.List;

import br.com.crm.entidades.pessoas.Pessoa;
import br.com.crm.modelo.excecoes.ExcecaoModelo;

/**
 * Interface DAO que define as opera��es b�sicas a serem implementadas 
 */
public interface IBaseDAO<T extends Pessoa> {

	/**
	 * M�todo que inclui um novo registro no banco dedados
	 * 
	 * @param t
	 * @throws ExcecaoModelo
	 */
	public void incluir(T entidade) throws ExcecaoModelo;
	
	/**
	 * M�todo que atualiza um determinado registro no banco de dados 
	 * 
	 * @param t
	 * @throws ExcecaoModelo
	 */
	public void alterar(T entidade) throws ExcecaoModelo;
	
	/**
	 * M�todo que remove um determinado registro no banco de dados
	 * 
	 * @param t
	 * @throws ExcecaoModelo
	 */
	public void excluir(T entidade) throws ExcecaoModelo;
	
	/**
	 * M�todo que busca v�rios registros no banco de dados
	 * 
	 * @param t
	 * @return
	 * @throws ExcecaoModelo
	 */
	public List<T> listar() throws ExcecaoModelo;
	
	/**
	 * M�todo que busca um registro no banco de dados
	 * 
	 * @param t
	 * @return
	 * @throws ExcecaoModelo
	 */
	public T recuperar(T entidade) throws ExcecaoModelo;
}
