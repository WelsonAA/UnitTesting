package System;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)//ba2ool en el suite dh class




@Suite.SuiteClasses(
        {
                BankTest.class,
                BillTest.class,
                DepositTest.class,
                TransferTest.class,
                WithdrawTest.class,
                TransactionTest.class,
                AccountTest.class

        }
)



public  class TestSuitAll {
}
