package hermes.billing.financeiro.cobranca;

public abstract class Cobranca {

	private MeioDeCobranca meioDeCobranca;

	public MeioDeCobranca getMeioDeCobranca() {
		return meioDeCobranca;
	}

	public void setMeioDeCobranca(MeioDeCobranca meioDeCobranca) {
		this.meioDeCobranca = meioDeCobranca;
	}

	public void envia() {
		
	}
}
