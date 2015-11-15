package br.com.crm.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.crm.entidades.pessoas.Usuario;
import br.com.crm.modelo.excecoes.ExcecaoModelo;
import br.com.crm.modelo.jdbc.UsuarioDAO;
import br.com.crm.negocio.excecoes.ExcecaoNegocio;

/**
 * Serviço que gerencia os dados do usuario
 */
public class UsuarioBO extends BaseBO<Usuario> implements IUsuarioBO{

	/**
	 * {@link BaseBO#incluir(Usuario)}
	 */
	@Override
	public void incluir(Usuario t) throws ExcecaoNegocio{
		UsuarioDAO usuarioDao = new UsuarioDAO();

		try {
			validarCamposObrigatorios(t);
			validarLogin(t);
			if (!t.getSenha().equals(t.getConfirmaSenha())) {
				throw new Exception("Confirmação de senha inválida");
			}

			usuarioDao.incluir(t);
		} catch (Exception e) {
			throw new ExcecaoNegocio(e.getMessage());
		}
	}

	/**
	 * {@link BaseBO#alterar(Usuario)}
	 */
	@Override
	public void alterar(Usuario t)  throws ExcecaoNegocio{
		UsuarioDAO usuarioDao = new UsuarioDAO();

		try {
			validarID(t);
			validarCamposObrigatorios(t);
			validarLogin(t);
			
			if (t.getConfirmaSenha() == null) {
				throw new Exception("O campo confirmação de senha deve ser preenchido");
			}
			
			if (!t.getSenha().equals(t.getConfirmaSenha())) {
				throw new Exception("Confirmação de senha inválida");
			}

			usuarioDao.alterar(t);
		} catch (Exception e) {
			throw new ExcecaoNegocio(e.getMessage());
		}
	}

	/**
	 * {@link BaseBO#excluir(Usuario)}
	 */
	@Override
	public void excluir(Usuario t)  throws ExcecaoNegocio{
		try {
			UsuarioDAO usuarioDao = new UsuarioDAO();
			validarID(t);
			
			usuarioDao.excluir(t);
		} catch (Exception e) {
			throw new ExcecaoNegocio(e.getMessage());
		}		
	}

	/**
	 * {@link BaseBO#listar()}
	 */
	@Override
	public List<Usuario> listar()  throws ExcecaoNegocio{
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		try {
			UsuarioDAO usuarioDao = new UsuarioDAO();
			listaUsuarios = usuarioDao.listar();
			
			if(listaUsuarios.size() == 0){
				throw new Exception("Nenhum registro encontrado");
			}
		} catch (Exception e) {
			throw new ExcecaoNegocio(e.getMessage());
		}

		return listaUsuarios;
	}
	
	/**
	 * {@link BaseBO#recuperar(Usuario)}
	 */
	@Override
	public Usuario recuperar(Usuario usuario) throws ExcecaoNegocio {
		Usuario usuarioEncontrado = null;
		try{
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioEncontrado = usuarioDAO.recuperar(usuario);
		}catch(ExcecaoModelo e ){
			throw new ExcecaoNegocio(e.getMessage());
		}
		
		return usuarioEncontrado;
	}		
	
	/**
	 * {@link IUsuarioBO#consultar(String, String)}
	 */
	@Override
	public Boolean consultar(String login, String senha) throws ExcecaoNegocio {
		try {
			UsuarioDAO usuarioDao = new UsuarioDAO();
			
			if (! usuarioDao.consultar(login, senha)){
				throw new Exception("Login e/ou senha invalido(s).");
			}
			
		} catch (Exception e) {
			throw new ExcecaoNegocio(e.getMessage());
		}

		return true;
	}	

	/**
	 * método que verifica se o campo login e senha foram preenchidos.
	 * 
	 * @param t
	 * @throws ExcecaoNegocio
	 */
	private void validarLogin(Usuario t) throws ExcecaoNegocio{
		if(t.getLogin().isEmpty()||
			t.getSenha().isEmpty()){ 
			throw new ExcecaoNegocio("Login e senha obrigatórios");
		}
	}

	/**
	 * Método verifica se o id do usuário foi informado
	 * @param t
	 * @throws Exception
	 */
	private void validarID(Usuario t) throws Exception{
		UsuarioDAO usuarioDao = new UsuarioDAO();
		if(t.getId() == null){
			throw new Exception("ID é obrigatório para operações de banco de dados");
		}

		try{
			usuarioDao.recuperar(t);
		}catch(ExcecaoModelo e ){
			throw new Exception("ID não encontrado para a operação de banco de dados solicitada");
		}
	}
}
