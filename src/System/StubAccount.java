package System;

public class StubAccount {
    private String user;
    private String password;

    public int accountcouter=0;

    public StubAccount(String user, String password) {
        this.user = user;
        this.password = password;
        accountcouter++;

    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public int getAccountcouter() {
        return accountcouter;
    }
}
