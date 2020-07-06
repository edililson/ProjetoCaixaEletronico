package br.start.latam.ProjetoCaixa.VIEW.idioma;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import br.start.latam.ProjetoCaixa.Util;

public class MSG_ERROR {
	
	public static String NOME = MSG_ERROR.get("NOME");
	public static String SENHA = MSG_ERROR.get("SENHA");
	
	//Construtor privado
	private MSG_ERROR() {}
	
	private static ResourceBundle rb_erro;
	
	public static String get(String chave) {
		rb_erro = (rb_erro == null) ? PropertyResourceBundle.getBundle(Util.mensagem, Util.idioma) : rb_erro;
		return rb_erro.getString(chave);
	}

}

