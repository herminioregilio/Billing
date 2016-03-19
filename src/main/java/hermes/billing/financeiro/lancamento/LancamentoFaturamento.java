package hermes.billing.financeiro.lancamento;

public class LancamentoFaturamento extends Lancamento {
	private Faturavel faturavel;

	public Faturavel getFaturavel() {
		return faturavel;
	}

	public void setFaturavel(Faturavel faturavel) {
		this.faturavel = faturavel;
	}
}