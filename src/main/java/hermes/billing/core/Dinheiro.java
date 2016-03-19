package hermes.billing.core;

import java.text.DecimalFormat;

public class Dinheiro {
	private final double valor;

	public Dinheiro(double valor) {
		this.valor = valor;
	}
	
	double getValor() {
		return valor;
	}
	
	public Dinheiro subtrai(Dinheiro dinheiro) {
		return new Dinheiro(valor - dinheiro.getValor());
	}

	public Dinheiro soma (Dinheiro dinheiro) {
		return new Dinheiro(valor + dinheiro.getValor());
	}
	
	@Override
	public String toString() {
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		return decimalFormat.format(getValor());
	}
}