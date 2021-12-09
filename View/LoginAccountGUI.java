package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginAccountGUI{
	private static JPanel loginpanel;
	private static JLabel usernameLabel;
	private static JTextField username;
	private static JLabel passlabel;
	private static JPasswordField pass;
	private static JButton button;
	private static JButton regbutton;
	private static JButton guest;
	private static JLabel success;

	public LoginAccountGUI() {

		JFrame frame = new JFrame();
		frame.setSize(400, 250);
		frame.setTitle("Login Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel loginpanel = new JPanel();
		frame.add(loginpanel);
		loginpanel.setLayout(null);

		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(10, 20, 80, 25);
		loginpanel.add(usernameLabel);

		username = new JTextField();
		username.setBounds(100, 20, 160, 25);
		loginpanel.add(username);

		passlabel = new JLabel("Password:");
		passlabel.setBounds(10, 50, 80, 25);
		loginpanel.add(passlabel);

		pass = new JPasswordField();
		pass.setBounds(100, 50, 160, 25);
		loginpanel.add(pass);

		button = new JButton("Login");
		button.setBounds(100, 100, 200, 25);
		loginpanel.add(button);

		regbutton = new JButton("Register");
		regbutton.setBounds(100, 130, 200, 25);

		//When "Register" button is pressed, go to register page
		regbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				//code here
			}
		});
		loginpanel.add(regbutton);

		guest = new JButton("Continue without account");
		guest.setBounds(100, 160, 200, 25);

		//When "Continue without account" button is pressed go to search page
		guest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				//code here
			}
		});
		loginpanel.add(guest);

		frame.setVisible(true);
	}

	public JButton getLoginButton(){
		return button;
	}

	public JButton getRegButton(){
		return regbutton;
	}

	public JButton getGuestButton(){
		return guest;
	}

	public String getGUIUsername(){
		return username.getText();
	}

	public String getGUIPassword(){
		return pass.getText();
	}

}
