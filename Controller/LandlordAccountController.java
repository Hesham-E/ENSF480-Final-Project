package Controller;

import Model.Landlord;
import View.LandlordAccountInfoGUI;
import Model.Property;

import java.util.ArrayList;

//Controls what information from database gets shown in the Landlord account page
public class LandlordAccountController extends AccountController {
    private Landlord theModel;
    private LandlordAccountInfoGUI theView;

    LandlordAccountController(Landlord model, LandlordAccountInfoGUI view, Database db){
        super(db);
        database.initializeConnection();
        this.theModel = model;
        this.theView = view;

        //When "Save Changes" button gets pressed, save new property info into database
        // theView.getSaveChangesButton().addActionListener (e -> {
        //     updateDatabase();
        // }); No changes to be saved on LandlordAccountInfoGUI yet

        performGUIStrategy();
    }

    //Sets the values to be shown for Landlord account info
    public void performGUIStrategy () {
        theView.setGUIUsername(theModel.getUserInfo().getUsername());
        theView.setGUIName(theModel.getUserInfo().getName());
        theView.setGUIEmail(theModel.getUserInfo().getEmail());
        theView.setGUIAccountType(theModel.getUserInfo().getAccountType().toString());
        theView.setGUIProperties(theModel.getProperties());
    }


    //Updates database on new property info changes
    public void updateDatabase () {
        ArrayList<Property> newPropertyList = theView.getGUIProperties();
        for(int i = 0; i < newPropertyList.size(); i++){
            database.updateProperty(newPropertyList.get(i));
        }
    }

    
}
