package Controller;

public interface AccountController {
    protected AccountInfoGUI guiStyle;
    protected Database database;

    public void performGUIStrategy ();
    public void updateDatabase ();
}
