package hermes.billing.core;

import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;
import javax.money.MonetaryAmounts;
import javax.money.MonetaryCurrencies;

public class MonetaryAmountFactory {
	private CurrencyUnit currency;

	public MonetaryAmountFactory(){
		setCurrency(MonetaryCurrencies.getCurrency(Locale.getDefault()));
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
