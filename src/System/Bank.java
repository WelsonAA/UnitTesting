package System;

import java.util.ArrayList;

public final class Bank {
    private final String Name="HSBC";
    private final String Address="Abdou Pasha Campus";
    public static ArrayList<Account> Accounts=new ArrayList<>();
    public static Account check(String username, String password){
        Account temp=new Account(username, password);
        for(int i=0;i<Accounts.size();i++){
            if(temp.equals(Accounts.get(i)))
                return Accounts.get(i);
        }
        return null;
    }
    public static Account check(Integer accountNo){
        for(int i=0;i<Accounts.size();i++){
            if(accountNo.equals(Accounts.get(i).getAccountNo()))
                return Accounts.get(i);
        }
        return null;

    }
    public static void addAccount(Account acc){
        Accounts.add(acc);
    }
    public static ArrayList<Account> getAccounts() {
        return Accounts;
    }
}
