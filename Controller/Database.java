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
        try {                    

            String query = "INSERT INTO accounts (Name, Email, Username, Password, AccountType)"
            + " VALUES(?, ?, ?, ?, ?)";
            PreparedStatement myStmt = this.connect.prepareStatement(query);

            myStmt.setString(1, account.getUserInfo().getName());
            myStmt.setString(2, account.getUserInfo().getEmail());
            myStmt.setString(3, account.getUserInfo().getUsername());
            myStmt.setString(4, account.getUserInfo().getPassword());
            myStmt.setString(5, account.getUserInfo().getAccountType().toString());

            myStmt.execute();
            myStmt.close();
        } 

        catch (SQLException ex) {
            ex.printStackTrace();
        }  
    }
    
    public User getAccountInfo (String username) {//Changed return type to User from Account
        User u = new User();
        try {                    
            Statement myStmt = this.connect.createStatement();
            ResultSet results;
            results = myStmt.executeQuery("SELECT * FROM accounts");
            while (results.next()){

            //Finds matching username in the database
            if(results.getString("Username").equals(username)){
       
                //Get account info 
                u.setUsername(results.getString("Username"));
                u.setPassword(results.getString("Password"));
                u.setName(results.getString("Name"));
                u.setEmail(results.getString("Email"));
                u.setAccountType("accountType");// Need to convert accountType string to enum!!!!!!!!!!!!!!!!!!!
            }
        }
        myStmt.close();
        } 
        
        catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return u;
        
    }
    
    //Adds property to database when registering property
    public void addProperty (Property property) {
        
        try {                    
            String query = "INSERT INTO property (HouseID, LandlordUsername, Status, Address, Type, BedroomNo, BathroomNo, Furnished, CityQuad, Cost, DateListed, FeeDueDate)"
            + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement myStmt = this.connect.prepareStatement(query);

            myStmt.setInt(1, property.getHouseid());
            myStmt.setString(2, property.getLandlord().getUserInfo().getUsername());
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

            //Add 60 days to dateListed to represent fee due date
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
            //Getting results
            Statement myStmt = this.connect.createStatement();
            ResultSet results;
            results = myStmt.executeQuery("SELECT * FROM property");
            while (results.next()){

            //Finds matching houseid in the database
            if(results.getInt("HouseID") == id){
       
                //Get property info 

                
            }
        }
        myStmt.close();

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

s            //Populate propertyList with all properties and their info stored in the database
            while (results.next()){
                Property p = new Property();
                p.setHouseid(results.getInt("HouseID"));

                //Setting landlord information
                User landlordUserInfo = getAccountInfo(results.getString("LandlordUsername"));
                Landlord l = new Landlord();
                l.setUserInfo(landlordUserInfo);
                p.setLandlord(l);

                //Setting renter information
                //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                //Does property need to have renter info?
                User renterUserInfo = getAccountInfo(results.getString("LandlordUsername"));
                RegRenter r = new RegRenter();
                r.setUserInfo(renterUserInfo);
                p.setRenter(r);

                PropertyState s = PropertyState.RENTED;
                p.setStatus(s);
                
                p.setAddress(results.getString("Address"));
                p.setType(results.getString("Type"));
                p.setBedroomNo(results.getInt("BedroomNo"));
                p.setBathroomNo(results.getInt("BathroomNo"));
                p.setFurnished(results.getBoolean("Furnished"));
                p.setCityQuad(results.getString("CityQuad"));
                p.setCost(results.getDouble("Cost"));
                p.setDateListed(results.getTimestamp("dateListed"));
                p.setDateRented(results.getTimestamp("dateRented"));
    
                propertyList.add(p);
            
            }
        myStmt.close();
        } 
        
        catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return propertyList;
   }
    
    //Adds message from renter to landlord to the database 
    public void updateMessage (String message, Property property) { //Send message to property's landlord's email
        try {                    

            String query = "INSERT INTO message (LandlordEmail, Message)"
            + " VALUES(?, ?)";
            PreparedStatement myStmt = this.connect.prepareStatement(query);

            myStmt.setString(1, property.getLandlord().getUserInfo().getEmail());
            myStmt.setString(2, message);


            myStmt.execute();
            myStmt.close();
        } 

        catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
}

/*
Questions:
everytime we getProperty() we make a new property object, this affects the totalhouse count
so can we get rid of totalNumberOfHouses static variable

can setStatus function in Property take in a string as an argument instead and convert the string to the corresponding enum
can set

do we need to know who rented the property can we just say when it got rented
*/
