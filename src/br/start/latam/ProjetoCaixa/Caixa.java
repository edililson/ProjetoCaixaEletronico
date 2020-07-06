package br.start.latam.ProjetoCaixa;

import java.math.BigDecimal;

import br.start.latam.ProjetoCaixa.DAO.ContaDAO;
import br.start.latam.ProjetoCaixa.VIEW.UtilView;

public class Caixa {

	private static Caixa caixa;
	private Conta conta;
	private Caixa() {
		//
	}
	
	public static Caixa getInstance() {
		if(caixa == null) {
			caixa = new Caixa();
		}
		
		return caixa;
	}

	public void acessarSistema() {
		int numConta;
		int senha;
		
		System.out.println("Digite o numero de sua conta");
		numConta = Util.scan.nextInt();
		System.out.println("Digite sua senha de 6 digitos");
		senha = Util.scan.nextInt();
		
		conta = ContaDAO.getInstance().busca(numConta);
		if(conta == null) {
			System.out.println("Conta nao encontrada");
		} else {
			if(conta.getSenha() == senha) {
				Util.logado = true;
				menuOperacoesFinanceiras();
			} else {
				System.out.println("Senha invalida");
				//TODO contar quantas vezes errou a senha
			}
		}
	}
	
	protected void menuOperacoesFinanceiras() {
		while (Util.logado) {
			System.out.println(" Escolha uma opção");
			System.out.println(" 1 - Saldo");
			System.out.println(" 2 - ...");
			int opcao;
			opcao = Util.scan.nextInt();

			UtilView.limpaTela();

			switch (opcao) {
			case 1:
				saldo();
				break;
			case 2:
				extrato();
				break;
			case 3:
				deposito();
				break;
			case 4:
				saque();
				break;
			case 5:
				Util.logado = false;
				break;
			default:
				System.out.println("Opção invalida");
			}
		}
	}

	private void saque() {
		System.out.println("Digite o valor do saque");
		BigDecimal valor = Util.scan.nextBigDecimal();
		conta.atualizaSaldo(valor.multiply(new BigDecimal("-1")));
		
	}

	private void deposito() {
		System.out.println("Digite o valor do Deposito");
		BigDecimal valor = Util.scan.nextBigDecimal();
		conta.atualizaSaldo(valor);
	}

	private void extrato() {
		System.out.println("Extrato: " + conta.getExtrato());
	}

	private void saldo() {
		UtilView.limpaTela();
		System.out.println("Saldo: " + conta.getSaldo());
		
	}

}
