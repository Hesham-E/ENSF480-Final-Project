package Controller;

import Model.AccountServer;
import Model.User;
import View.LoginAccountGUI;

public class LoginController extends DBInterfaceController{
    private AccountServer instance;
    private LoginAccountGUI theView;

    LoginController(Database db, LoginAccountGUI view){
        super(db);
        this.instance = AccountServer.getInstance();
        this.theView = view;

        //When "Login" button is pressed, validate username and password
        theView.getLoginButton().addActionListener (e -> {
            String username = theView.getUsernamefield().toString();
            String password = theView.getPassfield().toString();
            validate(username, password);
        });      
    }

    public void validate (String username, String password) {
        if (instance.validate(username, password) == null) {
            theView.setLoginValid(false);
        }
        else {
            theView.setLoginValid(true);
        }
    }

    public String getDatabaseAccountType(){
        User user = database.getAccountInfo(theView.getUsernamefield().toString());
        return user.getAccountType().toString();
    }
}

