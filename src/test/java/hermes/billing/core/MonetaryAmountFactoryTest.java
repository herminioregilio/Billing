package hermes.billing.core;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import javax.money.MonetaryAmount;
import javax.money.MonetaryCurrencies;

import org.junit.Test;

public class MonetaryAmountFactoryTest {

	private static final String CURRENCY_US = "USD";

	@Test
	public void getMonetaryAmount_setCurrency() {
		MonetaryAmount dinheiro = new MonetaryAmountFactory().setCurrency(MonetaryCurrencies.getCurrency(Locale.US))
				.getMonetaryAmount(1);

		assertNotNull(dinheiro);
		assertEquals(CURRENCY_US, dinheiro.getCurrency().toString());
		assertEquals(1, dinheiro.getNumber().intValue());
	}
	
}
