package Controller;

import View.AccountInfoGUI;

public abstract class AccountController {//changed from interface to abstract class
    //protected AccountInfoGUI guiStyle;  removed 
    protected Database database;

    AccountController(Database db){
        this.database = db;
    }

    public abstract void performGUIStrategy ();
    public abstract void updateDatabase ();
}
