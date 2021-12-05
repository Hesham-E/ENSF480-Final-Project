package Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.Flow.Subscription;

import Model.*;

public class Database {
    public final String DBURL = "jdbc:mysql://localhost/rent_system";
    public final String USERNAME = "alliana";
    public final String PASSWORD = "ensf409";
    private Connection connect;

    public void initializeConnection () {
        try{
            this.connect = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
          }
      
          catch(SQLException e){
            System.out.println("Error connection to database.");
            System.exit(1);
          }
    }
    
    public void addAccount (Account account) {
        
    }
    
  // public Account getAccountInfo (String username) {
/*
        try {                    
            Statement myStmt = this.connect.createStatement();
            ResultSet results;
            results = myStmt.executeQuery("SELECT * FROM accounts");
            while (results.next()){

            //Finds matching username in the database
            if(results.getString("Username").equals(username)){
       
                //Get account info 
                
            }
        }
        myStmt.close();
        } 
        
        catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return ;
        */
 //   }
    
    //Used when registering property
    public void addProperty (Property property) {
        
        try {                    

            String query = "INSERT INTO property (HouseID, LandlordID, Status, Address, Type, BedroomNo, BathroomNo, Furnished, CityQuad, Cost, DateListed, FeeDueDate)"
            + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement myStmt = this.connect.prepareStatement(query);

            myStmt.setInt(1, property.getHouseid());
            //myStmt.setString(2, property.getLandlord());
            //idk how to get landlord id!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            myStmt.setString(3, property.getStatus().toString());
            myStmt.setString(4, property.getAddress());
            myStmt.setString(5, property.getType());
            myStmt.setInt(6, property.getBedroomNo());
            myStmt.setInt(7, property.getBathroomNo());
            myStmt.setBoolean(8, property.getFurnished());
            myStmt.setString(9, property.getCityQuad());
            myStmt.setDouble(10, property.getCost());

            java.sql.Date dateListed = new java.sql.Date(property.getDateListed().getTime());
            myStmt.setDate(11, dateListed);

            Date dueDate = Date.valueOf(dateListed.toLocalDate().plusDays(60));
            java.sql.Date feeDueDate = new java.sql.Date(dueDate.getTime());

            myStmt.setDate(12, feeDueDate);

            myStmt.execute();
            myStmt.close();
        } 

        catch (SQLException ex) {
            ex.printStackTrace();
        }   
    }
    
    public Property getProperty (int id) {
        Property p = new Property();
        try {
            String query = "SELECT * FROM property * WHERE HouseID = ?";
            PreparedStatement Stmt = this.connect.prepareStatement(query);
            Stmt.setInt(2, id);

            //Getting results
            ResultSet resultSet = Stmt.executeQuery();


       } 

       catch (SQLException ex) {
           ex.printStackTrace();
       }
       return p;
    }
    
    //Updates property state 
    public void updatePropertyState (Property property, String state) {
        try {
            String query = "UPDATE property set state = ? where HouseID = ?";
            PreparedStatement Stmt = this.connect.prepareStatement(query);
            Stmt.setString(1, state);
            Stmt.setInt(2, property.getHouseid());

            Stmt.executeUpdate();
       } 

       catch (SQLException ex) {
           ex.printStackTrace();
       }
    }
    
    public void addSubscription (RegRenter renter, Subscription subscription) {
        
    }
    
    public void updateProperty (Property property) {
        //Deletes outdated property in database
        deleteProperty(property.getHouseid());

        //Adds new property to database
        addProperty(property);
    }

    public void deleteProperty(int propertyID){
        try {
             //Delete property with the corresponding propertyID
            String query = "DELETE FROM property WHERE HouseID = ?";
            PreparedStatement myStmt = this.connect.prepareStatement(query);
            myStmt.setInt(1, propertyID);             
            myStmt.executeUpdate();
            myStmt.close();
        } 

        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public  ArrayList<Property> getPropertyList () {
        ArrayList<Property> propertyList = new ArrayList<Property>(1);
        try {                    
            Statement myStmt = this.connect.createStatement();
            ResultSet results;
            results = myStmt.executeQuery("SELECT * FROM accounts");

            //Populate propertyList with all properties stored in the database
            while (results.next()){
                Property p = new Property();
                PropertyState s = PropertyState.RENTED;
                p.setStatus(s);
        
                p.setAddress(results.getString("Address"));
                p.setType(results.getString("Type"));
                p.setBedroomNo(results.getInt("BedroomNo"));
                p.setBathroomNo(results.getInt("BathroomNo"));
                p.setFurnished(results.getBoolean("Furnished"));
                p.setCityQuad(results.getString("CityQuad"));
                p.setCost(results.getDouble("Cost"));

                //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                //find landlord account info
                Landlord l =  new Landlord();
                p.setLandlord(l);

                p.setDateListed(results.getTimestamp("dateListed"));
                p.setDateRented(results.getTimestamp("dateRented"));
                
                //need to get renter account!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                //p.setRegRenter();
    
                propertyList.add(p);
            
            }
        myStmt.close();
        } 
        
        catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return propertyList;
   }
    
    public void updateMessage (String message, Property property) { //Send message to property's landlord's email
        
    }
}

/*
Concerns:
everytime we get property we make a new property object, this affects the houseID count
more than one property object with same info but different houseID since static 

can setStatus function in Property take in a string as an argument instead and convert the string to the corresponding enum

*/
