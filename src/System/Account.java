package System;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;


public class Account {
    private Integer AccountNo;
    public String firstName, middleName,lastName;
    private String UserName;
    private String Password;
    private Double Balance;
    private LocalDate BirthDate;
    public String notification;
    public Account(String userName, String password) {
        UserName = userName;
        Password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    private String Address;
    private String ZipCode;
    public LocalDate getBirthDate() {
        return BirthDate;
    }
    static int id=0;
    private String SSN;
    private String CardNo;
    private String TelephoneNo;
    ArrayList<Transaction> Transactions=new ArrayList<Transaction>();
    ArrayList<Bill> Bills=new ArrayList<Bill>();

    public void withdraw(Double amount)throws TransactionsExceptions{
        if(amount>Balance){
            throw new InsufficientBalance();
        }else if(amount<=0){
            throw new InvalidAmount();
        }
        else {
            Withdraw w =new Withdraw(amount,LocalDate.now(),this.getBalance());
            Transactions.add(w);
            this.Balance -= amount;
            this.notification+="Successful Withdraw -"+amount+"\n";
        }
    }
    public void deposit(Double amount)throws TransactionsExceptions{
        if(amount<=0){
            throw new InvalidAmount();
        }else {
            Deposit d = new Deposit(amount, LocalDate.now(), this.getBalance());
            Transactions.add(d);
            this.Balance += amount;

            this.notification+="Successful Deposit +"+amount+"\n";
        }
    }

    public void transfer(Double amount,Integer receiverAccountNo)throws TransactionsExceptions {

        if(amount>Balance){
            throw new InsufficientBalance();
        }else if(amount<=0){
            throw new InvalidAmount();
        }else if(Bank.check(receiverAccountNo)==null){
            throw new InvalidAccountNo();
        }
        else {
            Transfer t =new Transfer(amount,LocalDate.now(),receiverAccountNo,this.getBalance());
            Transactions.add(t);
            this.Balance -= amount;

            this.notification+="Successful Transfer -"+amount+"\n";
        }
    }
    public void payBill(Double amount, BillType bt)throws TransactionsExceptions{
        if(amount>Balance){
            throw new InsufficientBalance();
        }else if(amount<=0){
            throw new InvalidAmount();
        }else {
            Bill b=new Bill(amount,bt,LocalDate.now(),this.getBalance());
            Bills.add(b);
            this.Balance -= amount;

            this.notification+="Successful Bill Payment -"+amount+"\n";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(getUserName(), account.getUserName()) && Objects.equals(getPassword(), account.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getPassword());
    }

    public void purchaseItem(Double amount, String storeName, String itemName)throws TransactionsExceptions{

         Item i = new Item(amount, storeName, itemName);
         payBill(amount,BillType.PURCHASED_ITEMS);

    }



    public void printBankStatement(){
    }
    public Account(String userName, String password, Double balance, LocalDate birthDate) {
        UserName = userName;
        Password = password;
        BirthDate = birthDate;
        AccountNo=id++;
        this.Balance=balance;
        this.notification="";
    }

    public Account(String userName, String password, LocalDate birthDate, String address,
                   String zipCode, String SSN, String cardNo, String telephoneNo,String firstName,String middleName,String lastName) {
        AccountNo=id++;
        UserName = userName;
        Password = password;
        Balance = 0.0;
        BirthDate = birthDate;
        Address = address;
        ZipCode = zipCode;
        this.SSN = SSN;
        CardNo = cardNo;
        TelephoneNo = telephoneNo;
        this.firstName=firstName;
        this.middleName=middleName;
        this.lastName=lastName;
        this.notification="";
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

}
