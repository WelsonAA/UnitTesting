package System;

public class StubPaybill {
    private double balancebefore=2000.0;
    private String billtypesaved="Electricity";
    private  float amount;

    public String check(double billamount,String billtype){
            if(balancebefore>=billamount && billtype==billtypesaved)
                return("Bill paied Successfully");
            else
                return("Error insuffient balance or Error in billtype");



    }




}
