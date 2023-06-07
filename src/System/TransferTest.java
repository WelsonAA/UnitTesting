package System;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TransferTest {
    @Test
    public void Transfer1()
    {
        Transfer T1=new Transfer(500.0, LocalDate.parse("2023-06-08"),12,1500.0);
        assertEquals(1000,T1.BalanceAfter,0.01);
        assertEquals(LocalDate.parse("2023-06-08"),T1.TransactionDate);

    }
    @Test public void Transfer2()
    {
        Transfer T1=new Transfer(500.0, LocalDate.parse("2023-06-09"),10,1500.0);
        assertEquals(T1.BalanceAfter,T1.BalanceBefore-T1.TransactionAmount,0.01);
    }
    @Test
    public void Transfer3()
    {
        Transfer T1=new Transfer(400.0, LocalDate.parse("2023-06-09"),7,1700.0);
        assertTrue(" Insufficent amount",T1.getTransactionAmount()<= T1.BalanceBefore);
    }
    @Test
    public void Transfer4()
    {
        Transfer T1=new Transfer(4200.0, LocalDate.parse("2023-06-10"),10,4700.0);
        assertTrue("Not positive Value",T1.getTransactionAmount()>0);
    }


}
