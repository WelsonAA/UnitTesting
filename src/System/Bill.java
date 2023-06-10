package System;

import java.time.LocalDate;

public class Bill {
    private Double Amount;
    private Integer BillID;
    private BillType billType; //possible to be enum
    private LocalDate Date;
    private Double BalanceBefore;
    private Double BalanceAfter;
    static int id=0;
    int flagbigger=0;
    int flagsmaller=0;

    public LocalDate getDate() {
        return Date;
    }

    public Double getBalanceBefore() {
        return BalanceBefore;
    }

    public Double getBalanceAfter() {
        return BalanceAfter;
    }

    public Bill(Double amount, BillType bt, LocalDate Date,Account acc)throws TransactionsExceptions {

    }
    public String DoBill(Double amount, BillType bt, LocalDate Date,Account acc)throws TransactionsExceptions {
        BalanceBefore=acc.getBalance();

        if(amount>BalanceBefore){
            flagbigger=1;
            throw new InsufficientBalance();
        }else if(amount<=0){
            flagsmaller=1;
            throw new InvalidAmount();
        }
        else {

            acc.Bills.add(this);
            this.BalanceBefore -= amount;
            acc.notification+="Successful Bill Payment -"+amount+"\n";
            Amount = amount;
            BillID=id++;
            this.billType = bt;
            this.Date=Date;
            this.BalanceBefore=BalanceBefore;
            this.BalanceAfter=BalanceBefore-amount;
            return ("Amount:"+amount+"is billed \n");

        }


    }

    public Double getAmount() {
        return Amount;
    }


    public Integer getBillID() {
        return BillID;
    }
    public int getflagbigger ()
    {
        return flagbigger;
    }
    public int getFlagsmaller ()
    {
        return flagsmaller;
    }


}
