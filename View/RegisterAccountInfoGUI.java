package view;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//still working on this

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class RegisterAccountInfoGUI{
	
	private static JPanel registerpanel;
	private static JLabel emaillabel;
	private static JTextField useremail;
	private static JLabel passlabel;
	private static JPasswordField pass;
	private static JLabel confirmpasslabel;
	private static JPasswordField confirmpass;
	private static JButton regbutton;
	private static JLabel usertype;
	private static JComboBox usertypebox;
	static String[] userTypes = {"Landlord","Renter"};
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(700,450);
		frame.setTitle("Registeration Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		registerpanel = new JPanel();
		frame.add(registerpanel);
		registerpanel.setLayout(null);
		
		emaillabel = new JLabel("Please enter a valid Email ID:");
		emaillabel.setBounds(10,10,200,30);
		registerpanel.add(emaillabel);
		
		useremail = new JTextField();
	    useremail.setBounds(200,20,160,25);
		registerpanel.add(useremail);
		
		passlabel = new JLabel("Enter a preffered password:");
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
	
		regbutton = new JButton("Register");
		regbutton.setBounds(200,300,200,50);
//		button.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent a){
//			String username = useremail.getText();
//            String password = pass.getText();
//            System.out.println(username + ", " + password);
//		}
//		});
		registerpanel.add(regbutton);
		
		
		
		frame.setVisible(true);
	}

}
