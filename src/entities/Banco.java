package entities;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private String nome;
	private List<Conta> contas = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}
	
	public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

	public Banco() {
		
	}
	
	public Banco(String nome) {
		super();
		this.nome = nome;
	}

	public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

	public Conta contaNum(List<Conta> listaContas, int numConta) {
		Conta conta = listaContas.stream().filter(x -> x.getNumero() == numConta).findFirst().orElse(null);
		return conta;
	}

	@Override
	public String toString() {
		return "Banco [nome = " + nome + "\n , contas=" + contas + "]\n";
	}

}
