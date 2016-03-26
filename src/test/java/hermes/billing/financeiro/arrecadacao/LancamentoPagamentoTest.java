package hermes.billing.financeiro.arrecadacao;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import hermes.billing.core.MonetaryAmountFactory;

@RunWith(MockitoJUnitRunner.class)
public class LancamentoPagamentoTest {

	LancamentoPagamento subject;
	private MonetaryAmountFactory monetary = new MonetaryAmountFactory();
	@Rule public ExpectedException exception = ExpectedException.none();	
	
	@Test
	public void naoCriaLancamentoPagamentoValorPositivo() throws RuntimeException {
		exception.expect(RuntimeException.class);
		exception.expectMessage(LancamentoPagamento.NÃO_É_POSSÍVEL_CRIAR_UM_LANÇAMENTO_DE_PAGAMENTO_COM_VALOR_POSITIVO);

		subject = new LancamentoPagamento();
		subject.setValor(monetary.getMonetaryAmount(1));
	}

}
