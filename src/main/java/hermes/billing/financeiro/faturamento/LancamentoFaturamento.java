package hermes.billing.financeiro.faturamento;

import hermes.billing.financeiro.lancamento.Lancamento;

public class LancamentoFaturamento extends Lancamento {
	private FaturavelItem faturavel;

	public FaturavelItem getFaturavel() {
		return faturavel;
	}

	public void setFaturavel(FaturavelItem faturavel) {
		this.faturavel = faturavel;
	}
}