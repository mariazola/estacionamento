package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidades.Clientes;

public class ClientesDao {

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

	public Clientes pesquisarClientesPorCpf(String cpf) {

		String consulta = "select * from clientes where cpf = " + cpf;
		Clientes cliente = new Clientes();

		try {
			Connection conn = getConexao();
			PreparedStatement pst = conn.prepareStatement(consulta);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				cliente.setCpf(rs.getString(1));
				cliente.setNome(rs.getString(2));
				cliente.setTelefone(rs.getString(3));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cliente;
	}

}
