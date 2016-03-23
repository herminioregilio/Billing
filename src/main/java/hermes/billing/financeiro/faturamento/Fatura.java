package hermes.billing.financeiro.faturamento;

import java.util.ArrayList;
import java.util.List;

import javax.money.MonetaryAmount;

import hermes.billing.financeiro.ContaFinanceira;
import hermes.billing.financeiro.lancamento.Lancamento;

public class Fatura {

	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private MonetaryAmount valorAReceber;
	private ContaFinanceira contaFinanceira;
	
	public Fatura(List<Lancamento> lancamentos) {	
		for (Lancamento lancamento : lancamentos) 
			addLancamento(lancamento);
	}

	void addLancamento(Lancamento lancamento) {
		lancamentos.add(lancamento);
		addValorAReceber(lancamento);
	}

	private void addValorAReceber(Lancamento lancamento) {
		if(getValorAReceber() == null)
			setValorAReceber(lancamento.getValor());
		else
			setValorAReceber(lancamento.getValor().add(getValorAReceber()));
	}

	void removeLancamento(Lancamento lancamento) {
		lancamentos.remove(lancamento);
		setValorAReceber(getValorAReceber().subtract(lancamento.getValor()));
	}
	
	private void setValorAReceber(MonetaryAmount valor) {
		this.valorAReceber = valor;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public MonetaryAmount getValorAReceber() {
		return valorAReceber;
	}

	public ContaFinanceira getContaFinanceira() {
		return contaFinanceira;
	}

	void setContaFinanceira(ContaFinanceira contaFinanceira) {
		this.contaFinanceira = contaFinanceira;
	}

}
