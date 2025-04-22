package entidades;

public class Veiculo {
	
	
   
    private String placa;
	private String modelo;
	private String cor;
	private Clientes cliente;
	
	
	


	public Veiculo() {
		super();
	}



	public Veiculo(String placa, String modelo, String cor, Clientes cliente) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.cor = cor;
		this.cliente = cliente;
	}



	public String getPlaca() {
		return placa;
	}



	public void setPlaca(String placa) {
		this.placa = placa;
	}



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public String getCor() {
		return cor;
	}



	public void setCor(String cor) {
		this.cor = cor;
	}



	public Clientes getCliente() {
		return cliente;
	}



	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}



	@Override
	public String toString() {
		return "Registro [placa=" + placa + ", modelo=" + modelo + ", cor=" + cor + ", cliente=" + cliente + "]";
	}
	
	
}
