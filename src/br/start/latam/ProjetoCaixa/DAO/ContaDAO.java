package br.start.latam.ProjetoCaixa.DAO;

import java.util.ArrayList;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.start.latam.ProjetoCaixa.ArquivoTxt;
import br.start.latam.ProjetoCaixa.Conta;
import br.start.latam.ProjetoCaixa.Util;

public class ContaDAO {

	private static ContaDAO cDao = null;
	private String arq = Util.contaDAOArq;
	
	private ContaDAO() {
		//
	}
	
	public static ContaDAO getInstance() {
		if(cDao == null) {
			cDao = new ContaDAO();
		}
		
		return cDao;
	}
	
	public int criar(Conta conta) {
		conta.setNumeroConta(this.getNumeroDaConta());
		Gson gson = new GsonBuilder().create();
		String texto = gson.toJson(conta, Conta.class);
		ArquivoTxt.write(arq, texto, true);
		
		return conta.getNumeroConta();
	}

	private int getNumeroDaConta(){
		//TODO alterar para não repetir o numero da conta
		Random random = new Random();        
        int numeroDaConta = random.nextInt(1000);
		return numeroDaConta;
	}

	public Conta busca(int numConta) {
		Gson gson = new Gson();
		
		ArrayList<String> contasJson = ArquivoTxt.read(arq);
		
		for (String contaJson : contasJson) {
			Conta conta = gson.fromJson(contaJson, Conta.class);
			if(conta == null) {
				continue;
			}
			if(conta.getNumeroConta() == numConta) {
				return conta;
			}
		}

		return null;
	}

	public void atualiza(Conta conta) {
		Gson gson = new Gson();
		
		ArrayList<String> contasJson = ArquivoTxt.read(arq);
		
		for (int i = 0; i < contasJson.size(); i++) {
			
			Conta contaTemp = gson.fromJson(contasJson.get(i), Conta.class);
			if(contaTemp == null) {
				continue;
			}
			if(contaTemp.getNumeroConta() == conta.getNumeroConta()) {
				contasJson.remove(i);
				gson = new GsonBuilder().create();
				String texto = gson.toJson(conta, Conta.class);
				contasJson.add(texto);
				break;
			}
		}
		
		ArquivoTxt.rewrite(arq, contasJson);
	}
}
