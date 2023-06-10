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
        Account account3=new Account("hassaneltobgy", "hass2233", LocalDate.parse("2003-03-24"), "Sheraton",
                "P3123", "032014714", "5522", "01061952782","Hassan","Mohamed","El-Tobgy");
        assertEquals("hassaneltobgy",account3.getUserName());
        assertEquals("hass2233",account3.getPassword());
        assertEquals("P3123",account3.getZipCode());
        assertEquals("032014714",account3.getSSN());
        assertEquals("5522",account3.getCardNo());
        assertEquals("01061952782",account3.getTelephoneNo());
        StubDeposit stubdeposit1=new StubDeposit(1000.0, 011);

        assertEquals("Deposit Done successfully",stubdeposit1.check());
        assertEquals(1000.0,stubdeposit1.getBalance(),0.01);
        assertEquals(011,stubdeposit1.getAccounbtno());

        StubDeposit stubdeposit2=new StubDeposit(0.0, 011); //balance zero
        assertEquals("Deposit failed",stubdeposit2.check());

       StubDeposit stubdeposit3=new StubDeposit(2000.0, 01111); //account not registered
       assertEquals("Deposit failed",stubdeposit3.check());
    }
    @Test
    public void Integration3() throws TransactionsExceptions
    {

        Bank bankint2=new Bank();
        Account account2=new Account("hassaneltobgy", "hass2233", LocalDate.parse("2003-03-24"), "Sheraton",
                "P3123", "032014714", "5522", "01061952782","Hassan","Mohamed","El-Tobgy");
        assertEquals("hassaneltobgy",account2.getUserName());
        assertEquals("hass2233",account2.getPassword());
        assertEquals("P3123",account2.getZipCode());
        assertEquals("032014714",account2.getSSN());
        assertEquals("5522",account2.getCardNo());
        assertEquals("01061952782",account2.getTelephoneNo());

        Deposit deposit1= new Deposit(1000.0, LocalDate.parse("2003-03-24"),account2.getBalance(),account2);
        assertEquals(1000.0,account2.getBalance(),0.01);

        StubWithdraw withdraw1=new StubWithdraw();
        assertEquals("Withdrawal Done",withdraw1.check(1500));
        assertEquals("No Sufficient Balance",withdraw1.check(3000));

        StubWithdraw withdraw2=new StubWithdraw();
        assertEquals("Withdrawal Done",withdraw2.check(1000));
        assertEquals("No Sufficient Balance",withdraw2.check(4000));
        StubWithdraw withdraw3=new StubWithdraw();
        assertEquals("Withdrawal Done",withdraw3.check(500));
        assertEquals("No Sufficient Balance",withdraw3.check(5000));
    }
    @Test
    public void Integration4() throws TransactionsExceptions
    {

        Bank bankint2=new Bank();
        Account account3=new Account("hassaneltobgy", "hass2233", LocalDate.parse("2003-03-24"), "Sheraton",
                "P3123", "032014714", "5522", "01061952782","Hassan","Mohamed","El-Tobgy");
        assertEquals("hassaneltobgy",account3.getUserName());
        assertEquals("hass2233",account3.getPassword());
        assertEquals("P3123",account3.getZipCode());
        assertEquals("032014714",account3.getSSN());
        assertEquals("5522",account3.getCardNo());
        assertEquals("01061952782",account3.getTelephoneNo());


        Deposit deposit1= new Deposit(1000.0, LocalDate.parse("2003-03-24"),account3.getBalance(),account3);
        assertEquals(1000,account3.getBalance(),0.01);

        Withdraw withdraw1=new Withdraw(500.0, LocalDate.parse("2003-03-24"), account3.getBalance(), account3) ;
        assertEquals(500,account3.getBalance(),0.01);

        StubTransfer stubtransfer1=new StubTransfer();
        assertEquals("Transfer done successfully",stubtransfer1.check(1000,55221));
        assertEquals("Transfer failed",stubtransfer1.check(6000,55221));
        assertEquals("Transfer failed",stubtransfer1.check(1000,552221));
        assertEquals("Transfer done successfully",stubtransfer1.check(400,55221));
        assertEquals("Transfer failed",stubtransfer1.check(5000,87121));
    }
@Test
  public void Integration5()throws TransactionsExceptions
    {

        Bank bankint2=new Bank();
        Account account3=new Account("hassaneltobgy", "hass2233", LocalDate.parse("2003-03-24"), "Sheraton",
                "P3123", "032014714", "5522", "01061952782","Hassan","Mohamed","El-Tobgy");
        assertEquals("hassaneltobgy",account3.getUserName());
        assertEquals("hass2233",account3.getPassword());
        assertEquals("P3123",account3.getZipCode());
        assertEquals("032014714",account3.getSSN());
        assertEquals("5522",account3.getCardNo());
        assertEquals("01061952782",account3.getTelephoneNo());


        Deposit deposit1= new Deposit(5000.0, LocalDate.parse("2003-03-24"),account3.getBalance(),account3);
        assertEquals(5000.0,account3.getBalance(),0.01);

        Withdraw withdraw1=new Withdraw(500.0, LocalDate.parse("2003-03-24"), account3.getBalance(), account3) ;
        assertEquals(4500,account3.getBalance(),0.01);
        Account account4=new Account("Hassan55", "hass2233", LocalDate.parse("2003-03-24"), "Sheraton",
                "P3123", "425", "5522", "01061952782","Hassan","Mohamed","El-Tobgy");

       Transfer transfer1=new Transfer(500.0, LocalDate.parse("2003-03-24"),1 ,account3.getBalance(),account3);
       assertEquals(4000,account3.getBalance(),0.01);
       assertEquals(500,account4.getBalance(),0.01);

        StubPaybill stubpaybill1=new StubPaybill();
        assertEquals("Bill paied Successfully",stubpaybill1.check(1000,"Electricity"));
        assertEquals("Bill paied Successfully",stubpaybill1.check(500,"Electricity"));
        assertEquals("Bill paied Successfully",stubpaybill1.check(16,"Electricity"));
        assertEquals("Bill paied Successfully",stubpaybill1.check(32,"Electricity"));

        assertEquals("Error insuffient balance or Error in billtype",stubpaybill1.check(5000,"Electricity"));
        assertEquals("Error insuffient balance or Error in billtype",stubpaybill1.check(1000,"school"));






    }

  @Test
    public void Integration6()throws TransactionsExceptions
    {

        Bank bankint2=new Bank();
        Account account3=new Account("hassaneltobgy", "hass2233", LocalDate.parse("2003-03-24"), "Sheraton",
                "P3123", "032014714", "5522", "01061952782","Hassan","Mohamed","El-Tobgy");
        assertEquals("hassaneltobgy",account3.getUserName());
        assertEquals("hass2233",account3.getPassword());
        assertEquals("P3123",account3.getZipCode());
        assertEquals("032014714",account3.getSSN());
        assertEquals("5522",account3.getCardNo());
        assertEquals("01061952782",account3.getTelephoneNo());


        Deposit deposit1= new Deposit(5000.0, LocalDate.parse("2003-03-24"),account3.getBalance(),account3);
        assertEquals(5000,account3.getBalance(),0.01);

        Withdraw withdraw1=new Withdraw(500.0, LocalDate.parse("2003-03-24"), account3.getBalance(), account3) ;
        assertEquals(4500,account3.getBalance(),0.01);
        Account account4=new Account("zeina", "hass2233", LocalDate.parse("2003-03-24"), "Sheraton",
                "P3123", "425", "5522", "01061952782","Hassan","Mohamed","El-Tobgy");

      /*  Transfer transfer1=new Transfer(500, LocalDate.parse("2003-03-24"),9 ,account3.getBalance(),account3) throws TransactionsExceptions
        assertEquals(4000,account3.getBalance(),0.01);
        assertEquals(500,account4.getBalance(),0.01);

        StubPaybill stubpaybill1=new StubPaybill();
        assertEquals("Bill paied Successfully",stubpaybill1.check(1000,"Electricity"));
        assertEquals("Bill paied Successfully",stubpaybill1.check(500,"Electricity"));
        assertEquals("Bill paied Successfully",stubpaybill1.check(16,"Electricity"));
        assertEquals("Bill paied Successfully",stubpaybill1.check(32,"Electricity"));

        assertEquals("Error insuffient balance or Error in billtype",stubpaybill1.check(5000,"Electricity"));
        assertEquals("Error insuffient balance or Error in billtype",stubpaybill1.check(1000,"school"));

      / account3.payBill(1000.0,BillType.ELECTRICITY);
        assertEquals(3000,account3.getBalance());

*/







    }

}