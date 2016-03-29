package hermes.billing.financeiro.cobranca;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import hermes.billing.financeiro.cobranca.operacao.Cobranca;
import hermes.billing.financeiro.cobranca.operacao.Operacao;
import hermes.billing.financeiro.cobranca.operacao.OperacaoBuilder;

@RunWith(MockitoJUnitRunner.class)
public class OperacaoBuilderTest {
	
	private class OperacaoBuilderImpl extends OperacaoBuilder{

		@Override
		protected Operacao internalOperacaoBuild() {
			return new Cobranca() {
			};
		}
		
	}
	
	OperacaoBuilderImpl subject = new OperacaoBuilderImpl();
	@Mock private MeioDeCobranca meioDeCobranca;
	
	@Test
	public void build(){
		subject.setMeioDeCobranca(meioDeCobranca);
		Operacao operacao = subject.build();
		assertNotNull("Transação", operacao.getTransacao());
		assertNotNull("Gateway", operacao.getGateway());
		assertEquals("Meio de cobrança", meioDeCobranca, operacao.getTransacao().getMeioDeCobranca());
	}
}
