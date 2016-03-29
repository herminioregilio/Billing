package hermes.billing.financeiro.faturamento.cobranca;

import hermes.billing.financeiro.cobranca.operacao.Cobranca;
import hermes.billing.financeiro.faturamento.Fatura;

public class FaturaCobranca extends Cobranca {
	
	private Fatura fatura;

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}

}
