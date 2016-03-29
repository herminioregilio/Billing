package hermes.billing.financeiro.faturamento.cobranca;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import hermes.billing.financeiro.faturamento.Fatura;
import hermes.billing.financeiro.faturamento.Faturamento;

@RunWith(MockitoJUnitRunner.class)
public class FaturaCobrancaBuilderTest {

	private FaturaCobrancaBuilder subject = new FaturaCobrancaBuilder();
	@Mock private Faturamento faturamento;
	@Mock private Fatura fatura;
	
	@Before
	public void setup() {
		subject.setFaturamento(faturamento);
	}
	
	@Test
	public void build() {
		when(faturamento.getFatura()).thenReturn(fatura);

		FaturaCobranca faturaCobranca = (FaturaCobranca) subject.build();
		assertNotNull(faturaCobranca);
		
		assertEquals("Fatura", fatura, faturaCobranca.getFatura());
	}

}
