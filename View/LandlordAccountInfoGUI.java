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
    private JButton SaveChangesButton;
    private JButton ViewPropertiesButton;
    private JButton AddPropertyButton;
    private JLabel NumberOfPropertiesLabel;
    private ArrayList<Property> propertyList;
    private static JButton extrab1;

    
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

    public JButton getSaveChangesButton(){
        return SaveChangesButton;
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
	AddPropertyButton.setBounds(200,100,200,50);
	AddPropertyButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent a){
			frame.setVisible(false);
			redirect.gotoaddpropbutton();
	}
	});
	lpanel.add(AddPropertyButton);
	frame.setVisible(true);
    
}
    
}

