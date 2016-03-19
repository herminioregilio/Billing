package hermes.billing.core;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;
import javax.money.MonetaryAmounts;
import javax.money.MonetaryCurrencies;

public class MonetaryAmountFactory {
	private static final String BRL = "BRL";
	private CurrencyUnit currency;

	public MonetaryAmountFactory(){
		setCurrency(MonetaryCurrencies.getCurrency(BRL));
	}
	
	public MonetaryAmount getMonetaryAmount(Number valor) {
		return MonetaryAmounts.getDefaultAmountFactory()
				.setCurrency(getCurrency())
				.setNumber(valor)
				.create();
	}

	private CurrencyUnit getCurrency() {
		return currency;
	}

	public MonetaryAmountFactory setCurrency(CurrencyUnit currency) {
		this.currency = currency;
		return this;
	}
}
