package hermes.billing.faturamento;

import java.util.ArrayList;
import java.util.List;

import hermes.billing.financeiro.lancamento.Faturavel;
import hermes.billing.financeiro.lancamento.Lancamento;
import hermes.billing.financeiro.lancamento.LancamentoFaturamento;

public class Faturamento {
	private static final String NÃO_É_POSSÍVEL_EXECUTAR_UM_FATURAMENTO_MAIS_DE_UMA_VEZ = "Não é possível executar um Faturamento mais de uma vez.";
	List<Faturavel> faturaveis = new ArrayList<Faturavel>();
	private FaturamentoExtrato faturamentoExtrato;
	private boolean isExecutado;
	
	public void executa() {
		validaExecucao();
		setExecutado();
		
		List<Lancamento> lancamentos = geraLancamentos();
		if(lancamentos.isEmpty())
			return;
		faturamentoExtrato = new FaturamentoExtrato(lancamentos);
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
		for (Faturavel faturavel : faturaveis) {
			LancamentoFaturamento lancamento = new LancamentoFaturamento();
			lancamento.setFaturavel(faturavel);
			lancamento.setValor(faturavel.getValorFaturamento());
			lancamentos.add(lancamento);
		}
		return lancamentos;
	}

	void addFaturaveis(Faturavel faturavel) {
		faturaveis.add(faturavel);
	}

	public FaturamentoExtrato getFaturamentoExtrato() {
		return faturamentoExtrato;
	}

}