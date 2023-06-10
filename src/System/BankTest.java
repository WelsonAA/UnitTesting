package System;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;


public class BankTest {
    @Test
    public void Bank1()
    {
        Account A1=new Account("Zozo22","1234",10000.0, LocalDate.parse("2001-08-30"));
        Bank.Accounts.add(A1);
        assertEquals(A1,Bank.Accounts.get(0));
    }
    @Test
    public void Bank2()
    {
        Account A1=new Account("Zozo22","1234",10000.0, LocalDate.parse("2001-08-30"));
        Bank.Accounts.add(A1);
        assertEquals("Zozo22",Bank.Accounts.get(0).getUserName());
    }
    @Test
    public void Bank3()
    {
        Account A1=new Account("Zozo22","1234",10000.0, LocalDate.parse("2001-08-30"));
        Bank.Accounts.add(A1);
        assertEquals("1234",Bank.Accounts.get(0).getPassword());
    }
    @Test
    public void Bank4()
    {
        Account A1=new Account("Zozo22","1234",10000.0, LocalDate.parse("2001-08-30"));
        Bank.Accounts.add(A1);
        assertEquals(10000.0,Bank.Accounts.get(0).getBalance(),0.01);

    }
    @Test
    public void Bank5()
    {
        Account A1=new Account("Zozo22","1234",10000.0, LocalDate.parse("2001-08-30"));
        Bank.Accounts.add(A1);
        assertEquals(LocalDate.parse("2001-08-30"),Bank.Accounts.get(0).getBirthDate());
    }


}