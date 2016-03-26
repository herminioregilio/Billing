package hermes.billing.financeiro.faturamento;

import java.util.List;

import hermes.billing.financeiro.ContaFinanceira;
import hermes.billing.financeiro.cobranca.MeioDeCobranca;

public interface Faturavel {
	public List<FaturavelItem> getItensFaturaveis();
	public ContaFinanceira  getContaFinanceira();
	public MeioDeCobranca getMeioDeCobranca();
}
