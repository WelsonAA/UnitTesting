package System;

import java.time.LocalDate;

public class Withdraw extends Transaction{
    public Withdraw() {
    }

    public Withdraw(Double amount, LocalDate TransactionDate,Double BalanceBefore,Account acc) throws TransactionsExceptions {

        super(amount, TransactionDate,BalanceBefore);
        if(amount>BalanceBefore){
            throw new InsufficientBalance();
        }else if(amount<=0){
            throw new InvalidAmount();
        }
        else
        {
            acc.Transactions.add(this);
            acc.notification+="Successful Withdraw -"+amount+"\n";
        }
        BalanceAfter=BalanceBefore-amount;
    }
}
