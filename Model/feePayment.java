package Model;

import java.util.Date;

public class feePayment {
    public boolean paid;
    public static Date feePeriod;
    public static double feeAmount;
    
    public feePayment() {} // incomplete

    public void pay(Date feePeriod, double feeAmount) { // changed it up
    	
    	this.feeAmount = feeAmount;
    	this.paid = true;
    	
    	//incomplete
    }
    
    public void periodEnded(Date feePeriod) {
    	Date currDate = new Date();
        
        if(currDate.getTime() = feePeriod.getTime()) 
        	getNotified();
    }

    public Notifications getNotified() { //Notifications does not exist on diagram

    }

    public void modifyAmount() { //should this have a parameter?

    }
}
