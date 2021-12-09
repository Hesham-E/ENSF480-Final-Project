package Controller;

import java.util.ArrayList;

import Model.Property;
import Model.SummaryReport;
import View.SummaryReportGUI;

public class SummaryReportController extends DBInterfaceController{
    private SummaryReport model;
    private SummaryReportGUI view;
    
    public SummaryReportController (SummaryReport theModel, SummaryReportGUI theView, Database theDatabase) {
        super(theDatabase);
        database.initializeConnection();
        
        model = theModel;
        view = theView;

        view.addActionListener (e -> {
            updateReport();
        });
    }

    //Invokes Model.SummaryReport to generate report based on information SummaryReportController provides to it from the database
    //Then, SummaryReportController forwards the report's information to the GUI
    public void updateReport () {
        model.setCatalog(database.getPropertyList());
        model.setTimePeriod(view.getGUITimePeriod());
        model.generateReport();

        view.setGUINoOfActiveProperties(model.getNoOfActiveProperties());
        view.setGUINoOfRentedProperties(model.getNoOfRentedProperties());
        view.setGUITotalNo_of_Properties(model.getTotalNo_of_Properties());

        view.setGUIRentedProperties(model.getPropertiesRentedInPeriod());
    }
}
