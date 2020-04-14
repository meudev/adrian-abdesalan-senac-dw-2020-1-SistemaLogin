package br.com.aula.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import br.com.aula.Model.LoginModel;


public class LoginDAO {
	
	// Variavel de Conexão
		private Connection con;

		// Método Construtor Conexão
		public LoginDAO(Connection con) {
			this.con = con;
		}
	
	// Método Cadastrar
		public void adicionarLogin(LoginModel login) {

			try {

				// 1 Passo - Criar o comando SQL
				String sql = "insert into tb_login(usuario,senha)" + "values(?,?)";

				// 2-Passo - Conectar o BD e organizar o camando SQL
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, login.getUsuario());
				stmt.setString(2, login.getSenha());

				// 3Passo - Executar e fechar o Comando SQL
				stmt.execute();
				stmt.close();

			} catch (SQLException erro) {
				System.out.println("Erro: " + erro);
			}
		}
		
		

}