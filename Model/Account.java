package Model;
import Controller.*;

public abstract class Account { //Change account to abstract class from interface
    protected AccountController accountController;
    protected User userInfo; //new Member

    public AccountController getAccountController() {
        return accountController;
    }

    //Returns a User object with all the user's information, also allows modification
    public User getUserInfo() {
        return userInfo;
    }

    //Change the user's information
    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }
}
