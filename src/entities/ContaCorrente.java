package entities;

public class ContaCorrente extends Conta {
	
	private double desconto;

	public ContaCorrente() {
		super();
	}

	public ContaCorrente(double desconto) {
		super();
		this.desconto = desconto;
	}
	
	public ContaCorrente(Cliente cliente, int numero, double limite, int agencia, double saldo,double desconto) {
		super(cliente, numero, limite, agencia, saldo);
		this.desconto = desconto;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	@Override
	public void sacar(double quantia) {
		super.validarSaque(quantia);
		quantia += desconto;
		super.sacar(quantia);
	}

	@Override
	public void exibirExtrato() {
		super.exibirExtrato();
		System.out.println("Tipo: Conta Corrente");
	}

	@Override
	public String toString() {
		return super.toString() + " - Desconto: " + String.format("%.2f", desconto) + " - " + "Tipo: Conta Corrente"
				+ " ]";
	}

}
