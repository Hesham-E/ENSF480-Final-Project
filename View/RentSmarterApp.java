package View;

import Controller.LoginController;
import Controller.Database;

public class RentSmarterApp {

	public static void main(String[] args) {
		
			LoginAccountGUI loginView = new LoginAccountGUI();
			new LoginController(new Database(), loginView);

	}

}
