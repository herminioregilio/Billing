package hermes.billing.financeiro.faturamento;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import hermes.billing.financeiro.faturamento.cobranca.FaturamentoCobrancaTestesUnitariosSuite;

@RunWith(Suite.class)
@SuiteClasses({ FaturaTest.class, FaturamentoTest.class, FaturamentoCobrancaTestesUnitariosSuite.class })
public class FaturamentoTestesUnitariosSuite {

}
