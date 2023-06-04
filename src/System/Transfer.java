package System;

import java.time.LocalDate;

public class Transfer extends Transaction{
    private final String ReceiverAccountNo;

    public Transfer(Double amount, LocalDate TransactionDate, String receiverAccountNo,Double BalanceBefore) {
        super(amount, TransactionDate,BalanceBefore);
        this.ReceiverAccountNo = receiverAccountNo;
        super.BalanceAfter=BalanceBefore-amount;
    }

    public String getReceiverAccountNo() {
        return ReceiverAccountNo;
    }
}

