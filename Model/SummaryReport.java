package Model;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class SummaryReport {
    private ArrayList<Property> catalog;
    private ArrayList<Property> propertiesRentedInPeriod;
    private int timePeriod; //in days
    private Date today;
    private int totalNo_of_Properties; // Made numbers private from public and created getters and setters
    private int noOfActiveProperties;
    private int noOfRentedProperties;
     // private DBInterfaceController summaryController; removed this since it violates the package diagram

     //Catch all function that updates all members of the SummaryReport
    public void generateReport() { //changed name from displayReport() since we have a GUI
        countActiveProperties();
        countProperties();
        countRentedProperties();
    }

    //Counts all properties in the database
    public int countProperties() {
        totalNo_of_Properties = catalog.size();

        return totalNo_of_Properties;
    }  

    //Counts all active properties within a certain time period
    //Returns a number
    public int countActiveProperties() {
        noOfActiveProperties = 0;

        long msDiff = 0;
        long dayDiff = 0;
        for (Property p : catalog) {
            if (p.getStatus() == PropertyState.ACTIVE) {
                msDiff = Math.abs(today.getTime() - p.getDateListed().getTime());
                dayDiff = TimeUnit.DAYS.convert(msDiff, TimeUnit.MILLISECONDS);

                if (dayDiff <= timePeriod) {
                    noOfActiveProperties++;
                }
            }
        }
        return noOfActiveProperties;
    }

    //Counts all rented propeerties within a certain time period
    //Additionally, updates an ArrayList with these specific properties
    //Returns a number 
    public int countRentedProperties() {
        noOfRentedProperties = 0;

        long msDiff = 0;
        long dayDiff = 0;
        for (Property p : catalog) {
            if (p.getStatus() == PropertyState.RENTED) {
                msDiff = Math.abs(today.getTime() - p.getDateRented().getTime());
                dayDiff = TimeUnit.DAYS.convert(msDiff, TimeUnit.MILLISECONDS);

                if (dayDiff <= timePeriod) {
                    noOfRentedProperties++;
                    propertiesRentedInPeriod.add(p);
                }
            }
        }
        return noOfRentedProperties;
    }

    public ArrayList<Property> getPropertiesRentedInPeriod() {
        return this.propertiesRentedInPeriod;
    }

    public void setPropertiesRentedInPeriod(ArrayList<Property> propertiesRentedInPeriod) {
        this.propertiesRentedInPeriod = propertiesRentedInPeriod;
    }
    
    public ArrayList<Property> getCatalog() {
        return this.catalog;
    }

    public void setCatalog(ArrayList<Property> catalog) {
        this.catalog = catalog;
    }

    public int getTimePeriod() {
        return this.timePeriod;
    }

    public void setTimePeriod(int timePeriod) {
        this.timePeriod = timePeriod;
    };

    public Date getToday() {
        return this.today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

   

    //Removed update() function which is present in UML

    

    public int getTotalNo_of_Properties() {
        return this.totalNo_of_Properties;
    }

    public void setTotalNo_of_Properties(int totalNo_of_Properties) {
        this.totalNo_of_Properties = totalNo_of_Properties;
    }

    public int getNoOfActiveProperties() {
        return this.noOfActiveProperties;
    }

    public void setNoOfActiveProperties(int noOfActiveProperties) {
        this.noOfActiveProperties = noOfActiveProperties;
    }

    public int getNoOfRentedProperties() {
        return this.noOfRentedProperties;
    }

    public void setNoOfRentedProperties(int noOfRentedProperties) {
        this.noOfRentedProperties = noOfRentedProperties;
    }

}
