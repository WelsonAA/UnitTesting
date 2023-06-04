package System;

import java.time.LocalDate;

public class Deposit extends Transaction {
    public Deposit() {
    }

    public Deposit(Double amount, LocalDate TransactionDate,Double BalanceBefore)
    {
        super(amount, TransactionDate,BalanceBefore);
        super.BalanceAfter=BalanceBefore+amount;
    }
}
