package hermes.billing.financeiro.cobranca.operacao;

public abstract class Cobranca extends Operacao{

	public void envia(){
//		getGateway().enviaCobranca(this);
		throw new RuntimeException("não implementado");
	}
	
	public void recebe(){
		throw new RuntimeException("não implementado");
	}
		
}
