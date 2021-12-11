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
    
    //Updates pay status
    public void periodEnded() {
    	Date currDate = new Date();
        
        if(currDate.getTime() == feePeriod.getTime()) {
        	getNotified();
        	this.paid = false;
        }
    }

    //Notifies landlord their fee payment ended if there was an email system implemented
    public void getNotified() { // Notifications does not exist on diagram
    	System.out.println("Payment Period Ended!");
    }

    public static void setAmount(double newAmount) {
    	feeAmount = newAmount;
    }

    public static void setPeriod(Date newPeriod){
        feePeriod = newPeriod;
    }

    public static double getAmount() {
    	return feeAmount;
    }

    public static Date getPeriod(){
        return feePeriod;
    }
}
