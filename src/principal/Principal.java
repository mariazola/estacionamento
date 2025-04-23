package principal;

import java.util.List;

import dao.ClientesDao;
import dao.RegistroDao;
import dao.VeiculoDao;
import entidades.Clientes;
import entidades.Veiculo;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Hello word");
		
		ClientesDao daoCli = new ClientesDao();
		
		daoCli.getConexao();
		
		RegistroDao daoRe = new RegistroDao();

		daoRe.getConexao();
		Clientes cliente = daoCli.pesquisarClientesPorCpf("12345678901");
		System.out.println(cliente);
		
		VeiculoDao daoVei = new VeiculoDao();
		List<Veiculo> lista = daoVei.listarVeiculo();
		

		for (Veiculo veiculo : lista) {
			System.out.println(veiculo);
		}
		
		
		int horario = 1;
		int resultado = horario/ 3;
		
		if (horario % 3 == 0) {
			resultado = resultado;
			
		} else {
			resultado = resultado + 1;
		}
		
System.out.println(resultado);
	}

}
