package br.start.latam.ProjetoCaixa;

import br.start.latam.ProjetoCaixa.DAO.ContaDAO;
import br.start.latam.ProjetoCaixa.VIEW.TelaCadastraConta;
import br.start.latam.ProjetoCaixa.VIEW.UtilView;
import br.start.latam.ProjetoCaixa.VIEW.idioma.MSG;

public class ProjetoCaixa {

	/**
	 * @author Edililson David
	 */
	public static void main(String[] args) {
		Util.initDesenv();
		while (true) {
			System.out.println(" Escolha uma opção");
			System.out.println(" 1 - Acessar sua conta");
			System.out.println(" 2 - Criar uma conta");
			int opcao;
			opcao = Util.scan.nextInt();

			UtilView.limpaTela();

			switch (opcao) {
			case 1:
				Caixa.getInstance().acessarSistema();
				break;
			case 2:
				cadastraConta();
				break;
			default:
				System.out.println("Opção invalida");
			}
		}
	}

	private static void cadastraConta() {
		Conta conta = TelaCadastraConta.preencheDadosConta();
		if(conta != null) {
			int numeroConta = ContaDAO.getInstance().criar(conta);
			TelaCadastraConta.sucesso(numeroConta);
		} else {
			//TelaCadastraConta.erro();
		}
	}
}