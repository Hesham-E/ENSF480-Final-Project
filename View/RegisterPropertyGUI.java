package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterPropertyGUI {

	private static JPanel hregisterpanel;
	private static JLabel loclabel;
	private static JTextField locfield;
	private static JComboBox areafield;
	private static JLabel typelabel;
	private static JComboBox typebox;
	private static JLabel furnishlabel;
	private static JComboBox furnishbox;
	private static JLabel bedlabel;
	private static JComboBox bedbox;
	private static JLabel bathlabel;
	private static JComboBox bathbox;
	private static JLabel yearlabel;
	private static JTextField yearfield;
	private static JLabel pricelabel;
	private static JTextField pricefield;
	private static JButton regbutton;
	private static JButton cancelbutton;
	static String[] htypes = { "Apartment", "Duplex", "Condo", "Basement", "Loft", "House", "Townhouse", "Shared" };
	static String[] area = { "NW", "SW", "NE", "SE", "Central" };
	static String[] bed = { "Studio", "1 Bed", "1 + Den", "2 Bed", "2 + Den", "3 Bed", "3 + Den", "4+ Bed" };
	static String[] bath = { "1 Bath", "1.5 Bath", "2 Bath", "2.5 Bath", "3+ Bath" };
	static String[] options = { "Yes", "No" };
	boolean flag = true;

	public RegisterPropertyGUI() {
		JFrame frame = new JFrame();
		frame.setSize(600, 600);
		frame.setTitle("Propery Registeration Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		hregisterpanel = new JPanel();
		frame.add(hregisterpanel);
		hregisterpanel.setLayout(null);

		loclabel = new JLabel("Enter location of property:");
		loclabel.setBounds(10, 10, 200, 30);
		hregisterpanel.add(loclabel);

		locfield = new JTextField();
		locfield.setBounds(200, 20, 250, 25);
		hregisterpanel.add(locfield);

		areafield = new JComboBox(area);
		areafield.setBounds(451, 20, 75, 25);
		hregisterpanel.add(areafield);

		typelabel = new JLabel("Select type of house:");
		typelabel.setBounds(10, 50, 200, 25);
		hregisterpanel.add(typelabel);

		typebox = new JComboBox(htypes);
		typebox.setBounds(200, 51, 160, 25);
		hregisterpanel.add(typebox);

		bedlabel = new JLabel("Enter the number of beds:");
		bedlabel.setBounds(10, 80, 200, 25);
		hregisterpanel.add(bedlabel);

		bedbox = new JComboBox(bed);
		bedbox.setBounds(200, 82, 160, 25);
		hregisterpanel.add(bedbox);

		bathlabel = new JLabel("Enter the number of bathrooms:");
		bathlabel.setBounds(10, 110, 200, 25);
		hregisterpanel.add(bathlabel);

		bathbox = new JComboBox(bath);
		bathbox.setBounds(200, 113, 160, 25);
		hregisterpanel.add(bathbox);

		furnishlabel = new JLabel("Is the house furnished?");
		furnishlabel.setBounds(10, 140, 200, 25);
		hregisterpanel.add(furnishlabel);

		furnishbox = new JComboBox(options);
		furnishbox.setBounds(200, 142, 160, 25);
		hregisterpanel.add(furnishbox);

		yearlabel = new JLabel("Year Built:");
		yearlabel.setBounds(10, 170, 200, 30);
		hregisterpanel.add(yearlabel);

		yearfield = new JTextField();
		yearfield.setBounds(200, 171, 160, 25);
		hregisterpanel.add(yearfield);

		pricelabel = new JLabel("Asking Price:");
		pricelabel.setBounds(10, 200, 200, 30);
		hregisterpanel.add(pricelabel);

		pricefield = new JTextField();
		pricefield.setBounds(200, 200, 160, 25);
		hregisterpanel.add(pricefield);

		regbutton = new JButton("Register property");
		regbutton.setBounds(300, 270, 200, 50);
		regbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (locfield.getText().isEmpty() == true) {
					JOptionPane.showMessageDialog(null, "The location hasn't been entered.", "Whoops",
							JOptionPane.ERROR_MESSAGE);
					flag = false;
					frame.setVisible(true);
				} else if (yearfield.getText().isEmpty() == true) {
					flag = false;
					JOptionPane.showMessageDialog(null, "The year of built hasn't been entered.", "Whoops",
							JOptionPane.ERROR_MESSAGE);
					frame.setVisible(true);
				} else if (yearfield.getText().isEmpty() == false) {
					try {
						Integer.parseInt(yearfield.getText());
						int numDigits = String.valueOf(yearfield.getText()).length();
						if (numDigits == 4 && Integer.parseInt(yearfield.getText()) < 2022
								&& Integer.parseInt(yearfield.getText()) > 1700) {
							;
						} else {
							flag = false;
							JOptionPane.showMessageDialog(null, "The year entered is invalid number.", "Whoops",
									JOptionPane.ERROR_MESSAGE);
							frame.setVisible(true);
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "The year entered is not a number.", "Whoops",
								JOptionPane.ERROR_MESSAGE);
						frame.setVisible(true);
						flag = false;
					}
					frame.setVisible(true);
				}
				if (pricefield.getText().isEmpty() == false) {
//					System.out.println("Enters a1");
					try {

						Integer.parseInt(pricefield.getText());
//						System.out.println("An integer enters a2");
					} catch (NumberFormatException e) {
						flag = false;
//						System.out.println("Enters a3");
						JOptionPane.showMessageDialog(null, "The price entered is of incorrect format.", "Whoops",
								JOptionPane.ERROR_MESSAGE);
						frame.setVisible(true);
					}

				} else if (pricefield.getText().isEmpty() == true) {
					flag = false;
					JOptionPane.showMessageDialog(null, "The expected price hasn't been entered.", "Whoops",
							JOptionPane.ERROR_MESSAGE);
					frame.setVisible(true);
				}

				if (flag == true) {

					frame.setVisible(false);
					JOptionPane.showMessageDialog(frame, "Congrats! The property has now been listed.");
					redirect.landlordinfobutton();

				}
			}
		});
		hregisterpanel.add(regbutton);

		cancelbutton = new JButton("Cancel");
		cancelbutton.setBounds(50, 270, 200, 50);
		cancelbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				frame.setVisible(false);
				redirect.landlordinfobutton();
			}
		});
		hregisterpanel.add(cancelbutton);

		frame.setVisible(true);
	}

	public static JComboBox getFurnishbox() {
		return furnishbox;
	}

	public static void setFurnishbox(JComboBox furnishbox) {
		RegisterPropertyGUI.furnishbox = furnishbox;
	}

	public static JTextField getLocfield() {
		return locfield;
	}

	public static void setLocfield(JTextField locfield) {
		RegisterPropertyGUI.locfield = locfield;
	}

	public static JTextField getYearfield() {
		return yearfield;
	}

	public static void setYearfield(JTextField yearfield) {
		RegisterPropertyGUI.yearfield = yearfield;
	}

	public static JTextField getPricefield() {
		return pricefield;
	}

	public static void setPricefield(JTextField pricefield) {
		RegisterPropertyGUI.pricefield = pricefield;
	}

	public static JComboBox getTypebox() {
		return typebox;
	}

	public static void setTypebox(JComboBox typebox) {
		RegisterPropertyGUI.typebox = typebox;
	}

	public static JComboBox getBedbox() {
		return bedbox;
	}

	public static void setBedbox(JComboBox bedbox) {
		RegisterPropertyGUI.bedbox = bedbox;
	}

	public static JComboBox getBathbox() {
		return bathbox;
	}

	public static void setBathbox(JComboBox bathbox) {
		RegisterPropertyGUI.bathbox = bathbox;
	}

	public static JComboBox getAreafield() {
		return areafield;
	}

	public static void setAreafield(JComboBox areafield) {
		RegisterPropertyGUI.areafield = areafield;
	}

}
