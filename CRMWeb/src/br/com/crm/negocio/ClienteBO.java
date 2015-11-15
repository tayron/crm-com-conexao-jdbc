package br.com.crm.negocio;

import java.util.List;

import br.com.crm.entidades.pessoas.Cliente;
import br.com.crm.negocio.excecoes.ExcecaoNegocio;

/**
 * Serviço que gerencia os dados do cliente
 */
public class ClienteBO extends BaseBO<Cliente>{

	/**
	 * {@link BaseBO#incluir(Cliente)}
	 */
	@Override
	public void incluir(Cliente cliente) throws ExcecaoNegocio {
		
	}

	/**
	 * {@link BaseBO#alterar(Cliente)}
	 */
	@Override
	public void alterar(Cliente cliente) throws ExcecaoNegocio {
		
	}

	/**
	 * {@link BaseBO#excluir(Cliente)}
	 */
	@Override
	public void excluir(Cliente cliente) throws ExcecaoNegocio {
		
	}

	/**
	 * {@link BaseBO#listar(Cliente)}
	 */
	@Override
	public List<Cliente> listar() throws ExcecaoNegocio {
		return null;
	}

	/**
	 *{@link BaseBO#recuperar(Cliente)} 
	 */
	@Override
	public Cliente recuperar(Cliente cliente) throws ExcecaoNegocio {
		return null;
	}
}
