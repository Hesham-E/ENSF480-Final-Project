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
    //Filters all properties based on some search predicates
    public ArrayList<Property> performSearch (String type, int bedroomNo, int bathroomNo, boolean furnished, String cityQuad) {
        Database db = new Database();
        db.initializeConnection();
        SearchController DBInterface = new SearchController(db);
        ArrayList<Property> similarProperties = DBInterface.filterCatalog(type, bedroomNo, bathroomNo, cityQuad, furnished);
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
