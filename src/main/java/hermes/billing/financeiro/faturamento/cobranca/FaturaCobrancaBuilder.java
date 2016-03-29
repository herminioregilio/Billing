package hermes.billing.financeiro.faturamento.cobranca;

import hermes.billing.financeiro.cobranca.operacao.Operacao;
import hermes.billing.financeiro.cobranca.operacao.OperacaoBuilder;
import hermes.billing.financeiro.faturamento.Faturamento;

public class FaturaCobrancaBuilder extends OperacaoBuilder {
	
	private Faturamento faturamento;
	@Override
	protected Operacao internalOperacaoBuild() {
		FaturaCobranca faturaCobranca = new FaturaCobranca();
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
