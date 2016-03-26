package hermes.billing.financeiro.cobranca;

public abstract class CobrancaFactory {
	
	protected abstract Cobranca internalCobra();
	
	public final void cobra(){
		internalCobra();
	}
}
