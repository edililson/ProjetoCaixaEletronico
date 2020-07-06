package br.start.latam.ProjetoCaixa.DAO;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import br.start.latam.ProjetoCaixa.Conta;
import br.start.latam.ProjetoCaixa.Util;

public class ContaDAOTest{

	Conta c;
	
	@BeforeClass
	public void initClass() {
		Util.initTest();
	}
	
	@Before
	public void init() {
		c = contaGenerica();
	}
	
	@Test
	public void criar() {
		ContaDAO.getInstance().criar(c);
		Assert.assertTrue(false);
	}
	
	@Test
	public void atualiza() {
		ContaDAO.getInstance().atualiza(c);
		Assert.assertTrue(false);
	}

	@Test
	public void busca() {
		ContaDAO.getInstance().busca(c.getNumeroConta());
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
