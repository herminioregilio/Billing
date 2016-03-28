package hermes.billing.financeiro.faturamento;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import hermes.billing.core.MonetaryAmountFactory;
import hermes.billing.financeiro.ContaFinanceira;
import hermes.billing.financeiro.lancamento.Lancamento;
import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class FaturamentoTest {

	private Faturamento subject = new Faturamento();
	private MonetaryAmountFactory monetary = new MonetaryAmountFactory();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();	
	
	@Mock private FaturavelItem itemFaturavel1;
	@Mock private FaturavelItem itemFaturavel2;
	@Mock private Faturavel faturavel;
	@Mock private ContaFinanceira contaFinanceira;
	
	@Test
	public void executa_paraFaturavelComDoisItens_geraFatura() {
		executaFaturamentoParaFaturavelComDoisItens();
		
		assertNotNull("fatura", subject.getFatura());
		assertEquals("conta financeira", contaFinanceira, subject.getFatura().getContaFinanceira());
		
		List<Lancamento> lancamentos = subject.getFatura().getLancamentos();
		assertEquals("lançamentos", 2, lancamentos.size());
		
		LancamentoFaturamento lancamento1 = (LancamentoFaturamento) lancamentos.get(0);
		LancamentoFaturamento lancamento2 = (LancamentoFaturamento) lancamentos.get(1);
		
		assertEquals("Item Faturavel 1", itemFaturavel1,  lancamento1.getFaturavel());
		assertEquals("Item Faturavel 2", itemFaturavel2,  lancamento2.getFaturavel());
		
		assertEquals("Valor 1", 1,  lancamento1.getValor().getNumber().longValue());
		assertEquals("Valor 2", 2,  lancamento2.getValor().getNumber().longValue());
	}

	private void executaFaturamentoParaFaturavelComDoisItens() {
		when(itemFaturavel1.getValorFaturamento()).thenReturn(monetary.getMonetaryAmount(1));
		when(itemFaturavel2.getValorFaturamento()).thenReturn(monetary.getMonetaryAmount(2));
		when(faturavel.getItensFaturaveis()).thenReturn(Arrays.asList(itemFaturavel1, itemFaturavel2));
		when(faturavel.getContaFinanceira()).thenReturn(contaFinanceira);

		subject.executa(faturavel);
	}

	@Test
	public void executa_paraFaturavel_NaoGeraFatura() {
		subject.executa(faturavel);
		Assert.assertNull("extrato", subject.getFatura());
	}

	@Test
	public void naoExecutaDuasVezes() throws RuntimeException{
		exception.expect(RuntimeException.class);
		exception.expectMessage("Não é possível executar um Faturamento mais de uma vez.");

		subject.executa(faturavel);
		subject.executa(faturavel);
	}
	
}
