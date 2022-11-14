package entities;

import exceptions.ExcecaoGenerica;

public abstract class Conta implements IConta {
	
	private Cliente cliente;
	private int numero;
	private double limite;
	private int agencia;
	protected double saldo;
	
	public Conta() {
	}

	public Conta(Cliente cliente, int numero, double limite, int agencia, double saldo) {
		this.cliente = cliente;
		this.numero = numero;
		this.limite = limite;
		this.agencia = agencia;
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void depositar(double quantia) {
		validarDeposito(quantia);
		this.saldo += quantia;
	}

	public void validarDeposito(double quantia) {
		if (quantia <= 0) {
			throw new ExcecaoGenerica("Valor inválido.");
		}
	}
	
	public void sacar(double quantia) {
		validarSaque(quantia);
		this.saldo -= quantia;
		System.out.println("Saque efetuado.");
	}

	public void validarSaque(double quantia) {
		if (quantia <= 0) {
			throw new ExcecaoGenerica("Valor inválido.");
		}
		if (quantia > this.saldo) {
			throw new ExcecaoGenerica("Saldo Insuficiente.");
		}
	}
	
	public void exibirExtrato() {
		System.out.println("Número da Conta: " + this.getNumero());
		System.out.println("Número da Agência: " + this.getAgencia());
		System.out.println("Titular da conta: " + this.getCliente().getNome());
		System.out.println("CPF: " + this.getCliente().getCPF());
		System.out.println("Limite: " + this.getLimite());
		System.out.println("Saldo: " + this.getSaldo());
	}
	
	public void transferir(Conta outraConta, double quantia) {
		sacar(quantia);
		outraConta.depositar(quantia);
	}
	
	public void dadosCliente() {
		System.out.println(cliente);
	}
	
	
	@Override
	public String toString() {
		return "[ Titular: " + cliente.getNome() + " - Conta: " + numero + " - Agencia: " + agencia + " - Limite: "
				+ limite + " - Saldo: " + saldo;
	}

}
