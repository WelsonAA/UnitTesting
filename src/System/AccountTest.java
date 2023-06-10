package System;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


public class AccountTest {

    @Test
    public void TestConstructor() {
        Account a=new Account("welson","123456",2500.0, LocalDate.parse("2003-03-24"));
        assertEquals("welson",a.getUserName());
        assertEquals("123456",a.getPassword());
        assertEquals("2003-03-24",a.getBirthDate().toString());
        assertEquals(2500.0,a.getBalance(),0.1);
    }
    @Test(timeout = 123456)
    public void TestConstructor2()
    {
        Account a=new Account("welson","123456",-2500.0, LocalDate.parse("2003-03-24"));
        assertEquals("welson",a.getUserName());
        assertEquals("123456",a.getPassword());
        assertEquals("2003-03-24",a.getBirthDate().toString());
        assertEquals(0.0,a.getBalance(),0.1);
    }
    @Test
    public void TestDeposit()throws TransactionsExceptions{
        Account a=new Account("welson","123456",2500.0, LocalDate.parse("2003-03-24"));
        a.deposit(500.0);
        assertEquals(3000.0,a.getBalance(),0.01);
    }

    @Test
    public void TestWithdraw()throws TransactionsExceptions{
        Account a=new Account("welson","123456",2500.0, LocalDate.parse("2003-03-24"));
        a.withdraw(500.0);
        assertEquals(2000.0,a.getBalance(),0.01);
    }

}