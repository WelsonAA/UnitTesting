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
    @Test
    public void Integration1()
    {
        Bank bankint1=new Bank();
        StubAccount account1=new StubAccount("hassaneltobgy","trypassword");
        assertEquals("hassaneltobgy",account1.getUser());
        assertEquals("trypassword",account1.getPassword());


        StubAccount account2 =new StubAccount("user1","pass1");
        assertEquals("user1",account2.getUser());
        assertEquals("pass1",account2.getPassword());


        StubAccount account3=new StubAccount("Zeina","pass43");
        assertEquals("Zeina",account3.getUser());
        assertEquals("pass43",account3.getPassword());


        StubAccount account4 =new StubAccount("user2","0100");
        assertEquals("user2",account4.getUser());
        assertEquals("0100",account4.getPassword());

    }
    @Test
    public void Integration2()
    {
        Bank bankint2=new Bank();
        Account account1=new Account("hassaneltobgy", "hass2233", LocalDate.parse("2003-03-24"), "Sheraton",
                "P3123", "032014714", "5522", "01061952782","Hassan","Mohamed","El-Tobgy");

        StubDeposit stubdeposit1=new StubDeposit(1000.0, 011);

        assertEquals("Deposit Done successfully",stubdeposit1.check());
        assertEquals(1000.0,stubdeposit1.getBalance(),0.01);
        assertEquals(011,stubdeposit1.getAccounbtno());

        StubDeposit stubdeposit2=new StubDeposit(0.0, 011); //balance zero
        assertEquals("Deposit failed",stubdeposit2.check());

       StubDeposit stubdeposit3=new StubDeposit(2000.0, 01111); //account not registered
       assertEquals("Deposit failed",stubdeposit3.check());



    }


}