package Model;

import java.util.ArrayList;

public class Search implements Observer{
    private Subject subject;
    private ArrayList<String> type;
    private ArrayList<Integer> bedroomNo;
    private ArrayList<Integer> bathroomNo;
    private ArrayList<String> furnished;
    private ArrayList<String> cityQuad;
    private DBInterfaceController searchController;
    

    public void update(ArrayList<Property> catalog) {

    }

    public void addType(String type) {

    }

    public void addBedroomNo(int num) {

    }

    public void addBathroomNo(int num) {

    }

    public void addFurnished(String f) {

    }

    public void addCityQuad(String quad) {

    }

    public void removeType(String type) {

    }

    public void removeBedroomNo(int num) {

    }
    
    public void removeBathroomNo(int num) {

    }
    
    public void removeFurnished(String f) {

    }
    
    public void removeCityQuad(String quad) {

    }
    
    public void becomeSubscribed() {

    }
    
    public void getNotifiedByEmail() {

    }
}
