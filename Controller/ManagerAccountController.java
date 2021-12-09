package Controller;

import Model.Manager;
import View.ManagerAccountInfoGUI;

public class ManagerAccountController extends AccountController {

    private Manager theModel;
    private ManagerAccountInfoGUI theView;

    ManagerAccountController(Manager model, ManagerAccountInfoGUI view, Database db){
        super(db);
        theModel = model;
        theView = view;
    }

    public void performGUIStrategy () {

    }

    public void updateDatabase () {
        
    }
}
