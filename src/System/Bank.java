package System;

import java.util.ArrayList;

final class Bank {
    private final String Name;
    private final String Address;
    private static ArrayList<Account> Accounts=new ArrayList<>();

    public Bank(String name, String address) {
        Name = name;
        Address = address;
    }
}
