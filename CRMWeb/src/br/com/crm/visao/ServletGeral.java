package br.com.crm.visao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crm.entidades.pessoas.Usuario;
import br.com.crm.negocio.UsuarioBO;
import br.com.crm.negocio.excecoes.ExcecaoNegocio;
import br.com.crm.util.IConstantes;
import br.com.curso.seguranca.validacao.ServicoValidacao;
import br.com.curso.seguranca.validacao.ServicoValidacaoProxy;

/**
 * Servlet que trata as requisições da tela de usuário
 */
@WebServlet("/ServletGeral")
public class ServletGeral extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Método que trata os dados de requisiçao via get
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * Método que trata os dados de uma requisiçao vista post
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nomeFuncionalidade = request.getParameter("nomeFuncionalidade");
		String nomeFuncao = request.getParameter("nomeFuncao");

		UsuarioBO usuarioBo = new UsuarioBO();
		String mensagem = null;

		if (nomeFuncionalidade.equals(IConstantes.NOME_FUNCIONALIDADE_USUARIO)) {

			RequestDispatcher rd = request
					.getRequestDispatcher("pages/TelaUsuario.jsp");

			if (nomeFuncao.equals(IConstantes.NOME_FUNCAO_GRAVAR)) {
				mensagem = cadastrarUsuario(request, response, usuarioBo, rd);
			}

			if (nomeFuncao.equals(IConstantes.NOME_FUNCAO_LISTAR)) {
				mensagem = listarUsuarios(request, response, usuarioBo, mensagem, rd);
			}

			if (nomeFuncao.equals(IConstantes.NOME_FUNCAO_EXCLUIR)) {
				mensagem = excluirUsuario(request, response, usuarioBo, mensagem, rd);
			}

			if (nomeFuncao.equals(IConstantes.NOME_FUNCAO_ALTERAR)) {
				buscarUsuario(request, response, usuarioBo, mensagem);
			}

			if (nomeFuncao.equals(IConstantes.NOME_FUNCAO_GRAVAR_ALTERACAO)) {
				editarUsuario(request, response, usuarioBo);
			}
		}

	}

	/**
	 * Método que cadastra um novo usuário
	 * 
	 * @param request
	 * @param response
	 * @param usuarioBo
	 * @param rd
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	private String cadastrarUsuario(HttpServletRequest request,
			HttpServletResponse response, UsuarioBO usuarioBo,
			RequestDispatcher rd) throws ServletException, IOException {
		String mensagem = null;
		Usuario usuario = new Usuario();
		usuario.setNome(request.getParameter("nome"));
		usuario.setEndereco(request.getParameter("endereco"));
		usuario.setCpf(request.getParameter("cpf"));
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setConfirmaSenha(request.getParameter("confirmaSenha"));

		if (request.getParameter("ativo") == null) {
			usuario.setAtivo(false);
		} else {
			usuario.setAtivo(true);
		}
		
		try {

			try{
				ServicoValidacao servico = new ServicoValidacaoProxy();
				if (!servico.validarSenha(usuario.getSenha())){
					throw new ExcecaoNegocio("Seguranca baixa na senha");
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}

			usuarioBo.incluir(usuario);
			mensagem = "Usuario gravado com sucesso!";
		} catch (ExcecaoNegocio e) {
			mensagem = e.getMessage();
		} finally {
			request.setAttribute("msg", mensagem);
			rd.forward(request, response);
		}
		return mensagem;
	}

	/**
	 * Método que busca todos os usuários cadastrados
	 * 
	 * @param request
	 * @param response
	 * @param usuarioBo
	 * @param mensagem
	 * @param rd
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	private String listarUsuarios(HttpServletRequest request,
			HttpServletResponse response, UsuarioBO usuarioBo, String mensagem,
			RequestDispatcher rd) throws ServletException, IOException {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		try {
			listaUsuarios = usuarioBo.listar();
			request.setAttribute("listaUsuarios", listaUsuarios);
		} catch (ExcecaoNegocio e) {
			mensagem = "Ocorreu o seguinte erro: " + e.getMessage();
		} finally {
			request.setAttribute("msg", mensagem);
			rd.forward(request, response);
		}
		return mensagem;
	}

	/**
	 * Método que exclui um usuário
	 * 
	 * @param request
	 * @param response
	 * @param usuarioBo
	 * @param mensagem
	 * @param rd
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	private String excluirUsuario(HttpServletRequest request,
			HttpServletResponse response, UsuarioBO usuarioBo, String mensagem,
			RequestDispatcher rd) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();

		usuario.setId(Integer.parseInt(request.getParameter("id")));

		try {
			usuarioBo.excluir(usuario);
			listaUsuarios = usuarioBo.listar();
			request.setAttribute("listaUsuarios", listaUsuarios);
			
		} catch (ExcecaoNegocio e) {
			mensagem = e.getMessage();
		} finally {
			request.setAttribute("msg", mensagem);
			rd.forward(request, response);
		}
		return mensagem;
	}

	/**
	 * Método que edita os dados do usuário
	 * 
	 * @param request
	 * @param response
	 * @param usuarioBo
	 * @throws ServletException
	 * @throws IOException
	 */
	private void editarUsuario(HttpServletRequest request,
			HttpServletResponse response, UsuarioBO usuarioBo)
			throws ServletException, IOException {
		String mensagem = null;
		Usuario usuario = new Usuario();
		usuario.setId(Integer.parseInt(request.getParameter("id")));
		usuario.setNome(request.getParameter("nome"));
		usuario.setEndereco(request.getParameter("endereco"));
		usuario.setCpf(request.getParameter("cpf"));
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setConfirmaSenha(request.getParameter("confirmaSenha"));

		if (request.getParameter("ativo") == null) {
			usuario.setAtivo(false);
		} else {
			usuario.setAtivo(true);
		}

		RequestDispatcher rdGravaAlt = null;
		try {
			try{
				ServicoValidacao servico = new ServicoValidacaoProxy();
				if (!servico.validarSenha(usuario.getSenha())){
					throw new ExcecaoNegocio("Seguranca baixa na senha");
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}

			usuarioBo.alterar(usuario);
			List<Usuario> listaUsuarios = new ArrayList<Usuario>();
			listaUsuarios = usuarioBo.listar();
			request.setAttribute("listaUsuarios", listaUsuarios);

			rdGravaAlt = request.getRequestDispatcher("pages/TelaUsuario.jsp");
			mensagem = "Usuario alterado com sucesso";

		} catch (ExcecaoNegocio e) {			
			rdGravaAlt = request.getRequestDispatcher("pages/TelaUsuarioAlterar.jsp");
			mensagem = e.getMessage();
		} finally {
			request.setAttribute("msg", mensagem);
			request.setAttribute("id", usuario.getId());
			request.setAttribute("nome", usuario.getNome());
			request.setAttribute("endereco", usuario.getEndereco());
			request.setAttribute("cpf", usuario.getCpf());
			request.setAttribute("login", usuario.getLogin());
			request.setAttribute("senha", null);						
			rdGravaAlt.forward(request, response);			
		}
	}

	/**
	 * Método que busca o usuario pelo seu id
	 * 
	 * @param request
	 * @param response
	 * @param usuarioBo
	 * @param mensagem
	 * @throws ServletException
	 * @throws IOException
	 */
	private void buscarUsuario(HttpServletRequest request,
			HttpServletResponse response, UsuarioBO usuarioBo, String mensagem)
			throws ServletException, IOException {

		Usuario usuario = new Usuario();
		usuario.setId(Integer.parseInt(request.getParameter("id")));
		RequestDispatcher rdAlt = request.getRequestDispatcher("pages/TelaUsuarioAlterar.jsp");

		try {
			Usuario usuarioEncontrado = usuarioBo.recuperar(usuario);

			request.setAttribute("id", usuarioEncontrado.getId());
			request.setAttribute("nome", usuarioEncontrado.getNome());
			request.setAttribute("endereco", usuarioEncontrado.getEndereco());
			request.setAttribute("cpf", usuarioEncontrado.getCpf());
			request.setAttribute("login", usuarioEncontrado.getLogin());
			request.setAttribute("senha", usuarioEncontrado.getSenha());

		} catch (ExcecaoNegocio e) {
			mensagem = e.getMessage();
		} finally {
			request.setAttribute("msg", mensagem);
			rdAlt.forward(request, response);
		}
	}
}
