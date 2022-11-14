package entities;

public class ContaPoupanca extends Conta {
	
    private double juros;
	
	public ContaPoupanca() {
		super();
	}
	
	public ContaPoupanca(Cliente cliente, int numero, double limite, int agencia, double saldo,double juros) {
		super(cliente, numero, limite, agencia, saldo);
		this.juros = juros;
	}
	
	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}

	@Override
	public void depositar(double quantia) {
		super.validarDeposito(quantia);
		this.saldo += quantia - (quantia * juros / 100);
	}

	@Override
	public void exibirExtrato() {
		super.exibirExtrato();
		System.out.println("Tipo: Conta Poupança");
	}

	@Override
	public String toString() {
		return super.toString() + ", Juros: " + String.format("%.2f", juros) + " % - " + "Tipo: Conta Poupança" + " ]";
	}

}
