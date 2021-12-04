package Model;

import java.util.ArrayList;

public class Landlord implements Account{
    private feePayment fee;
    private ArrayList<Property> properties;
    private DBInterfaceController registrationController;

    public Landlord() {} //incomplete
    
    public void registerProperty (Property p) {
    	properties.add(p);
    	payFee();
    }

    public void payFee () {
    	feePayment fee = new feePayment();
    	fee.pay(period,  amount); // incomplete
    }
    
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

/* Few Notes:
- Not sure about payFee
- Not sure of Properties setter and getter
*/