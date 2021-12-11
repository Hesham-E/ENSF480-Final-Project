package View;

public class redirect {

	//this is responsible for redirecting it to RegGUI.java class
	public static void registeraccountbutton(){
		new RegGUI();
	}
	
	//this is responsible for redirecting it to LoginAccountGUI.java class
	public static void backtologin(){
		new LoginAccountGUI();
	}
	
	//this is responsible for redirecting it to SearchGUI.java class
	public static void gotosearchbutton(String email){
		new SearchGUI(email);
	}
	
	//this is responsible for redirecting it to RegRenterAccountInfoGUI.java class
	public static void rraccinfobutton(){
		new RegRenterAccountInfoGUI();
	}
	
	//this is responsible for redirecting it to LandlordAccountInfoGUI.java class
	public static void landlordinfobutton(){
		new LandlordAccountInfoGUI();
	}
	
	//this is responsible for redirecting it to ManagerAccountInfoGUI.java class
	public static void managerinfobutton(){
		new ManagerAccountInfoGUI();
	}
	
	//this is responsible for redirecting it to RegisterPropertyGUI.java class
	public static void gotoaddpropbutton(){
		new RegisterPropertyGUI();
	}
	
	//this is responsible for redirecting it to GeneratedReportGUI.java class
	public static void gotogeneratedreport(){
		new GeneratedReportGUI();
	}

	//this is responsible for redirecting it to SummaryReportGUI.java class
	public static void gotosumbutton(){
		new SummaryReportGUI();
	}
}
