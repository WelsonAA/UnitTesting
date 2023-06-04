package System;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class WithdrawTest {
    @Test
    public void withdraw1()
    {
        Withdraw w =new Withdraw(500.0, LocalDate.parse("2023-05-23"), 15490.7);
        assertEquals(w.BalanceAfter,w.BalanceBefore-w.TransactionAmount,0.01);
    }
    @Test
    public void withdraw2()
    {
        Withdraw w2 =new Withdraw(600.0, LocalDate.parse("2023-05-23"), 10600.7);
        assertEquals(10000.7, w2.BalanceAfter,0.01);
    }
    @Test
    public void withdraw3()
    {
        Withdraw w3 =new Withdraw(600.0, LocalDate.parse("2023-05-23"), 10600.7);
        assertEquals(LocalDate.parse("2023-05-23"),w3.getTransactionDate());
    }
    @Test
    public void withdraw4()
    {
        Withdraw w4= new Withdraw(1212.0, LocalDate.parse("2023-05-30"), 10600.7);
        assertTrue(" Insufficent amount",w4.getTransactionAmount()<= w4.BalanceBefore);
    }


    @Test
    public void withdraw5()
    {
        Withdraw w5 = new Withdraw(4200.0, LocalDate.parse("2023-06-10"), 4700.0);
        assertTrue("Not positive Value", w5.getTransactionAmount() > 0);
    }

}
