package View;

import Model.Property;
import Model.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;


public class ManagerAccountInfoGUI{
    private JButton ViewSummaryButton;
    private JButton EditPropertyButton;
	private JButton SaveChangesButton;
    private JLabel NumberOfPropertiesLabel;
    private static JButton logoutbutton;

	//Manager info
	private JLabel ManagerNameLabel;
    private JLabel ManagerUsernameLabel;
    private JLabel ManagerEmailLabel;

	//Fees
	private double amount;
	private Date period;
	private JButton ChangeFeesButton;

	//Column names for Tables
	private String[] userColumnNames = {"Username", "Name", "Email"};
	private String[] propertyColumnNames = {"HouseID", "Status", "Address", "Type", "BedroomNo", "BathroomNo", "Furnished", "Area", "Cost", "DateListed"};

	//Info to be used for TableModels
	private ArrayList<User> landlordList;
	private ArrayList<User> regRenterList;
	private ArrayList<Property> propertyList;

	//Models for the tables
	private DefaultTableModel landlordModel;
	private DefaultTableModel regRenterModel;
	private DefaultTableModel propertyModel;

	//JTables
	private static JTable landlordTable;
	private static JTable regRenterTable;
	private static JTable propertyTable;

 
    public void setGUIProperties(ArrayList<Property> list){
        this.propertyList = list;
    }

    public ArrayList<Property> getGUIProperties(){
        return this.propertyList;
    }

	public void setGUILandlordInfo(ArrayList<User> landlordList){
		this.landlordList = landlordList;
	}

	public void setGUIRegRenterInfo(ArrayList<User> regRenterList){
		this.regRenterList = regRenterList;
	}

	public void setGUIAmount(double amount){
		this.amount = amount;
	}

	public double getGUIAmount(){
		return this.amount;
	}

	public void setGUIPeriod(Date period){
		this.period = period;
	}

	public Date getGUIPeriod(){
		return this.period;
	}

	public JButton getSaveChangesButton(){
		return this.SaveChangesButton;
	}

	public JButton getChangeFeesButton(){
		return this.ChangeFeesButton;
	}

	public void setGUIUsername(String username){
		this.ManagerUsernameLabel.setText("Username: " + username);
	}

	public void setGUIName(String name){
		this.ManagerNameLabel.setText("Name: " + name);
	}

	public void setGUIEmail(String email){
		this.ManagerEmailLabel.setText("Email: " + email);
	}

    public ManagerAccountInfoGUI() {
    
    JFrame frame = new JFrame();
	frame.setSize(400, 300);
	frame.setTitle("Manager's Page!");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JPanel lpanel = new JPanel();
	frame.add(lpanel);
	lpanel.setLayout(null);
	
	ViewSummaryButton = new JButton("View periodic summary.");
	ViewSummaryButton.setBounds(100,10,200,25);
	ViewSummaryButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent a){
			frame.setVisible(false);
			redirect.gotosumbutton();
	}
	});
	lpanel.add(ViewSummaryButton);
	frame.setVisible(true);

	//JScrollPane lScrollPane = new JScrollPane(landlordTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	landlordTable.setFillsViewportHeight(true);
	lpanel.add(landlordTable);
	
	EditPropertyButton = new JButton("Edit existing property");
	EditPropertyButton.setBounds(100, 40, 200, 25);
	EditPropertyButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent b) {
			frame.setVisible(false);
			//code needed
			}
		}
	);
	lpanel.add(EditPropertyButton);
	
	ChangeFeesButton = new JButton("Change fees");
	ChangeFeesButton.setBounds(100, 70, 200, 25);
	ChangeFeesButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent b) {
			frame.setVisible(false);
			// code needed
			}
		}
	);
	lpanel.add(ChangeFeesButton);
    
	logoutbutton = new JButton("View Listed Properties");
	logoutbutton.setBounds(100, 100, 200, 25);
	logoutbutton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent b) {
			frame.setVisible(false);
			
			}
		}
	);
	
	logoutbutton = new JButton("Logout");
	logoutbutton.setBounds(100, 150, 200, 25);
	logoutbutton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent b) {
			frame.setVisible(false);
			redirect.backtologin();
			}
		}
	);
	lpanel.add(logoutbutton);
	frame.setVisible(true);
}


    
}

