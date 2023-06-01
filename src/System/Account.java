package System;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;


public class Account {
    private Integer AccountNo;
    private String UserName;
    private String Password;
    private Double Balance;
    private LocalDate BirthDate;
    private String Address;
    private String ZipCode;

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    static int id=0;
    private String SSN;
    private String CardNo;
    private String TelephoneNo;
    private String Email;
    ArrayList<Transaction> Transactions=new ArrayList<Transaction>();
    ArrayList<Bill> Bills=new ArrayList<Bill>();

    private void withdraw(Double amount){
        if(amount>Balance){
            //Error
        }else {
            Withdraw w =new Withdraw(amount,LocalDate.now(),this.getBalance());
            Transactions.add(w);
            this.Balance -= amount;
        }
    }
    private void deposit(Double amount){
        Deposit d =new Deposit(amount,LocalDate.now(),this.getBalance());
        Transactions.add(d);
        this.Balance+=amount;
    }

    private void transfer(Double amount,String receiverAccountNo){

        if(amount>Balance){
            //Error
        }else {
            Transfer t =new Transfer(amount,LocalDate.now(),receiverAccountNo,this.getBalance());
            Transactions.add(t);
            this.Balance -= amount;
        }
    }
    private void payBill(Double amount, String description,BillType bt){
        if(amount>Balance){
            //Error
        }else {
            Bill b=new Bill(amount,description,bt,LocalDate.now(),this.getBalance());
            Bills.add(b);
            this.Balance -= amount;
        }
    }
    private void purchaseItem(Double amount,String storeName,String itemName){
        if(amount>Balance){
            //Error
        }else {
            Item i = new Item(amount, storeName, itemName);
            payBill(amount,"",BillType.PURCHASED_ITEMS);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(getAccountNo(), account.getAccountNo());
    }

    private void printBankStatement(){
    }
    public Account(String userName, String password, Double balance, LocalDate birthDate) {
        UserName = userName;
        Password = password;
        Balance = balance;
        BirthDate = birthDate;
        AccountNo=id++;
    }

    public Integer getAccountNo() {
        return AccountNo;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public Double getBalance() {
        return Balance;
    }
    public String getAddress() {
        return Address;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public String getSSN() {
        return SSN;
    }

    public String getCardNo() {
        return CardNo;
    }

    public String getTelephoneNo() {
        return TelephoneNo;
    }

    public String getEmail() {
        return Email;
    }
}
