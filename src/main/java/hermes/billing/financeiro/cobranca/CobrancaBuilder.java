package hermes.billing.financeiro.cobranca;

public abstract class CobrancaBuilder {
	
	public MeioDeCobranca meioDeCobranca;
	
	protected MeioDeCobranca getMeioDeCobranca() {
		return meioDeCobranca;
	}
	
	public void setMeioDeCobranca(MeioDeCobranca meioDeCobranca) {
		this.meioDeCobranca = meioDeCobranca; 
	}

	public final Cobranca cobra(){
		Cobranca cobranca = internalCobra();
		cobranca.setMeioDeCobranca(getMeioDeCobranca());
		return cobranca;
	}
	
	protected abstract Cobranca internalCobra();
}
