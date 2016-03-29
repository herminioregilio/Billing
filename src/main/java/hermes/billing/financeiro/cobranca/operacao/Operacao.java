package hermes.billing.financeiro.cobranca.operacao;

import hermes.billing.financeiro.cobranca.gateway.Gateway;

public abstract class Operacao {
	private Transacao transacao;
	private Gateway gateway;
	
	public abstract void envia();
	
	public abstract void recebe();
	
	public Transacao getTransacao() {
		return transacao;
	}

	protected void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}

	public Gateway getGateway() {
		return gateway;
	}

	protected void setGateway(Gateway gateway) {
		this.gateway = gateway;
	}
}
