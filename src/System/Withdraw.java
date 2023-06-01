package System;

import java.time.LocalDate;

public class Withdraw extends Transaction{
    public Withdraw() {
    }

    public Withdraw(Double amount, LocalDate TransactionDate,Double BalanceBefore) {
        super(amount, TransactionDate,BalanceBefore);
        BalanceAfter=BalanceBefore-amount;
    }
}
