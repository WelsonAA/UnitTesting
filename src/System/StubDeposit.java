package System;

public class StubDeposit {
    private int compareaccno=011;
    private double balance;
    private int accounbtno;

    public StubDeposit(double balance, int accounbtno) {
        this.balance = balance;
        this.accounbtno = accounbtno;

    }

    public String check()
    {
        if(balance!=0 && accounbtno==compareaccno)
            return("Deposit Done successfully");
        else
            return ("Deposit failed");
    }

    public double getBalance() {
        return balance;
    }

    public int getAccounbtno() {
        return accounbtno;
    }
}
