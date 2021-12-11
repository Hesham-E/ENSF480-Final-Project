package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class RegGUI{
	
	private static JPanel registerpanel;
	private static JLabel emaillabel;
	private static JTextField emailfield;
	private static JLabel namelabel;
	private static JTextField namefield;
	private static JLabel usernamelabel;
	private static JTextField usernamefield;
	private static JLabel passlabel;
	private static JPasswordField passfield;
	private static JLabel confirmpasslabel;
	private static JPasswordField confirmpassfield;
	private static JButton regbutton;
	private static JButton loginbutton;
	private static JLabel usertype;
	private static JComboBox usertypebox;
	static String[] userTypes = {"Landlord","Renter"};
	public boolean uniqueemail=true;
	public boolean uniqueusername=true;
	
	public RegGUI() {
		JFrame regframe = new JFrame();
		regframe.setSize(700,450);
		regframe.setTitle("Registeration Page");
		regframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		registerpanel = new JPanel();
		regframe.add(registerpanel);
		registerpanel.setLayout(null);
		
		namelabel = new JLabel("Enter your name:");
		namelabel.setBounds(10,10,200,30);
		registerpanel.add(namelabel);
		
		namefield = new JTextField();
	    namefield.setBounds(200,10,160,25);
		registerpanel.add(namefield);
		
		emaillabel = new JLabel("Enter a valid Email ID:");
		emaillabel.setBounds(10,50,200,30);
		registerpanel.add(emaillabel);
		
		emailfield = new JTextField();
	    emailfield.setBounds(200,50,160,25);
		registerpanel.add(emailfield);
		
		
		
		usernamelabel = new JLabel("Enter an unique username:");
		usernamelabel.setBounds(10,90,200,25);
		registerpanel.add(usernamelabel);
		
		usernamefield = new JTextField();
	    usernamefield.setBounds(200,90,160,25);
		registerpanel.add(usernamefield);
		
		passlabel = new JLabel("Enter a password:");
		passlabel.setBounds(10,130,200,30);
		registerpanel.add(passlabel);
		
		passfield = new JPasswordField();
		passfield.setBounds(200,130,160,25);
		registerpanel.add(passfield);
		
		confirmpasslabel = new JLabel("Re-enter your password:");
		confirmpasslabel.setBounds(10,170,200,30);
		registerpanel.add(confirmpasslabel);

		confirmpassfield = new JPasswordField();
		confirmpassfield.setBounds(200,170,160,25);
		registerpanel.add(confirmpassfield);
		
		usertype = new JLabel("Select the type of account");
        usertype.setBounds(10, 210, 160, 25);
        registerpanel.add(usertype);
        
		usertypebox = new JComboBox(userTypes);
        usertypebox.setBounds(200, 210, 160, 25);
        registerpanel.add(usertypebox);   
	
        Object selection = usertypebox.getSelectedItem();
		regbutton = new JButton("Register");
		regbutton.setBounds(200,260,200,50);
		regbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				regframe.setVisible(false);
				if(namefield.getText().isEmpty()==true){
					JOptionPane.showMessageDialog(null, "Name cannot be empty.", "Whoops", JOptionPane.ERROR_MESSAGE);
					regframe.setVisible(true);
				}
				else if(emailfield.getText().isEmpty()==true||uniqueemail==false){
					JOptionPane.showMessageDialog(null, "Invalid email entered.", "Whoops", JOptionPane.ERROR_MESSAGE);
					regframe.setVisible(true);
				}
				else if (usernamefield.getText().isEmpty()==true||uniqueusername==false) {
					   JOptionPane.showMessageDialog(null, "Entered username is invalid/taken.", "Whoops", JOptionPane.ERROR_MESSAGE);
					   regframe.setVisible(true);
				} 
				else if(passfield.getPassword().length== 0){
					JOptionPane.showMessageDialog(null, "Password cannot be empty.", "Whoops", JOptionPane.ERROR_MESSAGE);
					regframe.setVisible(true);
				}
				else if (!Arrays.equals(passfield.getPassword(), confirmpassfield.getPassword())) {
					   JOptionPane.showMessageDialog(null, "Passwords do not match.", "Whoops", JOptionPane.ERROR_MESSAGE);
					   regframe.setVisible(true);
				} 
				else {
					System.out.println("valid");
				    if(selection=="Landlord"){
				    	JOptionPane.showMessageDialog(regframe, "Landlord account created! Kindly sign in now.");
				    	redirect.backtologin();
				    }
				    else {
				    	JOptionPane.showMessageDialog(regframe, "Registered renter account created! Kindly sign in now.");
				    	redirect.backtologin();
				    }
				}
				
		}
		});
		registerpanel.add(regbutton);
		
		loginbutton = new JButton("Login instead?");
		loginbutton.setBounds(200,320,200,50);
		loginbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				regframe.setVisible(false);
				redirect.backtologin();
		}
		});
		registerpanel.add(loginbutton);
		
		
		regframe.setVisible(true);
	}

	public static String getNamefield() {
		return namefield.toString();
	}

	public static void setNamefield(JTextField namefield) {
		RegGUI.namefield = namefield;
	}

	public static String getEmailfield() {
		return emailfield.toString();
	}

	public static void setEmailfield(JTextField emailfield) {
		RegGUI.emailfield = emailfield;
	}

	public static String getUsernamefield() {
		return usernamefield.toString();
	}

	public static void setUsernamefield(JTextField usernamefield) {
		RegGUI.usernamefield = usernamefield;
	}

	public static String getPassfield() {
		return passfield.toString();
	}

	public static void setPassfield(JPasswordField passfield) {
		RegGUI.passfield = passfield;
	}

	public static String[] getUserTypes() {
		return userTypes;
	}

	public static void setUserTypes(String[] userTypes) {
		RegGUI.userTypes = userTypes;
	}

	public String getUserType () {
		return usertypebox.getSelectedItem().toString();
	}
	
	public boolean getUniqueemail() {
		return this.uniqueemail;
	}

	public void setUniqueemail(boolean uniqueemail) {
		this.uniqueemail = uniqueemail;
	}

	public boolean getUniqueUsername() {
		return this.uniqueusername;
	}

	public void setUniqueUsername(boolean uniqueusername) {
		this.uniqueusername = uniqueusername;
	}

	public JButton getRegButton() {
		return regbutton;
	}
}
