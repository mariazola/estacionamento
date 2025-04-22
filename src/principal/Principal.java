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

	}

}
