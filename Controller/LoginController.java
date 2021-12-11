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
        theView.getLoginButton().addActionListener (new ActionListener() {
            public void actionPerformed (ActionEvent a) {
            String username = theView.getUsernamefield().toString();
            String password = theView.getPassfield().toString();
            validate(username, password);
            }
        });      
    }

    //Validates username and password
    public void validate (String username, String password) {
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

