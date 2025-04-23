package principal;

import dao.ClientesDao;
import entidades.Clientes;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Hello word");
		
		ClientesDao daoCli = new ClientesDao();
		
		daoCli.getConexao();
		
		Clientes cliente = daoCli.pesquisarClientesPorCpf("12345678901");
		System.out.println(cliente);
		
		
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
