package entidades;

import java.sql.Date;
import java.sql.Timestamp;

public class Registro {

	private int id;
	private Date data_de_estacionamento;
	private Timestamp data_de_entrada;
	private Timestamp data_de_saida;
	private double total_a_pagar;
	private Veiculo veiculo;

	public Registro() {
		super();
	}

	public Registro(Date data_de_estacionamento, Timestamp data_de_entrada, Timestamp data_de_saida,
			double total_a_pagar, Veiculo veiculo) {
		super();
		this.data_de_estacionamento = data_de_estacionamento;
		this.data_de_entrada = data_de_entrada;
		this.data_de_saida = data_de_saida;
		this.total_a_pagar = total_a_pagar;
		this.veiculo = veiculo;
	}

	public Registro(int id, Date data_de_estacionamento, Timestamp data_de_entrada, Timestamp data_de_saida,
			double total_a_pagar, Veiculo veiculo) {
		super();
		this.id = id;
		this.data_de_estacionamento = data_de_estacionamento;
		this.data_de_entrada = data_de_entrada;
		this.data_de_saida = data_de_saida;
		this.total_a_pagar = total_a_pagar;
		this.veiculo = veiculo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData_de_estacionamento() {
		return data_de_estacionamento;
	}

	public void setData_de_estacionamento(Date data_de_estacionamento) {
		this.data_de_estacionamento = data_de_estacionamento;
	}

	public Timestamp getData_de_entrada() {
		return data_de_entrada;
	}

	public void setData_de_entrada(Timestamp data_de_entrada) {
		this.data_de_entrada = data_de_entrada;
	}

	public Timestamp getData_de_saida() {
		return data_de_saida;
	}

	public void setData_de_saida(Timestamp data_de_saida) {
		this.data_de_saida = data_de_saida;
	}

	public double getTotal_a_pagar() {
		return total_a_pagar;
	}

	public void setTotal_a_pagar(double total_a_pagar) {
		this.total_a_pagar = total_a_pagar;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	@Override
	public String toString() {
		return "Registro [id=" + id + ", data_de_estacionamento=" + data_de_estacionamento + ", data_de_entrada="
				+ data_de_entrada + ", data_de_saida=" + data_de_saida + ", total_a_pagar=" + total_a_pagar
				+ ", veiculo=" + veiculo + "]";
	}

}
