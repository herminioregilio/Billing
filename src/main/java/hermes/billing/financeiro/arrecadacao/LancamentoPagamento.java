package hermes.billing.financeiro.arrecadacao;

import javax.money.MonetaryAmount;

import hermes.billing.financeiro.lancamento.Lancamento;

public class LancamentoPagamento extends Lancamento {

	static final String NÃO_É_POSSÍVEL_CRIAR_UM_LANÇAMENTO_DE_PAGAMENTO_COM_VALOR_POSITIVO = "Não é possível criar um lançamento de pagamento com valor positivo.";

	@Override
	protected void validaValor(MonetaryAmount valor) {
		super.validaValor(valor);
		if(valor.isPositive())
			throw new RuntimeException(NÃO_É_POSSÍVEL_CRIAR_UM_LANÇAMENTO_DE_PAGAMENTO_COM_VALOR_POSITIVO);
	}
}
