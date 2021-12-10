package Model;

public class User {
    //Changed all member types to private
    private String username;
    private String password;
    private String name;
    private String email;
    private AccountType accountType;

    public User(String username, String password, String name, String email, String accountType){
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.accountType = AccountType.valueOf(accountType);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccountType getAccountType() {
        return this.accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

}
