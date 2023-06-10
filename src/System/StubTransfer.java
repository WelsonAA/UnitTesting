package System;

public class StubTransfer {
    private double balancebefore=2000.0;
    private int acctrans=55221;
    private int amount;

//    public StubTransfer(int amount) {
//        this.amount = amount;
//    }
    public String check(int transferamount,int transferaccno )
    {
        if(transferamount<=balancebefore && transferaccno==acctrans)
        {
            return("Transfer done successfully");
        }
        else
            return("Transfer failed");


    }
}
