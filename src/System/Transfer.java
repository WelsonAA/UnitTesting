package System;

import java.time.LocalDate;

public class Transfer extends Transaction{
    private final Integer ReceiverAccountNo;

    public Transfer(Double amount, LocalDate TransactionDate, Integer receiverAccountNo,Double BalanceBefore) {
        super(amount, TransactionDate,BalanceBefore);
        this.ReceiverAccountNo = receiverAccountNo;
        super.BalanceAfter=BalanceBefore-amount;
    }

    public Integer getReceiverAccountNo() {
        return ReceiverAccountNo;
    }
}
