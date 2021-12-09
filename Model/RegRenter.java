package Model;

import java.util.ArrayList;

import Controller.Database;
import Controller.SearchController;

public class RegRenter extends Account{
    private Search subscription;
    private Property rental;

    public RegRenter () {

    }
    
    //NOT ON UML
    //Filters out properties which match the provided attributes
    //Returns an ArrayList of properties that have common attributes
    public ArrayList<Property> performSearch (String type, Integer bedroomNo, Integer bathroomNo, boolean furnished, String cityQuad) {
        SearchController DBInterface = new SearchController(new Database());
        ArrayList<Property> similarProperties = DBInterface.filterCatalog(type, bedroomNo, bathroomNo, furnished, cityQuad); //This method does not exist yet
        return similarProperties;
    } 

    //NOT ON UML
    //Conducts a search based on provided properties and subscribes to that search
    public void subscribeToSearch (String type, Integer bedroomNo, Integer bathroomNo, boolean furnished, String cityQuad) {
        PropertyCatalog subject = new PropertyCatalog();
        subject.setCatalog(performSearch(type, bedroomNo, bathroomNo, furnished, cityQuad));
        subscription.setSubject(subject);
    }

    //Used when renter's lease changes
    public void setRentalProperty (Property rental) {
        this.rental = rental;
    }

    //Returns renter's rental, or lack thereof
    public Property getRentalProperty () {
        return rental;
    }
    
}
