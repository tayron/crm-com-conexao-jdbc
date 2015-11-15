package br.com.crm.visao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet que trata as requisi��es da tela principal do sistema
 */
@WebServlet("/ServletTelaPrincipal")
public class ServletTelaPrincipal extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * M�todo que trata os dados de uma requisi�ao vista get
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getParameter("cmd"));
	}

	/**
	 * M�todo que trata os dados de uma requisi�ao vista post
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
