package hermes.billing.financeiro.faturamento;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import hermes.billing.core.MonetaryAmountFactory;
import hermes.billing.financeiro.lancamento.Lancamento;
import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class FaturamentoExtratoTest {

	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private MonetaryAmountFactory monetary = new MonetaryAmountFactory();
	
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
		FaturamentoExtrato subject = faturamentoExtrato1Add2();

		subject.removeLancamento(lancamento1);
		Assert.assertEquals("Valor", 2, subject.getValorAReceber().getNumber().longValue());
	}

	private FaturamentoExtrato faturamentoExtratoDe1() {
		FaturamentoExtrato subject = new FaturamentoExtrato(lancamentos);
		Assert.assertEquals("Valor", 1, subject.getValorAReceber().getNumber().longValue());
		return subject;
	}
	
	private FaturamentoExtrato faturamentoExtrato1Add2() {
		FaturamentoExtrato subject = faturamentoExtratoDe1();
		
		subject.addLancamento(lancamento2);
		Assert.assertEquals("Valor", 3, subject.getValorAReceber().getNumber().longValue());
		return subject;
	}

}
