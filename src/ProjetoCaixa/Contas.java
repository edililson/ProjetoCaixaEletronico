package ProjetoCaixa;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Edililson David
 */
public class Contas {
	private int conta;
	private int senha;
	private BigDecimal limiteCheque;
	private String cpf;
	private String nome;
	private String dtNascimento;
	private float saldo;

	public void CadastraConta() {
		Scanner scan = new Scanner(System.in);
		String arq = ".\\Arquivos\\text.txt";
		Contas c1 = new Contas();

		System.out.println("Bem vindo ao Banco do Start Latam!");
		System.out.println("Você está criando uma conta, digite qualquer coisa para continuar");
		System.out.println("ou se já tem um conta digite SAIR para voltar a tela inicial!");
		String opcao = scan.next();

		if (opcao == "SAIR" || opcao == "sair") {

		}

		System.out.println("informe seu cpf:");
		c1.setCpf(scan.next());
		// TODO validar cpf
		System.out.println("informe sua data de nascimento:");
		c1.setDtNascimento(scan.next());
		// TODO validar data de nascimento só para maiores de 18 anos
		System.out.println("informe seu nome:");
		c1.setNome(scan.next());
		// TODO Verificar se só tem letras
		// TODO repetir informações para confirmar se está ok
		c1.setSenha(CadastrarSenha());
		c1.setConta(NumeroDaConta());
		Gson gson = new GsonBuilder().create();
		String texto = gson.toJson(c1, Contas.class);
		ArquivoTxt.Write(arq, texto, true);
	}

	public void AcessarConta() {

	}

	public int CadastrarSenha() {
		Scanner scan = new Scanner(System.in);
		boolean senhaCadastraComSucesso = false;
		int senha = 0;
		int confirmaSenha;

		while (!senhaCadastraComSucesso) {
			System.out.println("Digite uma senha com 6 numeros:");
			senha = scan.nextInt();
			while (!senhaCom6Numeros(senha)) {
				System.out.println("Senha invalida");
				System.out.println("digite uma senha com 6 numeros:");
				senha = scan.nextInt();
			}

			System.out.println("confirme sua senha");
			confirmaSenha = scan.nextInt();
			if (senha == confirmaSenha) {
				senhaCadastraComSucesso = true;
			} else {
				for (int i = 0; i < 100; i++) {
					System.out.println();
				}
				System.out.println("senhas não conferem!");
			}
		}

		return senha;
	}

	public boolean senhaCom6Numeros(int senha) {
		boolean senhaTem6Numero = (senha / 100000 >= 1 && senha / 100000 < 10);
		return senhaTem6Numero;
	}

	public int NumeroDaConta(){
		Random random = new Random();        
        int numeroDaConta = random.nextInt(1000);
		return numeroDaConta;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public BigDecimal getLimiteCheque() {
		return limiteCheque;
	}

	public void setLimiteCheque(BigDecimal limiteCheque) {
		this.limiteCheque = limiteCheque;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

}
