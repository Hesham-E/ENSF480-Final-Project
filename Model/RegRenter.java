package Model;

import java.util.ArrayList;

import javax.xml.crypto.Data;

import Controller.Database;
import Controller.SearchController;

public class RegRenter extends Account{
    private Search subscription;
    private Property rental;

    public RegRenter () {

    }
    
    //NOT ON UML
    public ArrayList<Property> performSearch (String type, int bedroomNo, int bathroomNo, boolean furnished, String cityQuad) {
        Database db = new Database();
        db.initializeConnection();
        SearchController DBInterface = new SearchController(db);
        ArrayList<Property> similarProperties = DBInterface.filterCatalog(type, bedroomNo, bathroomNo, cityQuad, furnished);
        return similarProperties;
    } 

    //NOT ON UML
    public void subscribeToSearch (String type, Integer bedroomNo, Integer bathroomNo, boolean furnished, String cityQuad) {
        PropertyCatalog subject = new PropertyCatalog();
        subject.setCatalog(performSearch(type, bedroomNo, bathroomNo, furnished, cityQuad));
        subscription.setSubject(subject);
    }

    public void setRentalProperty (Property rental) {
        this.rental = rental;
    }

    public Property getRentalProperty () {
        return rental;
    }
    
}
