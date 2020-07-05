package ProjetoCaixa;

import java.math.BigDecimal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Conta {
	private int conta;
	private int senha;
	private BigDecimal limiteCheque;
	private String cpf;
	private String nome;
	private String dtNascimento;
	private int numConta;
	private float saldo;

	public static Conta formJson(String json) {
		Gson gson = new GsonBuilder().create();
		return gson.fromJson(json, Conta.class);
	}
	
	public static String toJson(Conta conta) {
		Gson gson = new Gson();
		return gson.toJson(conta);
	}
	
	public Conta(int numConta, String nome, String dtNascimento) {
		super();
		this.numConta = numConta;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.setSaldo(0f);
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
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
	
}
