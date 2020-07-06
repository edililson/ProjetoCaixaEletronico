package br.start.latam.ProjetoCaixa.VIEW.idioma;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import br.start.latam.ProjetoCaixa.Util;

public class MSG {
	
	public static String BEM_VINDO = MSG.get("BEM_VINDO");
	public static String CRIAR_CONTA = MSG.get("CRIAR_CONTA");
	public static String SAIR = MSG.get("SAIR");
	public static String CPF = MSG.get("CPF");
	public static String DT_NASCIMENTO = MSG.get("DT_NASCIMENTO");
	public static String NOME = MSG.get("NOME");
	public static String SUCESSO_CADASTRO_CONTA = MSG.get("SUCESSO_CADASTRO_CONTA");
	public static String NUM_CONTA = MSG.get("NUM_CONTA");
	public static String VOLTA_TELA_CADASTRO = MSG.get("VOLTA_TELA_CADASTRO");
	public static String CONFIRMAR = MSG.get("CONFIRMAR");
	
	//Construtor privado
	private MSG() {}
	
	private static ResourceBundle rb_msg;
	
	public static String get(String chave) {
		rb_msg = (rb_msg == null) ? PropertyResourceBundle.getBundle(Util.mensagem, Util.idioma) : rb_msg;
		return rb_msg.getString(chave);
	}

}

