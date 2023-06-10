package System;

public class StubWithdraw {
        private double balancebefore1=2000.0000;
        private float amount;

//    public StubWithdraw(float amount) {
//        this.amount = amount;
//    }
    public String check(float amoutwithdraw)
    {
        if(amoutwithdraw<=balancebefore1)
            return("Withdrawal Done");
        else
            return("No Sufficient Balance");
    }
}

