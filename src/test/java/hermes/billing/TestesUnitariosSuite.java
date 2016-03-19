package hermes.billing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import hermes.billing.core.BillingCoreTestesUnitariosSuite;
import hermes.billing.financeiro.faturamento.FaturamentoTestesUnitariosSuite;

@RunWith(Suite.class)
@SuiteClasses({
	BillingCoreTestesUnitariosSuite.class, 
	FaturamentoTestesUnitariosSuite.class})
public class TestesUnitariosSuite {

}
