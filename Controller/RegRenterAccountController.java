package Controller;

import Model.RegRenter;
import View.RegRenterAccountInfoGUI;
import Model.Property;
import java.util.ArrayList;

public class RegRenterAccountController extends AccountController {
    private RegRenter theModel;
    private RegRenterAccountInfoGUI theView;
    private SearchController searchController;

    RegRenterAccountController(RegRenter model, RegRenterAccountInfoGUI view, Database db){
        super(db);
        this.theModel = model;
        this.theView = view;
        this.searchController = new SearchController(db);

        //When "Save Changes" button gets pressed, update subscribed properties for model and view
        theView.getSaveChangesButton().addActionListener (e -> {
            updateGUISubscribedProperties();
        });
    }

    //Sets the values to be shown for RegRenter account info
    public void performGUIStrategy () {
        theView.setGUIUsername(theModel.getUserInfo().getUsername());
        theView.setGUIName(theModel.getUserInfo().getName());
        theView.setGUIEmail(theModel.getUserInfo().getEmail());
        theView.setGUIAccountType(theModel.getUserInfo().getAccountType().toString());
        theView.setGUISubscription(theModel.getProperties());
    }


    //Updates subscription then shows new subscription to reg renter account page
    public void updateSubscribedProperties() {

        //Getting new filter options for subscription
        String type = theView.getGUIType();
        int bedroomNo = theView.getGUIBedroomNo();
        int bathroomNo = theView.getGUIBathroomNo();
        boolean furnished = theView.getGUIFurnished();
        String cityQuad = theView.getGUICityQuad();

        ArrayList<Property> newSubscribedList = searchController.filterCatalog(type, bedroomNo, bathroomNo, furnished, cityQuad);

        //Update renter model subscribed list
        theModel.subscribeToSearch(type, bedroomNo, bathroomNo, furnished, cityQuad);

        //Set new subscribed property list
        theView.setGUISubscribedProperties(newSubscribedList);
         
    }
    
}
