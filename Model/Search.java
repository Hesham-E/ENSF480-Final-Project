package Model;
import Controller.SearchController;

import java.util.ArrayList;

public class Search implements Observer{
    //Everything except subject and searchController used to be ArrayLists
    private Subject subject;
    private String type; //Should we make this an enum?
    private int bedroomNo;
    private int bathroomNo;
    private boolean furnished; //Should we make this an enum?
    private String cityQuad; //Should we make this an enum?
    private SearchController searchController;
    

    public Search (String type, int bedroomNo, int bathroomNo, boolean furnished, String cityQuad) {
        this.type = type;
        this.bathroomNo = bathroomNo;
        this.bedroomNo = bedroomNo;
        this. furnished = furnished; 
        this.cityQuad = cityQuad;
    }

    public void update(ArrayList<Property> catalog) {

    }

    public void setSubject(Subject s) {
        subject = s;
        subject.registerObserver(this);
    }

    public void addType(String type) {
        this.type = type;
    }

    public void addBedroomNo(int num) {
        bedroomNo = num;
    }

    public void addBathroomNo(int num) {
        bathroomNo = num;
    }

    public void addFurnished(boolean f) {
        furnished = true;
    }

    public void addCityQuad(String quad) {
        cityQuad = quad;
    }

    public void removeType() {
        type = "";
    }

    public void removeBedroomNo() { 
        bedroomNo = 0;
    }
    
    public void removeBathroomNo() {
        bathroomNo = 0;
    }
    
    public void removeFurnished() {
        furnished = false;
    }
    
    public void removeCityQuad() {
        cityQuad = "";
    }
    
    //REMOVED  getSubscribed and added it to RegRenter as method "subscribeToSearch"

    public void getNotifiedByEmail() {
        System.out.println("Subscribers notified by email!");
    }
}
