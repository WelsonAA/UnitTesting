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

    @Test
    public void TestDeposit()throws TransactionsExceptions{
        Account a=new Account("welson","123456",2500.0, LocalDate.parse("2003-03-24"));
        a.deposit(500.0);
        assertEquals(3000.0,a.getBalance(),0.01);
    }
    @Test(expected = InvalidAmount.class)
    public void TestDepositInvalidAmount()throws TransactionsExceptions{
        Account a=new Account("welson","123456",2500.0, LocalDate.parse("2003-03-24"));
        a.deposit(-500.0);
        assertEquals(3000.0,a.getBalance(),0.01);
    }

    @Test
    public void TestWithdraw()throws TransactionsExceptions{
        Account a=new Account("welson","123456",2500.0, LocalDate.parse("2003-03-24"));
        a.withdraw(500.0);
        assertEquals(2000.0,a.getBalance(),0.01);
    }
    @Test
    public void TestWithdrawException()throws TransactionsExceptions{
        Account a=new Account("welson","123456",2500.0, LocalDate.parse("2003-03-24"));
        a.withdraw(500.0);
        assertEquals(2000.0,a.getBalance(),0.01);
    }
    @Test
    public void TestTransfer()throws TransactionsExceptions{

        Account a=new Account("welson","123456",1000., LocalDate.parse("2003-03-24"));
        Account a2=new Account("tobgy","123456",2000., LocalDate.parse("2003-03-24"));
        Bank.addAccount(a);
        Bank.addAccount(a2);
        a.transfer(500.0,1);
        assertEquals(500.,a.getBalance(),0.01);
        assertEquals(2500.,a2.getBalance(),0.01);
        assertEquals(500.,a.Transactions.get(0).getTransactionAmount().doubleValue(),0.01);
    }
    @Test(expected = InsufficientBalance.class)
    public void TestTransferInsufficient()throws TransactionsExceptions{
        Bank b= new Bank();
        Account a=new Account("welson","123456",1000., LocalDate.parse("2003-03-24"));
        Account a2=new Account("tobgy","123456",2000., LocalDate.parse("2003-03-24"));
        b.addAccount(a);
        b.addAccount(a2);
        a.transfer(50000.0,1);
        assertEquals(500.,a.getBalance(),0.01);
        assertEquals(2500.,a2.getBalance(),0.01);
        assertEquals(500.,a.Transactions.get(0).getTransactionAmount().doubleValue(),0.01);
    }
    @Test(expected = InvalidAccountNo.class)
    public void TestTransferInvalidAmount()throws TransactionsExceptions{
        Bank b= new Bank();
        Account a=new Account("welson","123456",1000., LocalDate.parse("2003-03-24"));
        Account a2=new Account("tobgy","123456",2000., LocalDate.parse("2003-03-24"));
        b.addAccount(a);
        a.transfer(50.0,10);
        assertEquals(950,a.getBalance(),0.01);
        assertEquals(950,a.Transactions.get(0).getTransactionAmount().doubleValue(),0.01);
    }
    @Test
    public void TestPayBill() throws TransactionsExceptions{
        Bank b= new Bank();
        Account a=new Account("welson","123456",1000., LocalDate.parse("2003-03-24"));
        b.addAccount(a);
        a.payBill(500.,BillType.PURCHASED_ITEMS);
        assertEquals(500.,a.getBalance().doubleValue(),0.01);

    }
    @Test(expected = InsufficientBalance.class)
    public void TestPayBillException() throws TransactionsExceptions{
        Bank b= new Bank();
        Account a=new Account("welson","123456",1000., LocalDate.parse("2003-03-24"));
        b.addAccount(a);
        a.payBill(1500.,BillType.PURCHASED_ITEMS);
        assertEquals(500.,a.getBalance().doubleValue());

    }
    @Test
    public void TestPurchase() throws TransactionsExceptions{
        Bank b= new Bank();
        Account a=new Account("welson","123456",1000., LocalDate.parse("2003-03-24"));
        a.purchaseItem(200.,"ZARA","Shirt");
    }
    @Test(expected = InsufficientBalance.class)
    public void TestPurchaseInsufficient() throws TransactionsExceptions{
        Bank b= new Bank();
        Account a=new Account("welson","123456",1000., LocalDate.parse("2003-03-24"));
        a.purchaseItem(2000.,"ZARA","Shirt");
    }


}