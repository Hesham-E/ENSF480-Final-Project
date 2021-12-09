package Model;

import java.util.ArrayList;

//Helper class to set up subscriptions
//Follows observer design pattern in which this is the Subject 
public class PropertyCatalog implements Subject {
    private ArrayList<Property> catalog; //Catalog of properties, this can be a select few properties or all depending of them depending on search parameters
    private ArrayList<Observer> observers;

    public void registerObserver(Observer o) {
        observers.add(o);
        o.update(catalog);
    }

    public void removeObserver(Observer o) {
        for (Observer observer : observers) {
            if (observer.equals(o)) {
                observers.remove(observer);
                break;
            }
        }
    }

    public void notifyAllObserver() {
        for (Observer o : observers) {
            o.update(catalog);
        }
    }

    //Adds a property to the catalog
    public void addProperty(Property p) {
        catalog.add(p);
    }

    //Completely overwrites the entire catalog
    public void setCatalog (ArrayList<Property> catalog) {
        this.catalog = catalog;
    }

    //Removes a property from the catalog
    public void removeProperty(String address) {
        for (Property p : catalog) {
            if (p.getAddress().equals(address)) {
                catalog.remove(p);
                break;
            }
        }
    }
    
}
