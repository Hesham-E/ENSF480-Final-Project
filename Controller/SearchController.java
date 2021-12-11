package Controller;

import java.util.ArrayList;

import Model.Property;
import Model.PropertyCatalog;

public class SearchController extends DBInterfaceController{
    public SearchController(Database db) {
        super(db);
        database.initializeConnection();
    }

    public ArrayList<Property> filterCatalog (String type, int bedroomNo, int bathroomNo, String cityQuad, boolean furnished) {
        ArrayList<Property> catalog = database.getPropertyList();
        ArrayList<Property> similarProperties = new ArrayList<Property>();
        boolean isSimilar = true;

        for (Property p : catalog) {
            if (p.getFurnished() != furnished)
                isSimilar = false;
            else if (!p.getType().equals(type) && (!type.equals("No preference")))
                isSimilar = false;
            else if (p.getBedroomNo() != bedroomNo && bedroomNo != 0)
                isSimilar = false;
            else if (p.getBathroomNo() != bathroomNo && bathroomNo != 0)
                isSimilar = false;
            else if (!p.getCityQuad().equals(cityQuad) && (!cityQuad.equals("No preference")))
                isSimilar = false;

            if (isSimilar)
                similarProperties.add(p);
            
            isSimilar = true; //reset condition variable for next iteration
        }

        return similarProperties;
    }
    
    public static ArrayList<Property> filterInputs (String TypeOption, String bedRoomOption, String BathOption, String AreaOption, String FurnOption)
    {
        int bedRoomNo = 0;
        if (bedRoomOption.equals("No preference")) {
            bedRoomNo = 0;
        }
        else {
            bedRoomNo = Integer.parseInt(bedRoomOption);
        }
        
        int bathroomNo = 0;
        if (bathOption.equals("No preference")) {
        	bathroomNo = 0;
        }
        else {
        	bathroomNo = Integer.parseInt(bathOption);
        }
        
        boolean furnished;
        if (FurnOption.equals("Yes")) {
        	furnished = true;
        }
        else {
        	furnished = false;
        }

        return filterCatalog(TypeOption, bedRoomNo, bathroomNo, AreaOption, furnished);
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
