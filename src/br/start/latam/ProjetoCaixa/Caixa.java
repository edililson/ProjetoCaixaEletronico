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
			System.out.println(" Escolha uma op��o");
			System.out.println(" 1 - Saldo");
			System.out.println(" 2 - Extrato");
			System.out.println(" 3 - Dep�sito");
			System.out.println(" 4 - Saque");
			System.out.println(" 5 - Emprestimos");
			System.out.println(" 6 - Transfer�ncia");
			System.out.println(" 7 - Sair");
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
				emprestimo();
				break;
			case 6:
				transferencia();
				break;
			case 7:
				Util.logado = false;
				break;
			default:
				System.out.println("Op��o invalida");
			}
		}
	}

	

	

	private void saque() {
		UtilView.limpaTela();
		System.out.println("Digite o valor do saque");
		BigDecimal valor = Util.scan.nextBigDecimal();
		conta.atualizaSaldo(valor.multiply(new BigDecimal("-1")));
		String texto = "Saque realizado no valor de: " + valor;
		conta.gravarExtrato(texto);
	}

	private void deposito() {
		UtilView.limpaTela();
		System.out.println("Digite o valor do Deposito");
		BigDecimal valor = Util.scan.nextBigDecimal();
		conta.atualizaSaldo(valor);
		String texto = "Deposito realizado no valor de: " + valor;
		conta.gravarExtrato(texto);
	}

	private void extrato() {
		UtilView.limpaTela();
		conta.getExtrato();
		System.out.println("");
	}

	private void saldo() {
		UtilView.limpaTela();
		System.out.println("Saldo: " + conta.getSaldo());
	}
	
	private void emprestimo() {
		UtilView.limpaTela();
		System.out.println("Emprestomo: " + conta.getEmprestimo());
		
	}

	private void transferencia() {
		//TODO Fazer o sistema de transfereincia
	}
}
