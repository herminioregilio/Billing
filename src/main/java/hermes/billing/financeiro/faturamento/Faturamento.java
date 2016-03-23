package hermes.billing.financeiro.faturamento;

import java.util.ArrayList;
import java.util.List;

import hermes.billing.financeiro.lancamento.Lancamento;

public class Faturamento {
	private static final String NÃO_É_POSSÍVEL_EXECUTAR_UM_FATURAMENTO_MAIS_DE_UMA_VEZ = "Não é possível executar um Faturamento mais de uma vez.";
	private Faturavel faturavel;
	private Fatura fatura;
	private boolean isExecutado;
	
	public void executa(Faturavel faturavel) {
		validaExecucao();
		setFaturavel(faturavel);
		setExecutado();
		
		geraFatura(geraLancamentos());
	}

	private List<Lancamento> geraLancamentos() {
		List<Lancamento> lancamentos = new ArrayList<Lancamento>();
		for (FaturavelItem faturavel : getFaturavel().getItensFaturaveis()) {
			LancamentoFaturamento lancamento = new LancamentoFaturamento();
			lancamento.setFaturavel(faturavel);
			lancamento.setValor(faturavel.getValorFaturamento());
			lancamentos.add(lancamento);
		}
		return lancamentos;
	}
	
	private void geraFatura(List<Lancamento> lancamentos) {
		if(lancamentos.isEmpty())
			return;
		setFatura(new Fatura(lancamentos));
		getFatura().setContaFinanceira(getFaturavel().getContaFinanceira());
	}

	private void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}

	private void validaExecucao() {
		if(isExecutado())
			throw new RuntimeException(NÃO_É_POSSÍVEL_EXECUTAR_UM_FATURAMENTO_MAIS_DE_UMA_VEZ);
	}

	private boolean isExecutado() {
		return isExecutado;
	}

	private void setExecutado() {
		isExecutado = true;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public Faturavel getFaturavel() {
		return faturavel;
	}

	private void setFaturavel(Faturavel faturavel) {
		this.faturavel = faturavel;
	}
}