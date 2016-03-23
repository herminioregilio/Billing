package hermes.billing.financeiro.faturamento;

import java.util.List;

import hermes.billing.financeiro.ContaFinanceira;

public interface Faturavel {
	public List<FaturavelItem> getItensFaturaveis();
	public ContaFinanceira  getContaFinanceira();
}
