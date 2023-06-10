package System;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class WithdrawTest {
    Account myacc=new Account("Mazen","2121",5000.0,LocalDate.parse("2023-05-23"));
    @Test
    public void withdraw1()throws TransactionsExceptions
    {
        Withdraw w =new Withdraw(1000.0, LocalDate.parse("2023-05-23"), myacc.getBalance(), myacc);
        assertEquals(4000,w.BalanceAfter,0.1);
    }
    @Test
    public void withdraw2()throws TransactionsExceptions
    {
        Withdraw w2 =new Withdraw(600.0, LocalDate.parse("2023-05-23"), myacc.getBalance(),myacc);
        assertEquals(4400.0, w2.BalanceAfter,0.01);
    }
    @Test
    public void withdraw3()throws TransactionsExceptions
    {
        Withdraw w3 =new Withdraw(800.0, LocalDate.parse("2023-05-23"), myacc.getBalance(),myacc);
       assertEquals(LocalDate.parse("2023-05-23"),w3.getTransactionDate());
    }
    @Test
    public void withdraw4()throws TransactionsExceptions
    {
        Withdraw w4= new Withdraw(1212.0, LocalDate.parse("2023-05-30"), myacc.getBalance(),myacc);
        assertTrue(" Insufficent amount",w4.getTransactionAmount()<= w4.BalanceBefore);
    }
    @Test
    public void withdraw5()throws TransactionsExceptions

    {
       Withdraw w5 = new Withdraw(1212.0, LocalDate.parse("2023-05-30"), myacc.getBalance(),myacc);
       assertTrue("Not positive Value", w5.getTransactionAmount() > 0);
    }

}
