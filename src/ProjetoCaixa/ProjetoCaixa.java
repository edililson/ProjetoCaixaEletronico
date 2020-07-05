package ProjetoCaixa;

import java.util.Scanner;

public class ProjetoCaixa {
	private static Process exec;

	/**
	 * @author Edililson David
	 */
	public static void main(String[] args) {
		String arq = ".\\Arquivos\\text.txt";
		Scanner scan = new Scanner(System.in);
		
		Contas contas = new Contas();
		System.out.println(" Escolha uma opção");
		System.out.println(" 1 - Acessar sua conta");
		System.out.println(" 2 - Criar uma conta");
		int opcao;
		opcao = scan.nextInt();
		
		//TODO Esse for serve para "LIMPAR A TELA"
		for (int i = 0; i < 100; ++i) { 
		       System.out.println();  
		}
		
		switch(opcao){
		case 1:
			contas.AcessarConta();
			break;
		case 2:
			contas.CadastraConta();
			break;
		default:
			System.out.println("Opção invalida");
		}
		
		System.out.println(ArquivoTxt.Read(arq));
		
		
		
		/*
		//TODO Modelo exemplo
		
		 = "{\n\"conta\" : 3030, \"cpf\" : 05554558, \"dtNascimenti\" : 11/10/1997\n}\r\n";
		// TODO Neste metodo quando eu passo true ele vai escrever no final do
		// arquivo,se eu passar false ele continua escrevendo na mesma linha
		if (ArquivoTxt.Write(arq, texto, true)) {
			System.out.println("Arquivo salvo com sucesso!");
		} else {
			System.out.println("Erro ao salvar o arquivo");
		}
		
		//TODO Essa parte seve para ler o arquivo
		String text = ArquivoTxt.Read(arq);
		if (text.isEmpty()) {
			System.out.println("Erro ao ler o arquivo");
		} else {
			System.out.println(text);
		}
		*/
	}
}