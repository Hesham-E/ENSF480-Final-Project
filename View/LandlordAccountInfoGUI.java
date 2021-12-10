package View;

import Model.Property;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;


public class LandlordAccountInfoGUI{
    private JLabel LandlordNameLabel;
    private JLabel LandlordUsernameLabel;
    private JLabel LandlordEmailLabel;
    private JLabel LandlordAccountTypeLabel;
    private JTextField UserNameField;
    private JTextField PasswordField;
    private JTextField NameField;
    private JTextField EmailField;
    private JButton ViewPropertiesButton;
    private JButton AddPropertyButton;
    private JButton EditPropertyButton;
    private JButton RemovePropertyButton;
    private JLabel NumberOfPropertiesLabel;
    private ArrayList<Property> propertyList;
    private static JButton logoutbutton;

    
    public void setGUIUsername(String username){
        LandlordUsernameLabel.setText("Username: " + username);
    }

    public void setGUIName(String name){
        LandlordNameLabel.setText("Name: " + name);
    }

    public void setGUIEmail(String email){
        LandlordEmailLabel.setText("Email: " + email);
    }

    public void setGUIAccountType(String type){
        LandlordAccountTypeLabel.setText("Account Type: " + type);
    }

    public void setGUIProperties(ArrayList<Property> list){
        this.propertyList = list;
    }

    public ArrayList<Property> getGUIProperties(){
        return this.propertyList;
    }

    
    public LandlordAccountInfoGUI() {
    
    JFrame frame = new JFrame();
	frame.setSize(400, 300);
	frame.setTitle("Landlord Page!");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JPanel lpanel = new JPanel();
	frame.add(lpanel);
	lpanel.setLayout(null);
	
	AddPropertyButton = new JButton("Register a new property!");
	AddPropertyButton.setBounds(100,10,200,25);
	AddPropertyButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent a){
			frame.setVisible(false);
			redirect.gotoaddpropbutton();
	}
	});
	lpanel.add(AddPropertyButton);
	frame.setVisible(true);
	
	EditPropertyButton = new JButton("Edit existing property");
	EditPropertyButton.setBounds(100, 40, 200, 25);
	EditPropertyButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent b) {
			frame.setVisible(false);
			redirect.backtologin();
			}
		}
	);
	lpanel.add(EditPropertyButton);
	
	RemovePropertyButton = new JButton("Remove existing property");
	RemovePropertyButton.setBounds(100, 70, 200, 25);
	RemovePropertyButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent b) {
			frame.setVisible(false);
			//property removal code needed
			}
		}
	);
	lpanel.add(RemovePropertyButton);
    
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
}
    
}

