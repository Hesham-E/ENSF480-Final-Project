package Controller;

import java.util.ArrayList;

import Model.Property;
import Model.PropertyCatalog;

public class SearchController extends DBInterfaceController{
    public SearchController(Database db) {
        super(db);
        database.initializeConnection();
    }

    public ArrayList<Property> filterCatalog (String type, int bedroomNo, int bathroomNo, boolean furnished, String cityQuad) {
        ArrayList<Property> catalog = database.getPropertyList();
        ArrayList<Property> similarProperties = new ArrayList<Property>();
        boolean isSimilar = true;

        for (Property p : catalog) {
            if (p.getFurnished() != furnished)
                isSimilar = false;
            else if (!p.getType().equals(type))
                isSimilar = false;
            else if (p.getBedroomNo() != bedroomNo)
                isSimilar = false;
            else if (p.getBathroomNo() != bathroomNo)
                isSimilar = false;
            else if (!p.getCityQuad().equals(cityQuad))
                isSimilar = false;

            if (isSimilar)
                similarProperties.add(p);
            
            isSimilar = true; //reset condition variable for next iteration
        }

        return similarProperties;
    }

    public PropertyCatalog fetchPropertyCatalog () {
        PropertyCatalog catalog = new PropertyCatalog();
        catalog.setCatalog(database.getPropertyList());
        return catalog;
    }

    public String emailLandLord (Property property) {
        System.out.println("Email sent successfully");
        return ("Emailed sent successfully");
    }
    
}
