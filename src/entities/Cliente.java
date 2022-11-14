package entities;

public class Cliente {
	
	private String nome;
	private String CPF;
	private String telefone;
	private String email;
	
	public Cliente() {
	}

	public Cliente(String nome, String cPF, String telefone, String email) {
		this.nome = nome;
		CPF = cPF;
		this.telefone = telefone;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + " - CPF: " + CPF + " - Telefone: " + telefone + " - Email: " + email;
	}

}
