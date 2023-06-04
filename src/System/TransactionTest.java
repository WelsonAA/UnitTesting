package System;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TransactionTest {
    @Test
    public void Trans1()
    {
        Transaction T1=new Transaction(500.0, LocalDate.parse("2023-06-04"),1500.0);
        Integer ID1=T1.getTransactionID();
        Transaction T2=new Transaction(600.0, LocalDate.parse("2023-06-04"),1600.0);
        Integer ID2=T2.getTransactionID();
        assertEquals(ID2,ID1+1,0.001);
    }
    @Test
    public void Trans2()
    {
        Transaction T1=new Transaction(500.0, LocalDate.parse("2023-06-05"),1500.0);
        assertNotEquals(0.0,T1.getTransactionAmount());
    }
    @Test
    public void TransactionWithWithdraw1()
    {
        Transaction T1=new Transaction(800.0, LocalDate.parse("2023-06-06"),1800.0);
        assertEquals(1000.0,T1.BalanceBefore-T1.TransactionAmount,0.001);

    }
    @Test
    public void TransactionWithWithdraw2()
    {
        Transaction T1=new Transaction(800.0, LocalDate.parse("2023-06-07"),1800.0);
        assertTrue("Transaction is NOT done correctly",T1.TransactionAmount<= T1.BalanceBefore);
    }

    @Test
    public void TransactionWithTransfer1()
    {
        Transaction T1=new Transaction(10000.0, LocalDate.parse("2023-06-04"),100000.0);
        assertEquals(90000.0,T1.BalanceBefore-T1.TransactionAmount,0.001);

    }
    @Test
    public void TransactionWithTransfer2()
    {
        Transaction T1=new Transaction(39202.0, LocalDate.parse("2023-06-01"),1234567.0);
        assertTrue("Transaction is NOT done correctly",T1.TransactionAmount<= T1.BalanceBefore);
    }

    @Test

    public void TransactionWithDeposit1()
    {
        Transaction T1=new Transaction(900.0, LocalDate.parse("2023-06-10"),900.0);
        assertEquals(1800.0,T1.BalanceBefore+T1.TransactionAmount,0.001);
    }
    @Test
    public void TransactionWithDeposit2()
    {
        Transaction T1=new Transaction(900.0, LocalDate.parse("2023-06-10"),900.0);
        assertEquals(LocalDate.parse("2023-06-10"),T1.TransactionDate);
    }

}