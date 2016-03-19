package hermes.billing.core;

import org.junit.Test;

import hermes.billing.core.Dinheiro;
import junit.framework.Assert;

public class DinheiroTest {

	@Test
	public void arredondaParaBaixo() {
		Dinheiro subject = new Dinheiro(1.104);
		Assert.assertEquals("valor", 1.10,  subject.getValor());
		subject = new Dinheiro(1.105);
		Assert.assertEquals("valor", 1.10,  subject.getValor());
	}

	@Test
	public void arredondaParaCima() {
		Dinheiro subject = new Dinheiro(1.106);
		Assert.assertEquals("valor", 1.11,  subject.getValor());
	}

	@Test
	public void duasCasasDepoisDaVirgula() {
		Dinheiro subject = new Dinheiro(1);
		Assert.assertEquals("valor", 1.00,  subject.getValor());

		subject = new Dinheiro(1.1);
		Assert.assertEquals("valor", 1.10,  subject.getValor());

		subject = new Dinheiro(0.1);
		Assert.assertEquals("valor", 0.10,  subject.getValor());

		subject = new Dinheiro(0.01);
		Assert.assertEquals("valor", 0.01,  subject.getValor());
	}
	
	@Test
	public void test_toString(){
		Dinheiro subject = new Dinheiro(1);
		Assert.assertEquals("valor", "1,00",  subject.toString());
		
		subject = new Dinheiro(10000000.2);
		Assert.assertEquals("valor", "10000000,20",  subject.toString());
	}
	
	@Test
	public void soma() {
		Assert.fail("testar soma");
	}

	@Test
	public void subtrai() {
		Assert.fail("testar subtracao");
	}
	

}
