package Model;
import Controller.*;

public abstract class Account { //Change account to abstract class from interface
    protected AccountController accountController;
    protected User userInfo; //new Member

    public AccountController getAccountController() {
        return accountController;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }
}
