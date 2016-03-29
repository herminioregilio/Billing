package hermes.billing.financeiro.cobranca.operacao;

import hermes.billing.financeiro.cobranca.MeioDeCobranca;

public class Transacao {
	private MeioDeCobranca meioDeCobranca;
	
	public MeioDeCobranca getMeioDeCobranca() {
		return meioDeCobranca;
	}
	protected void setMeioDeCobranca(MeioDeCobranca meioDeCobranca) {
		this.meioDeCobranca = meioDeCobranca;
	}

}
