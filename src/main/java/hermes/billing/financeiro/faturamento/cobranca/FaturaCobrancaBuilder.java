package hermes.billing.financeiro.faturamento.cobranca;

import hermes.billing.financeiro.cobranca.Cobranca;
import hermes.billing.financeiro.cobranca.CobrancaBuilder;
import hermes.billing.financeiro.faturamento.Faturamento;

public class FaturaCobrancaBuilder extends CobrancaBuilder {
	
	private Faturamento faturamento;
	@Override
	protected Cobranca internalCobra() {
		FaturaCobranca faturaCobranca;
		faturaCobranca = new FaturaCobranca();
		faturaCobranca.setFatura(getFaturamento().getFatura());
		return faturaCobranca;
	}

	protected Faturamento getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(Faturamento faturamento) {
		this.faturamento = faturamento;
	}

}
