package System;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;

public class DepositTest {

    Account myacc=new Account("zeina","123",1000.0,LocalDate.parse("2023-05-23"));
    @Test
    //public Deposit(Double amount, LocalDate TransactionDate,Double BalanceBefore
    public void TestDeposit1()throws TransactionsExceptions
        {
           Deposit dep1 = new Deposit(500.0, LocalDate.parse("2023-06-23"),myacc.getBalance(), myacc);
            assertEquals(1500.0, dep1.BalanceAfter, 0.001);

        }
        @Test
        public void TestDeposit2()throws TransactionsExceptions
        {
           Deposit dep2 = new Deposit(200.0, LocalDate.parse("2023-05-28"), myacc.getBalance(),myacc);
           assertEquals(1200.0, dep2.BalanceAfter, 0.001);


        }
        @Test
        public void TestDeposit3()throws TransactionsExceptions
        {
            Deposit dep3 = new Deposit(10000.0, LocalDate.parse("2023-05-23"), myacc.getBalance(), myacc);
           assertEquals(11000.0, dep3.BalanceAfter, 0.001);
        }
        @Test
        public void TestDeposit4()throws TransactionsExceptions
        {
            Deposit dep4= new Deposit(1000.0, LocalDate.parse("2023-06-08"), 10000.0,myacc);
           assertTrue("Amount is not a positve amount",dep4.getTransactionAmount()>0);
        }




    }

