package br.start.latam.ProjetoCaixa.VIEW;

import br.start.latam.ProjetoCaixa.Conta;
import br.start.latam.ProjetoCaixa.Util;
import br.start.latam.ProjetoCaixa.DAO.ContaDAO;
import br.start.latam.ProjetoCaixa.VIEW.idioma.MSG;
import br.start.latam.ProjetoCaixa.VIEW.idioma.MSG_ERROR;

public class TelaCadastraConta extends Tela{

	public static Conta preencheDadosConta() {

		System.out.println(MSG.BEM_VINDO);
		System.out.println(MSG.CRIAR_CONTA);
		System.out.println(MSG.SAIR);
		String opcao = Util.scan.next();

		if (opcao.equalsIgnoreCase("SAIR")) {
			return null;
		}

		Conta conta = new Conta();
		System.out.println(MSG.CPF);
		conta.setCpf(Util.scan.next());
		System.out.println(MSG.DT_NASCIMENTO);
		conta.setDtNascimento(Util.scan.next());
		System.out.println(MSG.NOME);
		conta.setNome(Util.scan.next());
		UtilView.limpaTela();
		if(!confirmaDados(conta)) {
			System.out.println(MSG.VOLTA_TELA_CADASTRO);
			return TelaCadastraConta.preencheDadosConta();
		}
		
		conta.setSenha(cadastrarSenha());
		
		//aqui temos duas estratégias, estou usando um booleano mas poderiamos lançar um erro ContaInvalida
		//Lançar o erro é mais elegante, num próximo commit podemos alterar a estratégia para você ver as duas
		if(!conta.valida()) {
			String mensagemDadosInvalidos = "";
			for (String campo : conta.camposInvalidos()) {
				//mensagemDadosInvalidos += MSG_ERROR.get(campo) + "\n";
			}
			UtilView.limpaTela();
			System.out.println(mensagemDadosInvalidos);
			System.out.println(MSG.VOLTA_TELA_CADASTRO);
			return TelaCadastraConta.preencheDadosConta();
		}
		
		return conta;
		
	}

	private static boolean confirmaDados(Conta conta) {
		System.out.println(MSG.CPF);
		System.out.println(" - :" + conta.getCpf());
		System.out.println(MSG.DT_NASCIMENTO);
		System.out.println(" - :" + conta.getDtNascimento());
		System.out.println(MSG.NOME);
		System.out.println(" - :" + conta.getNome());
		System.out.println(MSG.CONFIRMAR);
		String opcao = Util.scan.next();
		boolean confirma = opcao.equalsIgnoreCase("S");
		return confirma;
	}

	private static int cadastrarSenha() {
		boolean senhaCadastraComSucesso = false;
		int senhaDigitada = 0;
		int confirmaSenha;

		while (!senhaCadastraComSucesso) {
			System.out.println("Digite uma senha com 6 numeros:");
			senhaDigitada = Util.scan.nextInt();
			while (!senhaCom6Numeros(senhaDigitada)) {
				System.out.println("Senha invalida");
				System.out.println("digite uma senha com 6 numeros:");
				senhaDigitada = Util.scan.nextInt();
			}

			System.out.println("confirme sua senha");
			confirmaSenha = Util.scan.nextInt();
			if (senhaDigitada == confirmaSenha) {
				senhaCadastraComSucesso = true;
			} else {
				UtilView.limpaTela();
				System.out.println("senhas não conferem!");
			}
		}
		return senhaDigitada;
	}

	private static boolean senhaCom6Numeros(int senha) {
		boolean senhaTem6Numero = (senha / 100000 >= 1 && senha / 100000 < 10);
		return senhaTem6Numero;
	}

	public static void sucesso(int numeroConta) {
		System.out.println(MSG.SUCESSO_CADASTRO_CONTA);
		System.out.println(MSG.NUM_CONTA + numeroConta);
	}
}
