package System;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class BillTest {

    @Test
    public void getDate() {
     //   LocalDate date = LocalDate.now();
       // Bill bill = new Bill(100.0,  BillType.WATER_BILL, date, 500.0);
       // assertEquals(date, bill.getDate());


    }

    @Test
    public void getBalanceBefore() {
       // Double balanceBefore = 500.0;
       // Bill bill = new Bill(100.0, BillType.WATER_BILL, LocalDate.now(), balanceBefore);
       // assertEquals(balanceBefore, bill.getBalanceBefore());

    }

    @Test
    public void getBalanceAfter() {
      //  Double amount = 100.0;
      //  Double balanceBefore = 500.0;
       // Bill bill = new Bill(amount,  BillType.WATER_BILL, LocalDate.now(), balanceBefore);
      //  assertEquals(balanceBefore - amount, bill.getBalanceAfter(), 0.0);

    }

    @Test
    public void getAmount() {
        Double amount = 100.0;
        //Bill bill = new Bill(amount,  BillType.WATER_BILL, LocalDate.now(), 500.0);
       // assertEquals(amount, bill.getAmount());
    }

    @Test
    public void getDescription() {
      //  String description = "Test Bill";
      //  Bill bill = new Bill(100.0, BillType.WATER_BILL, LocalDate.now(), 500.0);
       // assertEquals(description, bill.getDescription());

    }

    @Test
    public void getBillID() {
       // Bill bill1 = new Bill(100.0,  BillType.WATER_BILL, LocalDate.now(), 500.0);
      //  Bill bill2 = new Bill(200.0,  BillType.ELECTRICITY, LocalDate.now(), 700.0);
      //  assertNotEquals(bill1.getBillID(), bill2.getBillID());

    }
}