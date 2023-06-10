package System;

import java.time.LocalDate;

public class Deposit extends Transaction {
    public Deposit() {
    }

    public Deposit(Double amount, LocalDate TransactionDate,Double BalanceBefore,Account acc) throws TransactionsExceptions{
        super(amount, TransactionDate,BalanceBefore);

        if(amount<=0){
            throw new InvalidAmount();
        }
        else {

            acc.Transactions.add(this);
            this.BalanceBefore += amount;
            acc.notification+="Successful Deposit +"+amount+"\n";
        }
        super.BalanceAfter=BalanceBefore+amount;
    }
}
