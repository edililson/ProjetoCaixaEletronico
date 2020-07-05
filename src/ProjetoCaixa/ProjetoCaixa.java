package ProjetoCaixa;

import java.util.ArrayList;
import java.util.Scanner;

public class ProjetoCaixa {
	/**
	  * @author Edililson David
	 */
	public static void main(String[] args) {
		
		String arq = "text.txt";
		//Escrever no arquivo
		/*
		String texto = "{\"conta\" : 3030, \"cpf\" : 05554558, \"dtNascimenti\" : 11/10/1997}";
		
		if(ArquivoTxt.Write(arq, texto)) {
			System.out.println("Arquivo salvo com sucesso!");
		}else {
			System.out.println("Erro ao salvar o arquivo");
		}
		*/
		
		String text = ArquivoTxt.Read(arq);
		if(text.isEmpty()) {
			System.out.println("Erro ao ler o arquivo");
		}else {
			System.out.println(text);
		}
		
		
		/*
		String arq = "./contas.txt";
		if (!Arquivo.existeArquivo(arq)) {
			Arquivo.criaArquivo(arq);
		}
		
		Arquivo.escrever(arq, "{\n\"conta\" : 3020, \n\"cpf\" : 06402505508, \n\"dtNascimento\" : 26/11/2011 \n}");
		Arquivo.escreverNoFinalDoArquivo(arq, "{\"conta\" : 3030, \"cpf\" : 05554558, \"dtNascimenti\" : 11/10/1997}");
		ArrayList<String> lista = Arquivo.lerArquivo(arq);
		
		for(String string : lista){
			System.out.println(string);
		}
		*/
	}

	/*
	 * public static void criarConta(boolean validar) { Scanner scan = new
	 * Scanner(System.in); System.out.println("Bem vindo ao projeto Start Latam!");
	 * System.out.
	 * println("Você está criando uma conta, se já tiver uma conta digite sair!");
	 * String opcao; opcao = scan.next(); if (opcao == "SAIR" && opcao == "sair") {
	 * System.out.println("Saiu"); }
	 * 
	 * 
	 * 
	 * 
	 * boolean cadastrarConta = true; while (true) { if (cadastrarConta) {
	 * criarConta(cadastrarConta); } }
	 */
}
