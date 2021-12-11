package Controller;

import Model.AccountServer;
import Model.User;
import View.LoginAccountGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController extends DBInterfaceController{
    private AccountServer instance;
    private LoginAccountGUI theView;

    public LoginController(Database db, LoginAccountGUI view){
        super(db);
        this.instance = AccountServer.getInstance();
        this.theView = view;

        //When "Login" button is pressed, validate username and password
        LoginAccountGUI.getLoginButton().addActionListener (e -> {
            String username = LoginAccountGUI.getUsernamefield();
            String password = LoginAccountGUI.getPassfield();
            validate(username, password);
        });      
    }

    //Validates username and password
    public void validate (String username, String password) {
        System.out.println("Checking username from login controller: " + username);
        System.out.println("Checking password: " + password);

        if (instance.validate(username, password) == null) {
            theView.setLoginValid(false);
        }
        else {
            setGUIAccountType(username);
            theView.setLoginValid(true);
        }
    }

    //Sets Account type in the view
    public void setGUIAccountType(String username){
        User user = database.getAccountInfo(username);
        theView.setGUIAccountType(user.getAccountType().toString());
    }
}

