package Model;

import java.util.ArrayList;

public class PropertyCatalog implements Subject {
    private ArrayList<Property> catalog;
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

    public void addProperty(Property p) {
        catalog.add(p);
    }

    public void setCatalog (ArrayList<Property> catalog) {
        this.catalog = catalog;
    }

    public void removeProperty(String address) {
        for (Property p : catalog) {
            if (p.getAddress().equals(address)) {
                catalog.remove(p);
                break;
            }
        }
    }
    
}
