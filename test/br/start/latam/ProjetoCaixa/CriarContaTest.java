package br.start.latam.ProjetoCaixa;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.start.latam.ProjetoCaixa.DAO.ContaDAO;

public class CriarContaTest {

	@Test
	public void criarContaComSucesso() {
		Conta c = contaGenerica();
		//Conta.cadastraConta();
	}

	@Test
	public void confirmacaoDeSenhaErrada() {
		Assert.assertTrue(false);
	}

	@Test
	public void cpfInvalido() {
		Assert.assertTrue(false);
	}

	@Test
	public void menorQue18Anos() {
		Assert.assertTrue(false);
	}
	
	private Conta contaGenerica() {
		Conta c = new Conta();
		c.setCpf("01234567890");
		c.setDtNascimento("05/07/2020");
		c.setLimiteCheque(BigDecimal.ZERO);
		c.setNome("Teste da Silva");
		c.setSaldo(BigDecimal.TEN);
		c.setSenha(123456);
		return c;
	}
	
}
