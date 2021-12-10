package Controller;

import Model.AccountServer;
import Model.AccountType;
import Model.Manager;
import View.ManagerAccountInfoGUI;
import Model.Property;
import Model.feePayment;
import Model.User;

import java.util.ArrayList;
import java.util.Date;

public class ManagerAccountController extends AccountController {
    private Manager theModel;
    private ManagerAccountInfoGUI theView;


    ManagerAccountController(Manager model, ManagerAccountInfoGUI view, Database db){
        super(db);
        this.theModel = model;
        this.theView = view;

        //When "Save Changes" button gets pressed, save new property info into database
        theView.getSaveChangesButton().addActionListener (e -> {
            updateDatabase();
        });

        //When "Change Fees" button gets pressed, update fee amount and period
        theView.getChangeFeesButton().addActionListener (e -> {
            setFees();
        });

    }

    //Sets the values to be shown for Manager account info
    public void performGUIStrategy () {
        //Set general account info that will be displayed
        theView.setGUIUsername(theModel.getUserInfo().getUsername());
        theView.setGUIName(theModel.getUserInfo().getName());
        theView.setGUIEmail(theModel.getUserInfo().getEmail());
        theView.setGUIAccountType(theModel.getUserInfo().getAccountType().toString());

        //Set fees that will be displayed
        theView.setGUIAmount(feePayment.getAmount());
        theView.setGUIAmount(feePayment.getPeriod());

        //Get all account info
        AccountServer instance = AccountServer.getInstance();
        ArrayList<User> userList = instance.getUsers();

        //Set landlord info for the view
        ArrayList<User> landlordInfoList;
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getAccountType() == AccountType.LANDLORD){
                landlordInfoList.add(userList.get(i));
            }
        }
        theView.setGUILandlordInfo(landlordInfoList);
        
        //Set registered renter info for the view
        ArrayList<User> regRenterInfoList;
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getAccountType() == AccountType.REGISTEREDRENTER){
                regRenterInfoList.add(userList.get(i));
            }
        }
        theView.setGUIRegRenterInfo(regRenterInfoList);

        //Set properties info for the view
        theView.setGUIProperties(database.getPropertyList());
    }

    //Updates database on new property info changes
    public void updateDatabase () {
        ArrayList<Property> newPropertyList = theView.getGUIProperties();
        for(int i = 0; i < newPropertyList.size(); i++){
            database.updateProperty(newPropertyList.get(i));
        }
    }

    //Changes fee amount and period
    public void setFees(){
        double amount = theView.getGUIAmount();
        feePayment.setAmount(amount);

        Date period = theView.getGUIPeriod();
        feePayment.setPeriod(period);
    }



}
