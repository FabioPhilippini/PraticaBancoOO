package entities;

public interface IConta {
	
	void depositar(double quantia);
	void sacar(double quantia);
	void transferir(Conta outraConta, double quantia);
	void exibirExtrato();
	void dadosCliente();

}
