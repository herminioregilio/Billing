package hermes.billing.financeiro.faturamento;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import hermes.billing.core.MonetaryAmountFactory;
import hermes.billing.financeiro.lancamento.Lancamento;
import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class FaturaTest {

	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private MonetaryAmountFactory monetary = new MonetaryAmountFactory();
	
	@Rule public ExpectedException exception = ExpectedException.none();	
	@Mock private Lancamento lancamento1;
	@Mock private Lancamento lancamento2;
	
	@Before
	public void before() {		
		Mockito.when(lancamento1.getValor()).thenReturn(monetary.getMonetaryAmount(1));
		Mockito.when(lancamento2.getValor()).thenReturn(monetary.getMonetaryAmount(2));
		lancamentos.add(lancamento1);
	}
	
	@Test
	public void cria_atualizaValorAReceber() {
		faturamentoExtratoDe1();
	}

	@Test
	public void addLancamento_atualizaValorAReceber() {
		faturamentoExtrato1Add2();
	}

	@Test
	public void removeLancamento_atualizaValorAReceber() {
		Fatura subject = faturamentoExtrato1Add2();

		subject.removeLancamento(lancamento1);
		Assert.assertEquals("Valor", 2, subject.getValorAReceber().getNumber().longValue());
	}
	
	@Test
	public void addLancamentoValorNegativo_atualizaValorAReceber() {
		Fatura subject = faturamentoExtrato1Add2();
		Assert.assertEquals("Valor", 3, subject.getValorAReceber().getNumber().longValue());

		Lancamento lancamentoNegativo = Mockito.mock(Lancamento.class);
		Mockito.when(lancamentoNegativo .getValor()).thenReturn(monetary.getMonetaryAmount(-1));
		
		subject.addLancamento(lancamentoNegativo);
		Assert.assertEquals("Valor", 2, subject.getValorAReceber().getNumber().longValue());

		lancamentoNegativo = Mockito.mock(Lancamento.class);
		Mockito.when(lancamentoNegativo .getValor()).thenReturn(monetary.getMonetaryAmount(-2));
		
		subject.addLancamento(lancamentoNegativo);
		Assert.assertEquals("Valor", 0, subject.getValorAReceber().getNumber().longValue());
	}
	
	@Test
	public void addLancamentoValorNegativo_valorAReceberNegativo() throws RuntimeException {
		Fatura subject = faturamentoExtrato1Add2();
		Assert.assertEquals("Valor", 3, subject.getValorAReceber().getNumber().longValue());
		
		exception.expect(RuntimeException.class);
		exception.expectMessage(Fatura.MSG_ERRO_VALOR_A_RECEBER_NEGATIVO);
		
		Lancamento lancamentoNegativo = Mockito.mock(Lancamento.class);
		Mockito.when(lancamentoNegativo .getValor()).thenReturn(monetary.getMonetaryAmount(-4));
		
		subject.addLancamento(lancamentoNegativo);
	}
	
	private Fatura faturamentoExtratoDe1() {
		Fatura subject = new Fatura(lancamentos);
		Assert.assertEquals("Valor", 1, subject.getValorAReceber().getNumber().longValue());
		return subject;
	}
	
	private Fatura faturamentoExtrato1Add2() {
		Fatura subject = faturamentoExtratoDe1();
		
		subject.addLancamento(lancamento2);
		Assert.assertEquals("Valor", 3, subject.getValorAReceber().getNumber().longValue());
		return subject;
	}

}
