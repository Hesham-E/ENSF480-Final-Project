package Controller;

import Model.Landlord;
import Model.Property;
import Model.PropertyState;
import View.RegisterPropertyGUI;

public class RegisterPropertyController extends DBInterfaceController{
    private Property regProperty;
    private RegisterPropertyGUI theView;

    public RegisterPropertyController (Database db, RegisterPropertyGUI view) {
        super(db);
        database.initializeConnection();
        
        theView = view;

        //Forwards text field items based on GUI to registerProperty() when "Registration" button is pressed
        theView.getRegButton().addActionListener (e -> {
            registerProperty(theView.getLocfield(), theView.getTypebox(), 
                             theView.getBedbox(), theView.getBathbox(), theView.getFurnishbox(), 
                             theView.getAreafield(), theView.getPricefield(), new Landlord() /*theView.getGUILandlord()*/, PropertyState.ACTIVE /*theView.getGUIState()*/);
        });
    }

    //Registers property in database based on what is inputted on GUI
    public void registerProperty (String address, String type, int bedroomNo, int bathroomNo, boolean furnished, String cityQuad, double cost, Landlord landlord, PropertyState state) {
        regProperty = new Property();
        regProperty.setAddress(address);
        regProperty.setBathroomNo(bathroomNo);
        regProperty.setBedroomNo(bedroomNo);
        regProperty.setCityQuad(cityQuad);
        regProperty.setCost(cost);
        regProperty.setFurnished(furnished);
        regProperty.setLandlord(landlord);
        regProperty.setStatus(state);

        database.addProperty(regProperty);
    }
}
