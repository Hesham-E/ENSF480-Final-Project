package View;

import Model.Property;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;


public class RegRenterAccountInfoGUI{
    private JLabel RenterNameLabel;
    private JLabel RenterUsernameLabel;
    private JLabel RenterEmailLabel;
    private JTextField UserNameField;
    private JTextField PasswordField;
    private JTextField NameField;
    private JTextField EmailField;
    private JButton SearchPropertyButton;
    private JButton EditPropertyButton;
    private JButton RemovePropertyButton;
    private static JButton logoutbutton;

    
    public void setGUIUsername(String username){
        RenterNameLabel.setText("Username: " + username);
    }

    public void setGUIName(String name){
        RenterNameLabel.setText("Name: " + name);
    }

    public void setGUIEmail(String email){
        RenterEmailLabel.setText("Email: " + email);
    }


    
    public RegRenterAccountInfoGUI() {
    
    JFrame frame = new JFrame();
	frame.setSize(400, 300);
	frame.setTitle("Registered Renter's Page!");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JPanel lpanel = new JPanel();
	frame.add(lpanel);
	lpanel.setLayout(null);
	
	SearchPropertyButton = new JButton("Search for a new property!");
	SearchPropertyButton.setBounds(100,10,200,25);
	SearchPropertyButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent a){
			frame.setVisible(false);
			redirect.gotosearchbutton();
	}
	});
	lpanel.add(SearchPropertyButton);
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

