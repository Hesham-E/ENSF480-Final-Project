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
        database = theDatabase;

        model.setCatalog(database.getPropertyList());
        model.generateReport();
        view.setGUIActiveProperties(model.getNoOfActiveProperties());
        view.setGUIRentedProperties(model.getNoOfRentedProperties());
        view.setGUITotaleProperties(model.getTotalNo_of_Properties());
    }
}
