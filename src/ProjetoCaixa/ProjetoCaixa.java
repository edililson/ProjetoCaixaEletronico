package ProjetoCaixa;

import java.util.Scanner;

public class ProjetoCaixa {

	public static void main(String[] args) {
		boolean cadastrarConta = true;
		while (true) {
			if (cadastrarConta) {
				criarConta(cadastrarConta);
			}
		}
	}

	public static void criarConta(boolean validar) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Bem vindo ao projeto Start Latam!");
		System.out.println("Voc� est� criando uma conta, se j� tiver uma conta digite sair!");
		String opcao;
		opcao = scan.next();
		if (opcao == "SAIR" && opcao == "sair") {
			System.out.println("Saiu");
		}

	}

}
