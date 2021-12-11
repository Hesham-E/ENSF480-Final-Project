package Controller;

import Model.Account;
import Model.AccountServer;
import Model.AccountType;
import Model.Landlord;
import Model.Manager;
import Model.RegRenter;
import Model.User;
import View.RegGUI;

public class RegistrationController extends DBInterfaceController{
    private RegGUI theView;
    private AccountServer instance;

    public RegistrationController (Database db, RegGUI view) {
        super(db);
        database.initializeConnection();
        
        theView = view;

        theView.getRegButton().addActionListener (e -> {
            validateEmail(theView.getEmailfield());
            validateUsername(theView.getUsernamefield());
            
            if (theView.getUniqueUsername() && theView.getUniqueemail()) {
                createAccount(theView.getUsernamefield(), theView.getPassfield(), theView.getEmailfield(), theView.getNamefield(), theView.getUserType());
            }
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

    public void validateEmail (String email) {
        theView.setUniqueemail(instance.registrationEmailUnique(email));
    }

    public void validateUsername (String username) {
        theView.setUniqueUsername(instance.registrationUsernameUnique(username));
    }


}


