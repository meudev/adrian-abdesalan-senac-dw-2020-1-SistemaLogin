package br.com.aula.conexao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.aula.DAO.LoginDAO;
import br.com.aula.Model.LoginModel;

public class TestaConexao {
	
	
    
  //Testar Método Cadastrar
  	
  	public static void main(String[] args) {
  		
  		Connection con;

		try {

			con = CriarConexao.getConexao();

			LoginModel login = new LoginModel();
			login.setUsuario("usuario teste");
			login.setSenha("123");

			LoginDAO dao = new LoginDAO(con);
			dao.adicionarLogin(login);
			
			System.out.println("Cadastrado com sucesso");


		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
  	
  	}
  	
}