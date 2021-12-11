package Model;
import Controller.*;

import java.util.ArrayList;

public class Landlord extends Account{
    private feePayment fee;
    private ArrayList<Property> properties;
    private DBInterfaceController registrationController;
    private int period = 60; // assuming landlord have to pay every 60 days
    private double amount = 50; // assuming that they have to pay 50 dollars every 60 days

    public Landlord() {
        userInfo = new User();
        userInfo.setAccountType(AccountType.LANDLORD);
    }
    
    //Adds property to properties array
    public void registerProperty (Property p) {
    	properties.add(p);
    	payFee();
    }

    //Updates fee status of the landlord
    public void payFee () {
    	feePayment fee = new feePayment();
    	fee.pay(this.period, this.amount);
    }
    
    //Returns feePayment object that belongs to the landlord
    public feePayment getFee() {
        return this.fee;
    }

    public void setFee(feePayment fee) {
        this.fee = fee;
    }
    
    public ArrayList<Property> getProperties() {
        return this.properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }
    
    public DBInterfaceController getRegistrationController() {
        return this.registrationController;
    }

    public void setRegistrationController(DBInterfaceController registrationController) {
        this.registrationController = registrationController;
    }
}