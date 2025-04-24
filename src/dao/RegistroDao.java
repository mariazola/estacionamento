package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entidades.Clientes;
import entidades.Registro;
import entidades.Veiculo;

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

	public List<Registro> listarRegisto() {

		String consulta = "SELECT "
				+ "            r.id, r.data_de_estacionamento, r.hora_de_entrada, r.hora_de_saida, r.total_a_pagar,"
				+ "            v.placa, v.modelo, v.cor,"
				+ "            c.cpf, c.nome, c.telefone"
				+ "        FROM registro as r "
				+ "        INNER JOIN veiculo as v ON r.placa_veiculo = v.placa"
				+ "        INNER JOIN clientes as c ON v.cpf_cliente = c.cpf";
		List<Registro> lista = new ArrayList<Registro>();

		try {

			Connection conn = getConexao();
			PreparedStatement pst = conn.prepareStatement(consulta);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				int id = rs.getInt(1);
				Date data_de_estacionamento = rs.getDate(2);
				Timestamp data_de_entrada = rs.getTimestamp(3);
				Timestamp data_de_saida = rs.getTimestamp(4);
				double total_a_pagar = rs.getDouble(5);
				String placaVeiculo = rs.getString(6);
				String modeloVeiculo = rs.getString(7);
				String corVeiculo = rs.getString(8);
				
	            String cpf = rs.getString(9);
	            String nome = rs.getString(10);
	            String telefone = rs.getString(11);

	            Clientes cliente = new Clientes(cpf, nome, telefone);
				
				Veiculo veiculo = new Veiculo(placaVeiculo, modeloVeiculo, corVeiculo, cliente);
				  Registro registro = new Registro(id, data_de_estacionamento, data_de_entrada, data_de_saida, total_a_pagar, veiculo);
		            lista.add(registro);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
	public int inserirRegistro(Registro novoRegistro) {

		String consulta = "insert into registro " + "(data_de_estacionamento,hora_de_entrada,hora_de_saida,total_a_pagar, placa_veiculo) values"
				+ " (?,?,?,?,?)    ";

		try {
			Connection conn = getConexao();
			PreparedStatement pst = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
			// RETURN_GENERATED_KEYS: Retornando o id criado pelo DB
			pst.setDate(1, novoRegistro.getData_de_estacionamento());
			pst.setTimestamp(2, novoRegistro.getData_de_entrada());
			pst.setTimestamp(3, novoRegistro.getData_de_saida());
			pst.setDouble(4, novoRegistro.getTotal_a_pagar());
			pst.setString(5, novoRegistro.getVeiculo().getPlaca());
			

			// Executando a consulta
			pst.executeUpdate();

			// Pegando o ID criado pelo DB
			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				int chaveGerada = rs.getInt(2);
				System.out.println("Passou por aqio");
				return chaveGerada;
			}

			rs.close();
			pst.close();
			
			
			
			
			conn.close();

		} catch (Exception e) {

		}

		return 0;

	}

}
