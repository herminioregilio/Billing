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
		
		List<Lancamento> lancamentos = geraLancamentos();
		if(lancamentos.isEmpty())
			return;
		fatura = new Fatura(lancamentos);
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