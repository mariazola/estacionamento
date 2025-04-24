package principal;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import dao.ClientesDao;
import dao.RegistroDao;
import entidades.Registro;
import entidades.Veiculo;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Hello word");

		ClientesDao daoCli = new ClientesDao();

		//daoCli.getConexao();

		RegistroDao daoRe = new RegistroDao();

		daoRe.getConexao();
	//	Clientes cliente = daoCli.pesquisarClientesPorCpf("12345678901");
	//	System.out.println(cliente);

		//VeiculoDao daoVei = new VeiculoDao();
	//	List<Veiculo> lista = daoVei.listarVeiculo();

		//for (Veiculo veiculo : lista) {
	//		System.out.println(veiculo);
	//	}

		List<Registro> lista2 = daoRe.listarRegisto();

		for (Registro registro : lista2) {
			System.out.println(registro);
		}
		
		   Veiculo veiculo = new Veiculo("ABC1234");

	        // Criar registro com datas manuais
	        Registro registro = new Registro();
	        registro.setData_de_estacionamento(Date.valueOf("2025-04-23")); // yyyy-MM-dd
	        registro.setData_de_entrada(Timestamp.valueOf("2025-04-23 10:00:00")); // yyyy-MM-dd HH:mm:ss
	        registro.setData_de_saida(Timestamp.valueOf("2025-04-23 12:00:00"));   // yyyy-MM-dd HH:mm:ss
	        registro.setTotal_a_pagar(25.00);
	        registro.setVeiculo(veiculo);

	        // Inserir no banco e exibir ID gerado
	        int idGerado = daoRe.inserirRegistro(registro);
	      System.out.println("Registro inserido com ID: " + idGerado);
	    
		
		

		int horario = 1;
		int resultado = horario / 3;

		if (horario % 3 == 0) {
			resultado = resultado;

		} else {
			resultado = resultado + 1;
		}

		System.out.println(resultado);
		
		
	}

}
