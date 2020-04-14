package br.com.aula.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aula.DAO.LoginDAO;
import br.com.aula.Model.LoginModel;
import br.com.aula.conexao.CriarConexao;

@WebServlet("/CadastroLogin")
public class CadastroLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);
	}
	
	private void validaDadosRecebidos(HttpServletRequest req) throws ServletException {
		
		String usuario = req.getParameter("txtusuario");
		String senha = req.getParameter("txtsenha");

		if (usuario.trim().equals("") || senha.trim().equals("")) {

			throw new ServletException("Preencha os campos.");

		} else {
			Connection con;
			try {
				con = CriarConexao.getConexao();
				
				LoginModel login = new LoginModel();
				login.setUsuario(usuario);
				login.setSenha(senha);
				
				LoginDAO dao = new LoginDAO(con);
				dao.adicionarLogin(login);
			} catch (SQLException e) {
				System.out.println("Erro: " + e);
			}
		}
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			validaDadosRecebidos(req);
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		
	}

}
