package hermes.billing.financeiro.faturamento.cobranca;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import hermes.billing.financeiro.cobranca.MeioDeCobranca;
import hermes.billing.financeiro.faturamento.Fatura;
import hermes.billing.financeiro.faturamento.Faturamento;

@RunWith(MockitoJUnitRunner.class)
public class FaturamentoCobrancaFactoryTest {

	private FaturamentoCobrancaFactory subject = new FaturamentoCobrancaFactory();
	@Mock private Faturamento faturamento;
	@Mock private MeioDeCobranca meioDeCobranca;
	@Mock private Fatura fatura;
	
	@Before
	public void setup() {
		subject.setFaturamento(faturamento);
	}
	
	@Test
	public void cobra() {
		when(faturamento.getMeioDeCobranca()).thenReturn(meioDeCobranca);
		when(faturamento.getFatura()).thenReturn(fatura);

		FaturaCobranca faturaCobranca = (FaturaCobranca) subject.internalCobra();
		assertNotNull(faturaCobranca);
		
		assertEquals("Fatura", fatura, faturaCobranca.getFatura());
		assertEquals("Meio de cobrança", meioDeCobranca, faturaCobranca.getMeioDeCobranca());
	}

}
