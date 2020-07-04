package ProjetoCaixa;

import java.util.ArrayList;
import java.util.HashMap;

public final class Arquivo {

	private static HashMap<String, ArrayList<String>> arquivos = new HashMap<String, ArrayList<String>>();

	public static ArrayList<String> lerArquivo(String caminho) {
		// TODO ler arquivo inteiro e jogar num arraylist
		return arquivos.get(caminho);
	}

	public static void escreverNoFinalDoArquivo(String caminho, String conteudo) {
		ArrayList<String> arquivo = arquivos.get(caminho);
		arquivo.add(conteudo);
	}

	public static void escrever(String caminho, String conteudo) {
		ArrayList<String> arquivo = arquivos.get(caminho);
		arquivo.clear();
		arquivo.add(conteudo);
	}
	
	public static boolean existeArquivo(String caminho) {
		return arquivos.containsKey(caminho);
	}
}