package application;

import java.util.Locale;
import java.util.Scanner;
import menu.MenuImpl;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		MenuImpl menu = new MenuImpl();
		int opcao = menu.obterOpcao();

		while (opcao != 9) {
			switch (opcao) {
			case 1:
				menu.listarContas();
				break;
			case 2:
				menu.inserirConta();
				break;
			case 3:
				menu.sacar();
				break;
			case 4:
				menu.depositar();
				break;
			case 5:
				menu.transferir();
				break;
			case 6:
				menu.exibirDados();
				break;
			case 7:
				menu.dadosCliente();
				break;
			case 8:
				menu.removerConta();
				break;
			default:
				System.err.println("Opção Inválida");
				System.out.println();
			}
			opcao = menu.obterOpcao();
		}
		System.out.println("Obrigado por utilizar nossos serviços");
		System.out.println();

		sc.close();
	}

}
