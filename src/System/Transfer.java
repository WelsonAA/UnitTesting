package System;

import java.time.LocalDate;

public class Transfer extends Transaction{
    private final Integer ReceiverAccountNo;

    public Transfer(Double amount, LocalDate TransactionDate, Integer receiverAccountNo,Double BalanceBefore,Account acc) throws TransactionsExceptions {
        super(amount, TransactionDate,BalanceBefore);
        if(amount>BalanceBefore)
        {
            throw new InsufficientBalance();
        }else if(amount<=0){
            throw new InvalidAmount();
        }else if(Bank.check(receiverAccountNo)==null){
            throw new InvalidAccountNo();
        }
        else {

            acc.Transactions.add(this);
            this.BalanceBefore -= amount;

            acc.notification+="Successful Transfer -"+amount+"\n";
        }
        this.ReceiverAccountNo = receiverAccountNo;
        super.BalanceAfter=BalanceBefore-amount;
    }

    public Integer getReceiverAccountNo() {
        return ReceiverAccountNo;
    }
}
