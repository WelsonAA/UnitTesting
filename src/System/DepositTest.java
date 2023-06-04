package System;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;

public class DepositTest {


    @Test
    //public Deposit(Double amount, LocalDate TransactionDate,Double BalanceBefore
    public void TestDeposit1()
        {
            Deposit dep1 = new Deposit(5000.0, LocalDate.parse("2023-06-23"), 1000.0);
            assertEquals(6000.0, dep1.BalanceAfter, 0.001);

        }
        @Test
        public void TestDeposit2()
        {
            Deposit dep2 = new Deposit(500.0, LocalDate.parse("2023-05-23"), 15490.7);
            assertEquals(15990.7, dep2.BalanceAfter, 0.001);


        }
        @Test
        public void TestDeposit3() {
            Deposit dep3 = new Deposit(10000.0, LocalDate.parse("2023-06-04"), 12121.0);
            assertEquals(dep3.BalanceAfter, (dep3.getTransactionAmount() + dep3.BalanceBefore), 0.01);
        }
        @Test
        public void TestDeposit4()
        {
            Deposit dep4= new Deposit(1234.0, LocalDate.parse("2023-06-08"), 10000.0);
            assertTrue("Amount is not a positve amount",dep4.getTransactionAmount()>0);
        }




    }
