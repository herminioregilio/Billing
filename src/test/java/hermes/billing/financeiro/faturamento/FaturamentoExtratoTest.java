package hermes.billing.financeiro.faturamento;

import java.util.ArrayList;
import java.util.List;

import org.javamoney.moneta.Money;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import hermes.billing.financeiro.lancamento.Lancamento;
import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class FaturamentoExtratoTest {

	@Mock private Lancamento lancamento1;
	@Mock private Lancamento lancamento2;
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	
	@Before
	public void before() {		
		Mockito.when(lancamento1.getValor()).thenReturn(Money.of(1, "BRL"));
		Mockito.when(lancamento2.getValor()).thenReturn(Money.of(2, "BRL"));
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
