package br.com.aula.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class SistemaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		processRequest(request, response);

	}

	private void validaDadosRecebidos(HttpServletRequest req) throws ServletException {

		String nomeUsuario = req.getParameter("txtusuario");
		String nomeSenha = req.getParameter("txtsenha");

		if (nomeUsuario.trim().equals("") || nomeSenha.trim().equals(""))

			throw new ServletException("Preencha todos os campos");

		if (!nomeUsuario.trim().equals("aluno") || !nomeSenha.trim().equals("123"))

			throw new ServletException("Dados Incorretos");

	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			validaDadosRecebidos(req);
			RequestDispatcher rd = req.getRequestDispatcher("logado.jsp");
			rd.forward(req, resp);
			
		} catch (Exception e) {
			RequestDispatcher rd = req.getRequestDispatcher("errodeusuario.jsp");
			rd.forward(req, resp);
		}
		
	}
}
