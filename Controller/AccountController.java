package Controller;

public abstract class AccountController {//changed from interface to abstract class
    //protected AccountInfoGUI guiStyle;  removed 
    protected Database database;

    AccountController(Database db){
        this.database = db;
        db.initializeConnection();
    }

    public abstract void performGUIStrategy ();
    //public abstract void updateDatabase (); removed since not all children need to update database
}
