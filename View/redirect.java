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
		System.out.println("in redirect");
		new LandlordAccountInfoGUI();
	}
	
	public static void gotoaddpropbutton(){
		new RegisterPropertyGUI();
	}
	
	public static void gotogeneratedreport(){
		new GeneratedReportGUI();
	}
}
