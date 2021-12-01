package Controller;

import java.sql.Connection;
import java.util.concurrent.Flow.Subscription;

import Model.*;

public class Database {
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;
    private Connection connect;

    public void initializeConnection () {

    }
    
    public void addAccount (Account account) {
        
    }
    
    public Account getAccountInfo (String username) {
        
    }
    
    public void addProperty (Property property) {
        
    }
    
    public Property getProperty (int id) {
        
    }
    
    public void updatePropertyState (Property property, String state) {
        
    }
    
    public void addSubscription (RegRenter renter, Subscription subscription) {
        
    }
    
    public void changeFeePeriod (int periodDays) {
        
    }
    
    public void changeFeeAmount (int amount) {
        
    }
    
    public void updateProperty (Property property) {
        
    }
    
    public  ArrayList<Property> getPropertyList () {
        
    }
    
    public void updateMessage (String message, Property property) { //Send message to property's landlord's email
        
    }
}