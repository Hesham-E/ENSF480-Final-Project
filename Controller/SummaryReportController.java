package Controller;

import Model.SummaryReport;
import View.GeneratedReportGUI;
import View.SummaryReportGUI;

public class SummaryReportController extends DBInterfaceController{
    private SummaryReport model;
    private GeneratedReportGUI reportView;
    private SummaryReportGUI intialView;
    
    public SummaryReportController (SummaryReport theModel, SummaryReportGUI summaryView, GeneratedReportGUI genereatedView, Database theDatabase) {
        super(theDatabase);
        database.initializeConnection();
        
        model = theModel;
        reportView = genereatedView;
        intialView = summaryView;

        updateReport();
    }

    //Invokes Model.SummaryReport to generate report based on information SummaryReportController provides to it from the database
    //Then, SummaryReportController forwards the report's information to the GUI
    public void updateReport () {
        model.setCatalog(database.getPropertyList());
        model.setTimePeriod(intialView.getGUITimePeriod());
        model.generateReport();

        reportView.setGUINoOfActiveProperties(model.getNoOfActiveProperties());
        reportView.setGUINoOfRentedProperties(model.getNoOfRentedProperties());
        reportView.setGUITotalNo_of_Properties(model.getTotalNo_of_Properties());

        reportView.setGUIRentedProperties(model.getPropertiesRentedInPeriod());
    }
}
