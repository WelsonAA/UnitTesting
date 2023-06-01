package System;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DepositTest {


    @Test
    //public Deposit(Double amount, LocalDate TransactionDate,Double BalanceBefore
    public void TestDeposit1()
        {
            Deposit dep1 = new Deposit(5000.0, LocalDate.parse("2023-06-23"), 1000.0);
            assertEquals(6000.0, dep1.BalanceAfter, 0.001);
            assertEquals(LocalDate.parse("2023-06-23"), dep1.TransactionDate);
            assertEquals(1000.0, dep1.BalanceBefore, 0.01);

        }
        @Test
        public void TestDeposit2()
        {
            Deposit dep2 = new Deposit(500.0, LocalDate.parse("2023-05-23"), 15490.7);
            double val = dep2.getTransactionAmount() + dep2.BalanceBefore;
            assertEquals(val, dep2.BalanceAfter, 0.001);
            assertTrue("Transaction is done correctly", val == dep2.BalanceAfter);





            assertEquals(15490.7, dep2.BalanceBefore, 0.01);

        }


    }
