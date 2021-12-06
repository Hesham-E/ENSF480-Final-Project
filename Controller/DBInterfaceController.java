package Controller;
import Model.*;
import java.util.ArrayList;

public abstract class DBInterfaceController {//changed from interface to abstract 
    protected Database database;

    public DBInterfaceController(Database db){
        this.database = db;
        db.initializeConnection();
    }

    public void addDatabaseAccount(Account account){
        database.addAccount(account);
    }

    public void getDatabaseAccountInfo(String username){
        database.getAccountInfo(username);
    }

    public void addDatabaseProperty(Property property){
        database.addProperty(property);
    }

    public Property getDatabaseProperty(int id){
        Property p = database.getProperty(id);
        return p;
    }

    public void updateDatabasePropertyState(Property property, String state){
        database.updatePropertyState(property, state);
    }

    public void updateDatabaseProperty(Property property){
        database.updateProperty(property);
    }

    public void deleteDatabaseProperty(int propertyID){
        database.deleteProperty(propertyID);
    }

    public ArrayList<Property> getDatabasePropertyList(){
        ArrayList<Property> propertyList = database.getPropertyList();
        return propertyList;
    }

    public void updateDatabaseMessage(String message, Property property){
        database.updateMessage(message, property);
    }

}
