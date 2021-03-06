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
    public ArrayList<Property> filterCatalog (String type, int bedroomNo, int bathroomNo, String cityQuad, boolean furnished) {
        ArrayList<Property> catalog = database.getPropertyList();
        ArrayList<Property> similarProperties = new ArrayList<Property>();
        boolean isSimilar = true;
        
        for(int i = 0; i < catalog.size(); i++){
            System.out.println("SearchController filter Catalog: " + catalog.get(i).getHouseid());
        }

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
    
    public ArrayList<Property> filterInputs (String TypeOption, String bedRoomOption, String bathOption, String AreaOption, String FurnOption)
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
    
    public void SubscribeFilter(String email, String TypeOption, String bedRoomOption, String bathOption, String AreaOption, String FurnOption)
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

        database.addSubscribe(email, TypeOption, bedRoomNo, bathroomNo, AreaOption, furnished);
    }
    
    
}
