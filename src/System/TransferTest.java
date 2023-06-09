package System;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class TransferTest {
    Bank B1=new Bank();
    Account myacc=new Account("Hassan","100100",1500.0,LocalDate.parse("2023-05-23"));
    @Test

    public void Transfer1()throws TransactionsExceptions
    {
        Account myacc2=new Account("Hassan","100100",1500.0,LocalDate.parse("2023-05-23"));
        B1.Accounts.add(myacc2);
        Transfer T1=new Transfer(500.0, LocalDate.parse("2023-06-08"),1,myacc.getBalance(),myacc);
        assertEquals(1000.0,T1.BalanceAfter,0.01);
        assertEquals(LocalDate.parse("2023-06-08"),T1.TransactionDate);

    }
    @Test public void Transfer2()throws TransactionsExceptions
    {
        Account myacc2=new Account("George","100100",3400.0,LocalDate.parse("2023-05-23"));
        B1.Accounts.add(myacc2);
        Transfer T2=new Transfer(400.0, LocalDate.parse("2023-06-09"),1,myacc.getBalance(),myacc);
        System.out.println(T2.BalanceAfter);
        assertEquals(1100.0,T2.BalanceAfter,0.01);
    }
    @Test
    public void Transfer3()throws TransactionsExceptions
    {
        Account myacc2=new Account("mariam","abc100",1500.0,LocalDate.parse("2023-05-23"));
        B1.Accounts.add(myacc2);
        Transfer T3=new Transfer(1000.0, LocalDate.parse("2023-06-09"),1,myacc.getBalance(),myacc);
       assertTrue(" Insufficent amount",T3.getTransactionAmount()<= T3.BalanceBefore);
    }
    @Test
    public void Transfer4()throws TransactionsExceptions
    {
        Account myacc2=new Account("Mazen","xyz555",1500.0,LocalDate.parse("2023-05-23"));
        B1.Accounts.add(myacc2);
        Transfer T4=new Transfer(200.0, LocalDate.parse("2023-06-10"),1,myacc.getBalance(),myacc);
       assertTrue("Not positive Value",T4.getTransactionAmount()>0);
    }


}
