package br.com.curso.seguranca.validacao;

import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;
import br.com.crm.negocio.excecoes.ExcecaoNegocio;

/**
 * 
 * @author tayron
 *
 */
public class ServicoValidacaoProxy implements
		br.com.curso.seguranca.validacao.ServicoValidacao {
	/**
	 * 
	 */
	private String _endpoint = null;
	/**
   * 
   */
	private br.com.curso.seguranca.validacao.ServicoValidacao servicoValidacao = null;

	/**
   * 
   */
	public ServicoValidacaoProxy() {
		_initServicoValidacaoProxy();
	}

	/**
	 * 
	 * @param endpoint
	 */
	public ServicoValidacaoProxy(String endpoint) {
		_endpoint = endpoint;
		_initServicoValidacaoProxy();
	}

	/**
   * 
   */
	private void _initServicoValidacaoProxy() {
		try {
			servicoValidacao = (new ServicoValidacaoServiceLocator())
					.getServicoValidacao();
			if (servicoValidacao != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) servicoValidacao)
							._setProperty(
									"javax.xml.rpc.service.endpoint.address",
									_endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) servicoValidacao)
							._getProperty("javax.xml.rpc.service.endpoint.address");
			}

		} catch (ServiceException serviceException) {
		}
	}

	/**
	 * 
	 * @return
	 */
	public String getEndpoint() {
		return _endpoint;
	}

	/**
	 * 
	 * @param endpoint
	 */
	public void setEndpoint(String endpoint) {
		_endpoint = endpoint;
		if (servicoValidacao != null)
			((javax.xml.rpc.Stub) servicoValidacao)._setProperty(
					"javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	/**
	 * 
	 * @return
	 */
	public ServicoValidacao getServicoValidacao() {
		if (servicoValidacao == null)
			_initServicoValidacaoProxy();
		return servicoValidacao;
	}

	/**
   * 
   */
	public boolean validarSenha(java.lang.String senha) throws RemoteException,
			ExcecaoNegocio {
		if (servicoValidacao == null)
			_initServicoValidacaoProxy();
		return servicoValidacao.validarSenha(senha);
	}
}