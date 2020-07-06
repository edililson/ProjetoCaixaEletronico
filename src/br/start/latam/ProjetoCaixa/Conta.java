package br.start.latam.ProjetoCaixa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import br.start.latam.ProjetoCaixa.DAO.ContaDAO;

/**
 * @author Edililson David
 */
public class Conta {
	@Expose
	private int numeroConta;
	@Expose
	private int senha;
	@Expose
	private String cpf;
	@Expose
	private String nome;
	@Expose
	private String dtNascimento;
	@Expose
	private BigDecimal limiteCheque;
	@Expose
	private BigDecimal saldo;

	private ArrayList<String> camposInvalidos = new ArrayList<>();

	public Conta() {
	}

	public Conta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public static String toJson(Conta conta) {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(conta, Conta.class);
	}
	
	public static Conta fromJson(String contaJson) {
		Gson gson = new Gson();
		return gson.fromJson(contaJson, Conta.class);
		 
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public void setSenha(int senha) {
		if (!senhaCom6Numeros(senha)) {
			camposInvalidos.add("SENHA");
		}
		this.senha = senha;
	}

	public void setCpf(String cpf) {
		// TODO validar cpf
		//camposInvalidos.add("CPF");
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		if (contemNumeros(nome)) {
			camposInvalidos.add("NOME");
		}

		this.nome = nome;
	}

	public void setDtNascimento(String dtNascimento) {
		// TODO validar data de nascimento só para maiores de 18 anos
		// camposInvalidos.add("DATA_NASCIMENTO");
		this.dtNascimento = dtNascimento;
	}

	public void setLimiteCheque(BigDecimal limiteCheque) {
		this.limiteCheque = limiteCheque;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public void atualizaSaldo(BigDecimal valor) {
		saldo = saldo == null ? BigDecimal.ZERO : saldo;
		saldo = saldo.add(valor);

		ContaDAO.getInstance().atualiza(this);
	}
	
	public void gravarExtrato(){
		//TODO criar um arquivo com o numero da conta
	}

	public boolean valida() {
		return camposInvalidos.isEmpty();
	}

	public List<String> camposInvalidos() {
		return camposInvalidos;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public int getSenha() {
		return senha;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public BigDecimal getLimiteCheque() {
		return limiteCheque;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}
	
	@Override
	public String toString() {
		return "Conta [numeroConta=" + numeroConta + ", senha=" + senha + ", cpf=" + cpf + ", nome=" + nome
				+ ", dtNascimento=" + dtNascimento + ", limiteCheque=" + limiteCheque + ", saldo=" + saldo
				+ ", camposInvalidos=" + camposInvalidos + "]";
	}

	private boolean senhaCom6Numeros(int senha) {
		boolean senhaTem6Numero = (senha / 100000 >= 1 && senha / 100000 < 10);
		return senhaTem6Numero;
	}

	private boolean contemNumeros(String nome) {
		return nome.matches(".*\\d.*");
	}

	public String getExtrato() {
		// TODO retornar o extrato da conta
		return null;
	}

	public String getEmprestimo() {
		// TODO fazer o sistema para retornar o valor maximo do emprestimo
		return null;
	}
}
