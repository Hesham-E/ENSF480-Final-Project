package View;

public class redirect {

	public static void registeraccountbutton(){
		new RegGUI();
	}
	
	public static void backtologin(){
		new LoginAccountGUI();
	}
	
	public static void gotosearchbutton(){
		new SearchGUI();
	}
	public static void rraccinfobutton(){
		new RegRenterAccountInfoGUI();
	}
	
	public static void landlordinfobutton(){
		new LandlordAccountInfoGUI();
	}
	
	public static void managerinfobutton(){
		new ManagerAccountInfoGUI();
	}
	
	public static void gotoaddpropbutton(){
		new RegisterPropertyGUI();
	}
	
	public static void gotosumbutton(){
		new SummaryReportGUI();
	}

}
