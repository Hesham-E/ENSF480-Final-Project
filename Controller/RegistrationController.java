package Controller;

import Model.Account;
import Model.AccountType;
import Model.Landlord;
import Model.Manager;
import Model.RegRenter;
import Model.User;
import View.RegisterAccountGUI;

public class RegistrationController extends DBInterfaceController{
    private RegisterAccountGUI theView;

    public RegistrationController (Database db, RegisterAccountGUI view) {
        super(db);
        db.initializeConnection();
        
        theView = view;

        theView.addActionListener (e -> {
            createAccount(theView.getGUIUsername(), theView.getGUIPassword(), theView.getGUIName(), theView.getGUIEmail(), theView.getGUIAccountType());
        });
    }

    //added accountType
    //Creates an account in the database based on what is inputted in the GUI
    public void createAccount (String username, String password, String name, String email, AccountType accountType) {
        User userInfo = new User();
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        userInfo.setName(name);
        userInfo.setEmail(email);
        userInfo.setAccountType(accountType);
        Account account;

        if (accountType == AccountType.LANDLORD) {
            account = new Landlord();
            account.setUserInfo(userInfo);
        }
        else if (accountType == AccountType.MANAGER) {
            account = new Manager();
            account.setUserInfo(userInfo);
        }
        else {
            account = new RegRenter();
            account.setUserInfo(userInfo);
        }

        super.addDatabaseAccount(account);
    }
}
