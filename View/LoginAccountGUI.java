package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginAccountGUI {

	private static JPanel loginpanel;
	private static JLabel usernamelabel;
	private static JTextField usernamefield;
	private static JLabel passlabel;
	private static JPasswordField passfield;
	private static JButton button;
	private static JButton regbutton;
	private static JButton guest;
	private static JButton forgotpass;
	private static JButton extrab1;
	private static JButton extrab2;
	private static JButton extrab3;
	private static boolean loginValid;
	private String accountType;



	public LoginAccountGUI() {

		JFrame frame = new JFrame();
		frame.setSize(400, 350);
		frame.setTitle("Welcome to RentSmarter Calgary!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		loginpanel = new JPanel();
		frame.add(loginpanel);
		loginpanel.setLayout(null);

		usernamelabel = new JLabel("Username:");
		usernamelabel.setBounds(10, 20, 80, 25);
		loginpanel.add(usernamelabel);

		usernamefield = new JTextField();
		usernamefield.setBounds(100, 20, 200, 25);
		loginpanel.add(usernamefield);

		passlabel = new JLabel("Password:");
		passlabel.setBounds(10, 50, 80, 25);
		loginpanel.add(passlabel);

		passfield = new JPasswordField();
		passfield.setBounds(100, 50, 200, 25);
		loginpanel.add(passfield);

		button = new JButton("Login");
		button.setBounds(100, 100, 200, 25);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {

			//If username not entered show error message
			if(usernamefield.getText().isEmpty()==true){
				JOptionPane.showMessageDialog(null, "Kindly enter an username.", "Whoops", JOptionPane.ERROR_MESSAGE);
				frame.setVisible(true);
			}
			//If pasword not entered show error message
			else if(passfield.getPassword().length== 0){
				JOptionPane.showMessageDialog(null, "Password cannot be empty.", "Whoops", JOptionPane.ERROR_MESSAGE);
				frame.setVisible(true);
			}
			//If account doesn't exist show error message 
			else if (loginValid == false) {
				JOptionPane.showMessageDialog(null, "Account does not exist in database", "Whoops", JOptionPane.ERROR_MESSAGE);
				frame.setVisible(true);
			}
			//If account is validated redirect to appropriate page based on account type
			else {
				if(accountType.equals("REGISTEREDRENTER")){
					redirect.rraccinfobutton();
				}
				else if(accountType.equals("LANDLORD")){
					redirect.landlordinfobutton();
				}
				else if(accountType.equals("MANAGER")){
					redirect.managerinfobutton();
				}
				else{
					JOptionPane.showMessageDialog(null, "Entered credentionals are invalid.", "Whoops", JOptionPane.ERROR_MESSAGE);
					frame.setVisible(true);
				}

//				//the next two lines will be commented once lines 69-82 are commented out after completion 
				System.out.println("Account Valid.");
				frame.setVisible(false);
				}
			}
			
		});
		loginpanel.add(button);

		regbutton = new JButton("Register");
		regbutton.setBounds(100, 130, 200, 25);
		regbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				frame.setVisible(false);
				redirect.registeraccountbutton();
			}
		});
		loginpanel.add(regbutton);

		guest = new JButton("Continue without account");
		guest.setBounds(100, 160, 200, 25);
		guest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				frame.setVisible(false);
				redirect.gotosearchbutton();
			}
		});
		loginpanel.add(guest);

		forgotpass = new JButton("Forgot Password?");
		forgotpass.setBounds(100, 190, 200, 25);
		forgotpass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				if (usernamefield.getText().isEmpty() == true) {
					JOptionPane.showMessageDialog(null, "Entered username is invalid.", "Whoops",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frame,
							"Please check your email and follow the instructions to reset password.");
				}
			}
		});
		loginpanel.add(forgotpass);

		// the buttons below would be removed eventually once we can get the database
		// connected
		// lip= landlord info page
		extrab1 = new JButton("LIP");
		extrab1.setBounds(100, 220, 99, 25);
		extrab1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				frame.setVisible(false);
				redirect.landlordinfobutton();
			}
		});
		loginpanel.add(extrab1);

		// rrip= reg renter info page
		extrab2 = new JButton("RRIP");
		extrab2.setBounds(201, 220, 100, 25);
		extrab2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				frame.setVisible(false);
				redirect.rraccinfobutton();
			}
		});
		loginpanel.add(extrab2);

		extrab3 = new JButton("MIP");
		extrab3.setBounds(201, 270, 100, 25);
		extrab3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				frame.setVisible(false);
				redirect.managerinfobutton();
			}
		});
		loginpanel.add(extrab3);

		frame.setVisible(true);
	}

	public static JButton getLoginButton () {
		return button;
	}

	public static JTextField getUsernamefield() {
		return usernamefield;
	}

	public static void setUsernamefield(JTextField usernamefield) {
		LoginAccountGUI.usernamefield = usernamefield;
	}

	public static JPasswordField getPassfield() {
		return passfield;
	}

	public static void setPassfield(JPasswordField passfield) {
		LoginAccountGUI.passfield = passfield;
	}

	public static boolean getLoginValid() {
		return loginValid;
	}

	public void setLoginValid(boolean validity) {
		loginValid = validity;
	}

	public void setGUIAccountType(String type){
		this.accountType = type;
	}
}
