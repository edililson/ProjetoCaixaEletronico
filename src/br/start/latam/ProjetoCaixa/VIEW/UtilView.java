package br.start.latam.ProjetoCaixa.VIEW;

import java.io.IOException;

import br.start.latam.ProjetoCaixa.Util;

public class UtilView {
	
	/**
	 * Construtor privado para que ninguem possa instanciar essa classe
	 */
	private UtilView() {}
	
	/**
	 * Função que limpa a tela no windows, no linux e no MacOS
	 * @throws InterruptedException
	 * @throws IOException
	 */
    public static void limpaTela(){
    	if(Util.test) {
    		for (int i = 0; i < 50; ++i) {System.out.println();}
    	} else {
	    	try {
	    		if (System.getProperty("os.name").contains("Windows"))
	    			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	    		else
	    			Runtime.getRuntime().exec("clear");
	    	} catch (InterruptedException | IOException e) {
	    		System.err.println("não foi possivel limpar o console erro:" +e.getCause());
	    		Thread.currentThread().interrupt();
	    	}
    	}
    }
}
