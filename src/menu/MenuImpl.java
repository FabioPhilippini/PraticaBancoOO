package menu;

import java.util.Scanner;

import entities.Banco;
import entities.Cliente;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;
import exceptions.ExcecaoGenerica;
import util.ValidaFormatos;

public class MenuImpl {
	
    Banco banco = new Banco("JavaBank");
	
	public int obterOpcao() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bem vindo ao banco " + banco.getNome());
		System.out.println("Informe a opção desejada:");
		System.out.println("1-Listar contas.");
		System.out.println("2-Inserir conta.");
		System.out.println("3-Sacar.");
		System.out.println("4-Depositar.");
		System.out.println("5-Transferir.");
		System.out.println("6-Exibir dados da conta desejada.");
		System.out.println("7-Dados do titular da conta.");
		System.out.println("8-Remover Conta.");
		System.out.println("9-Sair.");
		System.out.println();
		int opcao = sc.nextInt();
		System.out.println();
		return opcao;
	}

	public void dadosCliente() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-Dados do cliente-");
		System.out.print("Inserir o número da conta do cliente: ");
		int numeroConta = sc.nextInt();
		Conta conta = banco.contaNum(banco.getContas(), numeroConta);
		if (conta == null) {
			System.err.println("Conta não encontrada \n");
		} 
		else {
			conta.dadosCliente();
		}
		System.out.println();

	}

	public void removerConta() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-Remover conta-");
		System.out.print("Número da conta a ser removida: ");
		int numeroConta = sc.nextInt();
		Conta conta = banco.contaNum(banco.getContas(), numeroConta);
		if (conta != null && conta.getSaldo() == 0) {
			System.out.print("Deseja de fato remover a conta (S/N)?: ");
			char resposta = sc.next().charAt(0);
			if (resposta == 'S' || resposta == 's') {
				banco.getContas().remove(conta);
				System.out.println("Conta removida com sucesso. \n");
			} 
			else {
				System.out.println("Operação abortada!!! \n");
			}
		} 
		else {
			System.err.println("Conta não pôde ser removida, verifique se a conta está zerada. \n");
		}
		System.out.println();
	}

	public void exibirDados() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-Dados da conta-");
		System.out.print("Inserir o número da conta: ");
		int numeroConta = sc.nextInt();
		Conta conta = banco.contaNum(banco.getContas(), numeroConta);
		if (conta == null) {
			System.err.println("Conta não encontrada. \n");
		} 
		else {
			conta.exibirExtrato();
		}
		System.out.println();

	}

	public void listarContas() {
		System.out.println("Lista de contas: ");
		if (banco.getContas().isEmpty()) {
			System.err.println("Nenhuma conta cadastrada. \n");
		} 
		else {
			for (Conta c : banco.getContas()) {
				System.out.println(c.toString());
				System.out.println();
			}
		}

	}

	public void transferir() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-Transferência-");
		System.out.print("Digite o número da conta: ");
		int numeroConta = sc.nextInt();
		Conta conta = banco.contaNum(banco.getContas(), numeroConta);
		if (conta == null) {
			System.err.println("Conta não encontrada. \n");
		}
		else {
			System.out.print("Número da conta que vai receber a transferência: ");
			int numeroContaTransferencia = sc.nextInt();
			Conta outraConta = banco.contaNum(banco.getContas(), numeroContaTransferencia);
			if (outraConta != null) {
				System.out.print("Valor a ser transferido: ");
				double valorTransferencia = sc.nextDouble();
				try {
					conta.transferir(outraConta, valorTransferencia);
				} 
				catch (ExcecaoGenerica e) {
					System.err.println("Erro no procedimento: " + e.getMessage() + "\n");
				}
				System.out.println("Transferência efetuada para conta: " + outraConta.getNumero() + "\n");
			} 
			else {
				System.err.print("Conta para transferência não encontrada. \n");
			}
		}
	}

	public void depositar() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-Depósito-");
		System.out.print("Digite o número da conta: ");
		int numeroConta = sc.nextInt();
		Conta conta = banco.contaNum(banco.getContas(), numeroConta);
		if (conta == null) {
			System.err.println("Conta não encontrada \n");
		} 
		else {
			System.out.print("Valor a ser depositado: ");
			double valorDeposito = sc.nextDouble();
			try {
				conta.depositar(valorDeposito);
				System.out.println("Deposito efetuado com sucesso. \n");
			} 
			catch (ExcecaoGenerica e) {
				System.err.println("Erro no procedimento: " + e.getMessage() + "\n");
			}
		}
	}

	public void sacar() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o número da conta: ");
		int numeroConta = sc.nextInt();
		Conta conta = banco.contaNum(banco.getContas(), numeroConta);
		if (conta == null) {
			System.err.println("Conta não encontrada. \n");
		} 
		else {
			System.out.print("Valor a ser sacado: ");
			double valorSaque = sc.nextDouble();
			try {
				conta.sacar(valorSaque);
			} 
			catch (ExcecaoGenerica e) {
				System.err.println("Erro no procedimento: " + e.getMessage() + "\n");
			}
			System.out.println();
		}
	}

	public void inserirConta() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-Dados a serem inseridos-");
		System.out.print("Titular: ");
		String nome = sc.nextLine();

		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		while (ValidaFormatos.formatoCPF(cpf) != true) {
			System.out.println("Formato de CPF inválido . Tente novamente com o formato (XXX.XXX.XXX-XX) ou apenas com os 11 dígitos : ");
			cpf = sc.nextLine();
		}

		System.out.print("Telefone: ");
		String telefone = sc.nextLine();
		while (ValidaFormatos.formatoTelefone(telefone) != true) {
			System.out.println("Formato de telefone inválido. Tente novamente com o formato (XX XXXX-XXXX) : ");
			telefone = sc.nextLine();
		}

		System.out.print("Email: ");
		String email = sc.nextLine();
		while (ValidaFormatos.formatoEmail(email) != true) {
			System.out.println("Formato de email inválido. Tente novamente com o formato (exemplo@email.com) : ");
			email = sc.nextLine();
		}

		Cliente cliente = new Cliente(nome, cpf, telefone, email);

		System.out.print("Número da conta: ");
		int numeroConta = sc.nextInt();
		while (banco.contaNum(banco.getContas(), numeroConta) != null) {
			System.out.print("Conta já existe. Entre com outro número: ");
			numeroConta = sc.nextInt();
		}

		System.out.print("Limite da conta: ");
		double limite = sc.nextDouble();

		System.out.print("Agência: ");
		sc.nextLine();
		int agencia = sc.nextInt();
		
		System.out.print("Saldo: ");
		double saldo = sc.nextDouble();
		System.out.print("Conta corrente ou poupança (C/P): ");
		char resp = sc.next().charAt(0);
		if (resp == 'c' || resp == 'C') {
			System.out.print("De quantos R$ é o desconto na hora do saque: ");
			double desconto = sc.nextDouble();
			banco.adicionarConta(new ContaCorrente(cliente, numeroConta, limite, agencia, saldo, desconto));
			System.out.println();
		} 
		else {
			System.out.print("De quantos % é a taxa de juros do depósito: ");
			double bonus = sc.nextDouble();
			banco.adicionarConta(new ContaPoupanca(cliente, numeroConta, limite, agencia, saldo, bonus));
			System.out.println();
		}
	}

}
