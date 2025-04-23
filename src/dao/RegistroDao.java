package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RegistroDao {

	public Connection getConexao() {

		// Driver
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// URL do banco de dados
		String url = "jdbc:mysql://localhost:3306/dbinformatica";

		// login
		String login = "root";

		// Senha
		String senha = "Marielapb1@";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, login, senha);
			System.out.println("Conectado ao banco de dados");

		} catch (SQLException e) {
			System.err.println("Credenciais inválidas. Erro ao conectar");
		}

		return conn;
	}
	
	

}
