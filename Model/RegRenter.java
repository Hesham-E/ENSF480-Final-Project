package Model;

import java.util.ArrayList;

import Controller.SearchController;

public class RegRenter implements Account{
    private Search subscription;
    private Property rental;

    public RegRenter () {

    }
    
    //NOT ON UML
    public ArrayList<Property> performSearch (String type, Integer bedroomNo, Integer bathroomNo, String furnished, String cityQuad) {
        Search query = new Search  (type, bedroomNo, bathroomNo, furnished, cityQuad);
        SearchController DBInterface;
        ArrayList<Property> similarProperties = DBInterface.findSimilarProperties(query); //This method does not exist yet
        return similarProperties;
    } 

    //NOT ON UML
    public void subscribeToSearch (String type, Integer bedroomNo, Integer bathroomNo, String furnished, String cityQuad) {
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
