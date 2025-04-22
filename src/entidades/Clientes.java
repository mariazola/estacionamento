package entidades;

public class Clientes {

	private String cpf;
	private String nome;
	private String telefone;

	public Clientes() {
		super();
	}

	public Clientes(String cpf, String nome, String telefone) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Clientes [cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + "]";
	}

}
