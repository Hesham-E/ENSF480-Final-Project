package Controller;

import java.util.ArrayList;

import Model.Property;
import Model.PropertyCatalog;

public class SearchController extends DBInterfaceController{
    public SearchController(Database db) {
        super(db);
        database.initializeConnection();
    }

    //Filters the property catalog based on attributes
    //returns an array list of similar properties
    public ArrayList<Property> filterCatalog (String type, int bedroomNo, int bathroomNo, boolean furnished, String cityQuad) {
        ArrayList<Property> catalog = database.getPropertyList();
        ArrayList<Property> similarProperties = new ArrayList<Property>();
        boolean isSimilar = true;

        for (Property p : catalog) {
            if (p.getFurnished() != furnished)
                isSimilar = false;
            else if (!p.getType().equals(type) && type != null)
                isSimilar = false;
            else if (p.getBedroomNo() != bedroomNo && bedroomNo != 0)
                isSimilar = false;
            else if (p.getBathroomNo() != bathroomNo && bathroomNo != 0)
                isSimilar = false;
            else if (!p.getCityQuad().equals(cityQuad) && cityQuad != null)
                isSimilar = false;

            if (isSimilar)
                similarProperties.add(p);
            
            isSimilar = true; //reset condition variable for next iteration
        }

        return similarProperties;
    }

    //Updates catalog member from database
    //returns catalog memeber after the update
    public PropertyCatalog fetchPropertyCatalog () {
        PropertyCatalog catalog = new PropertyCatalog();
        catalog.setCatalog(database.getPropertyList());
        return catalog;
    }

    //If there was an email system, a renter would be able to invoke this method to email a landlord based on their search of a specific property
    public String emailLandLord (Property property) {
        System.out.println("Email sent successfully");
        return ("Emailed sent successfully");
    }
    
}
