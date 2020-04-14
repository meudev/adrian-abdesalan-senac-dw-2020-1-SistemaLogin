package br.com.aula.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import br.com.aula.Model.LoginModel;


public class LoginDAO {
	
		private Connection con;

		public LoginDAO(Connection con) {
			this.con = con;
		}
	
		public void adicionarLogin(LoginModel login) {

			try {

				String sql = "insert into tb_login(usuario,senha)" + "values(?,?)";

				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, login.getUsuario());
				stmt.setString(2, login.getSenha());

				stmt.execute();
				stmt.close();

			} catch (SQLException erro) {
				System.out.println("Erro: " + erro);
			}
		}
		
		

}