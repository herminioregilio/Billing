package hermes.billing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import hermes.billing.core.BillingCoreTestesUnitariosSuite;
import hermes.billing.financeiro.arrecadacao.ArrecadacaoTestesUnitariosSuite;
import hermes.billing.financeiro.cobranca.CobrancaTestesUnitariosSuite;
import hermes.billing.financeiro.faturamento.FaturamentoTestesUnitariosSuite;

@RunWith(Suite.class)
@SuiteClasses({
	BillingCoreTestesUnitariosSuite.class, 
	FaturamentoTestesUnitariosSuite.class,
	ArrecadacaoTestesUnitariosSuite.class,
	CobrancaTestesUnitariosSuite.class})
public class TestesUnitariosSuite {

}
