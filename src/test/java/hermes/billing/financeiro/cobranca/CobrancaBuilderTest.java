package hermes.billing.financeiro.cobranca;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class CobrancaBuilderTest {
	
	private class CobrancaBuilderImpl extends CobrancaBuilder{

		@Override
		protected Cobranca internalCobra() {
			return new Cobranca() {
			};
		}
		
	}
	
	CobrancaBuilderImpl subject = new CobrancaBuilderImpl();
	@Mock private MeioDeCobranca meioDeCobranca;
	
	@Test
	public void cobra(){
		subject.setMeioDeCobranca(meioDeCobranca);
		Cobranca cobranca = subject.cobra();
		Assert.assertEquals("Meio de cobrança", meioDeCobranca, cobranca.getMeioDeCobranca());
	}
}
