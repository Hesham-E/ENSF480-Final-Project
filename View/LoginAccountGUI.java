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
				// if(account in database is of a registered renter) {
				// redirect.rraccinfobutton();
				// }
				// else if(account in database is of a landlord) {
				// redirect.landlordinfobutton();
				// }
				String username = usernamefield.getText();
				String password = passfield.getText();
				System.out.println("The username entered is " + username + " and the password entered is " + password);

				frame.setVisible(false);

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
				if (usernamefield.getText().isEmpty()==true) {
					   JOptionPane.showMessageDialog(null, "Entered username is invalid.", "Whoops", JOptionPane.ERROR_MESSAGE);
				} 
				else {
					JOptionPane.showMessageDialog(frame, "Please check your email and follow the instructions to reset password.");
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

		frame.setVisible(true);
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

}
