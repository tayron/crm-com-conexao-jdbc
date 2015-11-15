package br.com.crm.visao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crm.negocio.UsuarioBO;
import br.com.crm.negocio.excecoes.ExcecaoNegocio;

/**
 * Servlet que trata as requisi��es da tela de login do usu�rio
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * M�todo que trata os dados de requisi�ao via get
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * M�todo que trata os dados de uma requisi�ao vista post
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		UsuarioBO usuarioBo = new UsuarioBO();

		try {
			if (usuarioBo.consultar(login, senha)) {
				getServletContext().setAttribute("usuarioLogado", login);
				request.getSession().setAttribute("usuario", login);

				RequestDispatcher rd = request
						.getRequestDispatcher("/pages/TelaPrincipal.jsp");
				rd.forward(request, response);
			}
		} catch (ExcecaoNegocio e) {
			PrintWriter mensagem = response.getWriter();
			mensagem.write("<html> <body>");
			mensagem.write("<h1> Falha no login: " + e.getMessage());
			mensagem.write("</h1></body></html>");
		}
	}

}
