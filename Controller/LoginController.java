package Controller;

import Model.AccountServer;
import View.LoginAccountGUI;
import java.awt.event.*;

public class LoginController extends DBInterfaceController{
    private AccountServer instance;
    private LoginAccountGUI theView;

    LoginController(Database db, LoginAccountGUI view){
        super(db);
        this.instance = AccountServer.getInstance();
        this.theView = view;

        //When "Login" button is pressed, validate username and password
        theView.getLoginButton().addActionListener (e -> {
            String username = theView.getGUIUsername();
            String password = theView.getGUIPassword();
            validate(username, password);
        });      
    }

    public void validate (String username, String password) {
        instance.validate(username, password);
    }
}

/*
Need error handling when password or username is incorrect
*/

