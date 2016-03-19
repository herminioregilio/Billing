package hermes.billing.financeiro.faturamento;

import java.util.ArrayList;
import java.util.List;

import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

import hermes.billing.financeiro.lancamento.Lancamento;

public class FaturamentoExtrato {

	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private MonetaryAmount valorAReceber;
	
	public FaturamentoExtrato(List<Lancamento> lancamentos) {	
		valorAReceber = Money.of(0, "BRL");
		for (Lancamento lancamento : lancamentos) 
			addLancamento(lancamento);
	}

	public void addLancamento(Lancamento lancamento) {
		lancamentos.add(lancamento);
		setValorAReceber(getValorAReceber().add(lancamento.getValor()));
	}

	public void removeLancamento(Lancamento lancamento) {
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

}
