package hermes.billing.core;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import javax.money.MonetaryAmount;
import javax.money.MonetaryCurrencies;

import org.junit.Test;

import junit.framework.Assert;

public class MonetaryAmountTest {

	private static final String CURRENCY_CAD = "CAD";
	private static final String CURRENCY_US = "USD";

	@Test
	public void getMonetaryAmount_defaultLocale() {
		Locale anterior = Locale.getDefault();
		
		Locale.setDefault(Locale.CANADA);
		MonetaryAmount dinheiro = new MonetaryAmountFactory().getMonetaryAmount(1);
		
		assertNotNull(dinheiro);
		assertEquals(CURRENCY_CAD, dinheiro.getCurrency().toString());
		assertEquals(1, dinheiro.getNumber().intValue());
		
		Locale.setDefault(anterior);
	}
	
	@Test
	public void getMonetaryAmount_setLocale(){
		MonetaryAmount dinheiro = new MonetaryAmountFactory()
				.setCurrency(MonetaryCurrencies.getCurrency(Locale.US))
				.getMonetaryAmount(1);
				
		assertNotNull(dinheiro);
		assertEquals(CURRENCY_US, dinheiro.getCurrency().toString());
		assertEquals(1, dinheiro.getNumber().intValue());
	}
	
	@Test
	private void somaDolarComReal() {
		Assert.fail("testar");
	}

}
