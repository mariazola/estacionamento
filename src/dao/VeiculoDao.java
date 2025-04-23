package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Clientes;
import entidades.Veiculo;

public class VeiculoDao {

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

	public List<Veiculo> listarVeiculo() {

		String consulta ="select veiculo.placa, veiculo.modelo, veiculo.cor, clientes.cpf, clientes.nome, clientes.telefone from veiculo inner join clientes on veiculo.cpf_cliente = clientes.cpf";
		List<Veiculo> lista = new ArrayList<Veiculo>();

		try {

			Connection conn = getConexao();
			PreparedStatement pst = conn.prepareStatement(consulta);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String placa = rs.getString(1);
				String modelo = rs.getString(2);
				String cor = rs.getString(3);
				String cpfClientes = rs.getString(4);
				String nomeClientes = rs.getString(5);
				String telefoneClientes = rs.getString(6);

				Clientes cliente = new Clientes(cpfClientes, nomeClientes, telefoneClientes);

				// Jeito errado (Gasto de processamento)
//				CategoriaDao dao = new CategoriaDao();
//				Categoria categoria = dao.pesquisarCategoriaPorId(id_categoria);

				Veiculo veiculo = new Veiculo(placa, modelo, cor, cliente);
				lista.add(veiculo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
}