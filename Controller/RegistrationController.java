package Controller;

import Model.Account;
import Model.AccountType;
import Model.Landlord;
import Model.Manager;
import Model.RegRenter;
import Model.User;
import View.RegGUI;

public class RegistrationController extends DBInterfaceController{
    private RegGUI theView;

    public RegistrationController (Database db, RegGUI view) {
        super(db);
        db.initializeConnection();
        
        theView = view;

        theView.getRegButton().addActionListener (e -> {
            createAccount(theView.getUsernamefield(), theView.getPassfield(), theView.getEmailfield(), theView.getEmailfield(), theView.getUserType());
        });
    }

    //added accountType
    public void createAccount (String username, String password, String name, String email, String accountTypeString) {
        User userInfo = new User();
        AccountType accountType = AccountType.REGISTEREDRENTER;
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        userInfo.setName(name);
        userInfo.setEmail(email);

        if (accountTypeString.equals("Landlord"))
            accountType = AccountType.LANDLORD;
        else if (accountTypeString.equals("Renter"))
            accountType = AccountType.REGISTEREDRENTER;
            
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
