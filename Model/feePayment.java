package Model;

import java.io.*;
import java.util.Date;
import java.util.Calendar;

public class feePayment {
    public boolean paid;
    public static Date feePeriod;
    public static double feeAmount;
    
    public feePayment() {} // incomplete

    public void pay(int period, double feeAmount) { // changed it up
    	this.feeAmount = feeAmount;
    	this.paid = true;
    	
    	Calendar c = Calendar.getInstance();
    	c.add(Calendar.DATE, period);
    	this.feePeriod = c.getTime();
    }
    
    public void periodEnded() { // I think this should be implemented somewhere else but let's leave it here for now
    	Date currDate = new Date();
        
        if(currDate.getTime() == feePeriod.getTime()) {
        	getNotified();
        	this.paid = false;
        }
    }

    public void getNotified() { // Notifications does not exist on diagram
    	System.out.println("Payment Period Ended!");
    	// Print that they have to renew it?? nothing else?
    	// Should it have return type Notification??
    }

    public void modifyAmount(double newAmount) {
    	this.feeAmount = newAmount;
    }
}
