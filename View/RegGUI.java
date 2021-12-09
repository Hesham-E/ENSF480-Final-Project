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
	private static JTextField useremail;
	private static JLabel passlabel;
	private static JPasswordField pass;
	private static JLabel confirmpasslabel;
	private static JPasswordField confirmpass;
	private static JButton regbutton;
	private static JButton loginbutton;
	private static JLabel usertype;
	private static JComboBox usertypebox;
	static String[] userTypes = {"Landlord","Renter"};
	public boolean uniqueemail=true;
	
	public RegGUI() {
		JFrame regframe = new JFrame();
		regframe.setSize(700,450);
		regframe.setTitle("Registeration Page");
		regframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		registerpanel = new JPanel();
		regframe.add(registerpanel);
		registerpanel.setLayout(null);
		
		emaillabel = new JLabel("Please enter a valid Email ID:");
		emaillabel.setBounds(10,10,200,30);
		registerpanel.add(emaillabel);
		
		useremail = new JTextField();
	    useremail.setBounds(200,20,160,25);
		registerpanel.add(useremail);
		
		passlabel = new JLabel("Enter a password:");
		passlabel.setBounds(10,50,200,25);
		registerpanel.add(passlabel);
		
		confirmpasslabel = new JLabel("Re-enter your password:");
		confirmpasslabel.setBounds(10,80,200,30);
		registerpanel.add(confirmpasslabel);
		
		pass = new JPasswordField();
		pass.setBounds(200,50,160,25);
		registerpanel.add(pass);
		
		confirmpass = new JPasswordField();
		confirmpass.setBounds(200,80,160,25);
		registerpanel.add(confirmpass);
		
		usertype = new JLabel("Select the type of account");
        usertype.setBounds(10, 110, 160, 25);
        registerpanel.add(usertype);
        
		usertypebox = new JComboBox(userTypes);
        usertypebox.setBounds(200, 110, 160, 25);
        registerpanel.add(usertypebox);   
	
        Object selection = usertypebox.getSelectedItem();
		regbutton = new JButton("Register");
		regbutton.setBounds(200,220,200,50);
		regbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				regframe.setVisible(false);
				if(useremail.getText().isEmpty()==true||uniqueemail==false){
					JOptionPane.showMessageDialog(null, "Invalid email entered.", "Whoops", JOptionPane.ERROR_MESSAGE);
					regframe.setVisible(true);
				}
				else if(pass.getPassword().length== 0){
					JOptionPane.showMessageDialog(null, "Password cannot be empty.", "Whoops", JOptionPane.ERROR_MESSAGE);
					regframe.setVisible(true);
				}
				else if (!Arrays.equals(pass.getPassword(), confirmpass.getPassword())) {
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
				    	JOptionPane.showMessageDialog(regframe, "Reegistered renter account created! Kindly sign in now.");
				    	redirect.backtologin();
				    }
				}
				
		}
		});
		registerpanel.add(regbutton);
		
		loginbutton = new JButton("Login instead?");
		loginbutton.setBounds(200,300,200,50);
		loginbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				regframe.setVisible(false);
				redirect.backtologin();
		}
		});
		registerpanel.add(loginbutton);
		
		
		regframe.setVisible(true);
	}
	
}
