package hermes.billing.financeiro.faturamento.cobranca;

import hermes.billing.financeiro.cobranca.Cobranca;
import hermes.billing.financeiro.cobranca.CobrancaFactory;
import hermes.billing.financeiro.faturamento.Faturamento;

public class FaturamentoCobrancaFactory extends CobrancaFactory {
	
	private FaturaCobranca faturaCobranca;
	private Faturamento faturamento;
	
	public FaturamentoCobrancaFactory(Faturamento faturamento) {
		this.setFaturamento(faturamento);
	}
	
	public FaturamentoCobrancaFactory() {
	}

	@Override
	protected Cobranca internalCobra() {
		faturaCobranca = new FaturaCobranca();
		faturaCobranca.setFatura(getFaturamento().getFatura());
		faturaCobranca.setMeioDeCobranca(getFaturamento().getMeioDeCobranca());
		return faturaCobranca;
	}

	protected Faturamento getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(Faturamento faturamento) {
		this.faturamento = faturamento;
	}
}
