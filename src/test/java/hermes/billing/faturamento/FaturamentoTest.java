package hermes.billing.faturamento;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import hermes.billing.financeiro.lancamento.Faturavel;
import hermes.billing.financeiro.lancamento.Lancamento;
import hermes.billing.financeiro.lancamento.LancamentoFaturamento;
import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class FaturamentoTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();	
	
	private Faturamento subject = new Faturamento();
	@Mock private Faturavel faturavel1;
	@Mock private Faturavel faturavel2;
	
	@Test
	public void executa_paraFaturaveis_geraFaturamentoExtrato() {
//		when(faturavel1.getValorFaturamento()).thenReturn(new Dinheiro(1));
//		when(faturavel2.getValorFaturamento()).thenReturn(new Dinheiro(2));
//		
		subject.addFaturaveis(faturavel1);
		subject.addFaturaveis(faturavel2);
		
		subject.executa();
		
		assertNotNull("extrato", subject.getFaturamentoExtrato());
		
		List<Lancamento> lancamentos = subject.getFaturamentoExtrato().getLancamentos();
		assertEquals("lançamentos", 2, lancamentos.size());
		
		LancamentoFaturamento lancamento1 = (LancamentoFaturamento) lancamentos.get(0);
		LancamentoFaturamento lancamento2 = (LancamentoFaturamento) lancamentos.get(1);
		
		assertEquals("Faturavel 1", faturavel1,  lancamento1.getFaturavel());
		assertEquals("Faturavel 2", faturavel2,  lancamento2.getFaturavel());
		
		assertEquals("Valor 1", "1,00",  lancamento1.getValor().toString());
		assertEquals("Valor 2", "2,00",  lancamento2.getValor().toString());
	}
	
	@Test
	public void executa_paraFaturaveis_NaoGeraFaturamentoExtrato() {
		subject.executa();
		Assert.assertNull("extrato", subject.getFaturamentoExtrato());
	}

	@Test
	public void naoExecutaDuasVezes() throws RuntimeException{
		exception.expect(RuntimeException.class);
		exception.expectMessage("Não é possível executar um Faturamento mais de uma vez.");

		subject.executa();
		subject.executa();
	}
	
}
