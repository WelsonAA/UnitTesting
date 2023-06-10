package System;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class BillTest {

    Account myacc=new Account("zeina","123",10000.0,LocalDate.parse("2023-05-23"));
    @Test
    public void getDate() throws TransactionsExceptions {
        LocalDate date = LocalDate.now();
        Bill bill = new Bill(100.0,  BillType.WATER_BILL, date, myacc);
        assertEquals(date, bill.getDate());
        assertEquals(bill,myacc.Bills.get(0));

    }

    @Test
    public void getBalanceBefore() throws TransactionsExceptions {
       Double balanceBefore = 9900.;
       Bill bill = new Bill(100.0, BillType.WATER_BILL, LocalDate.now(), myacc);
       assertEquals(balanceBefore, bill.getBalanceBefore());

    }

    @Test
    public void getBalanceAfter() throws TransactionsExceptions {
      Double amount = 100.0;
      Double balanceBefore = 9900.;
      Bill bill = new Bill(amount,  BillType.WATER_BILL, LocalDate.now(), myacc);
      assertEquals(balanceBefore - amount, bill.getBalanceAfter(), 0.0);

    }

    @Test
    public void getAmount() throws TransactionsExceptions {
        Double amount = 100.0;
        Bill bill = new Bill(amount,  BillType.WATER_BILL, LocalDate.now(), myacc);
        assertEquals(amount, bill.getAmount());
    }

    @Test
    public void getBillID() throws TransactionsExceptions {
      Bill bill1 = new Bill(100.0,  BillType.WATER_BILL, LocalDate.now(), myacc);
      Bill bill2 = new Bill(200.0,  BillType.ELECTRICITY, LocalDate.now(), myacc);
      assertNotEquals(bill1.getBillID(), bill2.getBillID());

    }
}