package Model;

import java.util.ArrayList;

public class SummaryReport {
    private ArrayList<Property> catalog;
    private int totalNo_of_Properties; // Made numbers private from public and created getters and setters
    private int noOfActiveProperties;
    private int noOfRentedProperties;
    private DBInterfaceController summaryController;

    public SummaryReport() {
        catalog = summaryController.getDatabase().getPropertyList();
        generateReport();
    }

    //Removed update() function which is present in UML

    //Also can we make this into the constructor? Or do we have it this way since the catalog may change during runtime?
    public void generateReport() { //changed name from displayReport() since we have a GUI
        countActiveProperties();
        countProperties();
        countRentedProperties();
    }
    
    public int countProperties() {
        totalNo_of_Properties = catalog.size();

        return totalNo_of_Properties;
    }   

    public int countActiveProperties() {
        noOfActiveProperties = 0;

        for (Property p : catalog) {
            if (p.getStatus() == PropertyState.ACTIVE)
                noOfActiveProperties++;
        }
        return noOfActiveProperties;
    }

    public int countRentedProperties() {
        noOfRentedProperties = 0;

        for (Property p : catalog) {
            if (p.getStatus() == PropertyState.RENTED)
                noOfRentedProperties++;
        }
        return noOfRentedProperties;
    }

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
