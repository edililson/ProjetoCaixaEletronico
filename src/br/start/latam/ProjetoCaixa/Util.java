package br.start.latam.ProjetoCaixa;

import java.util.Locale;
import java.util.Scanner;

/**
 * Classe utilitária
 */
public class Util {

	//TODO criar arquivo de parametro de execução
	public static boolean test;
	public static boolean logado = false;
	public static Scanner scan;
	public static String contaDAOArq;
	public static Locale idioma = new Locale("pt_BR");
	public static String mensagem = "br.start.latam.ProjetoCaixa.VIEW.idioma.mensagem";
	public static String mensagemErro = "br.start.latam.ProjetoCaixa.VIEW.idioma.mensagem_erro";
	
	public static void init() {
		Util.scan = new Scanner(System.in);
		Util.contaDAOArq = ".\\Arquivos\\contas.txt";
		Util.test = false;
	}
	
	public static void initTest() {
		Util.test = true;
		Util.contaDAOArq = ".\\Arquivos\\contas_teste.txt";
	}
	
	public static void initDesenv() {
		Util.scan = new Scanner(System.in);
		Util.contaDAOArq = ".\\Arquivos\\contas.txt";		
		Util.test = true;
	}
	
	/**
	 * Construtor privado para que ninguem possa instanciar essa classe
	 */
	private Util() {}
}
