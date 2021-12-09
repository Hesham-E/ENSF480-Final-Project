package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginAccountGUI {

	private static JPanel loginpanel;
	private static JLabel emaillabel;
	private static JTextField useremail;
	private static JLabel passlabel;
	private static JPasswordField pass;
	private static JButton button;
	private static JButton regbutton;
	private static JButton guest;
	private static JLabel success;

	
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setSize(400, 250);
		frame.setTitle("Login Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel loginpanel = new JPanel();
		frame.add(loginpanel);
		loginpanel.setLayout(null);

		emaillabel = new JLabel("Email ID:");
		emaillabel.setBounds(10, 20, 80, 25);
		loginpanel.add(emaillabel);

		useremail = new JTextField();
		useremail.setBounds(100, 20, 160, 25);
		loginpanel.add(useremail);

		passlabel = new JLabel("Password:");
		passlabel.setBounds(10, 50, 80, 25);
		loginpanel.add(passlabel);

		pass = new JPasswordField();
		pass.setBounds(100, 50, 160, 25);
		loginpanel.add(pass);

		button = new JButton("Login");
		button.setBounds(100, 100, 200, 25);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				String username = useremail.getText();
				String password = pass.getText();
				System.out.println("The useremail entered is " + username + " and the password entered is " + password);
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
			}
		);
		loginpanel.add(regbutton);

		guest = new JButton("Continue without account");
		guest.setBounds(100, 160, 200, 25);
		guest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				//code here
			}
		});
		loginpanel.add(guest);
		

		frame.setVisible(true);
	}

}
