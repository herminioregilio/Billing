package hermes.billing.financeiro.lancamento;

import javax.money.MonetaryAmount;

public abstract class Lancamento {
	private MonetaryAmount valor;

	public MonetaryAmount getValor() {
		return valor;
	}

	public void setValor(MonetaryAmount valor) {
		this.valor = valor;
	}
}
