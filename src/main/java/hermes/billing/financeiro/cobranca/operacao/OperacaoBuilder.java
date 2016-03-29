package hermes.billing.financeiro.cobranca.operacao;

import hermes.billing.financeiro.cobranca.MeioDeCobranca;
import hermes.billing.financeiro.cobranca.gateway.GatewayFactory;

public abstract class OperacaoBuilder {
	
	private MeioDeCobranca meioDeCobranca;
	private GatewayFactory gatewayfactory = new GatewayFactory();

	public final Operacao build(){
		Transacao transacao = buildTransacao();
		return buildOperacao(transacao);
	}

	private Transacao buildTransacao() {
		Transacao transacao = new Transacao();
		transacao.setMeioDeCobranca(getMeioDeCobranca());
		return transacao;
	}
	
	private Operacao buildOperacao(Transacao transacao) {
		Operacao operacao = internalOperacaoBuild();
		operacao.setTransacao(transacao);
		operacao.setGateway(getGatewayfactory().newInstance());
		return operacao;
	}
	
	protected abstract Operacao internalOperacaoBuild();
	
	private MeioDeCobranca getMeioDeCobranca() {
		return meioDeCobranca;
	}
	
	public void setMeioDeCobranca(MeioDeCobranca meioDeCobranca) {
		this.meioDeCobranca = meioDeCobranca; 
	}

	private GatewayFactory getGatewayfactory() {
		return gatewayfactory;
	}

	public void setGatewayfactory(GatewayFactory gatewayfactory) {
		this.gatewayfactory = gatewayfactory;
	}

}
