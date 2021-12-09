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


public class RegisterPropertyGUI{
	
	private static JPanel hregisterpanel;
	private static JLabel loclabel;
	private static JTextField locfield;
	private static JLabel typelabel;
	private static JComboBox typebox;
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
	static String[] htypes = {"Apartment","Duplex","Condo","Basement",
			                   "Loft","House","Townhouse","Shared"};
	static String[] bed = {"Studio","1 Bed","1 + Den","2 Bed","2 + Den",
			                   "3 Bed", "3 + Den","4+ Bed"};
	static String[] bath = {"1 Bath","1.5 Bath","2 Bath","2.5 Bath","3+ Bath"};
	
	public RegisterPropertyGUI(){
		JFrame frame = new JFrame();
		frame.setSize(500,450);
		frame.setTitle("Propery Registeration Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		hregisterpanel = new JPanel();
		frame.add(hregisterpanel);
		hregisterpanel.setLayout(null);
		
		loclabel = new JLabel("Enter location of property:");
		loclabel.setBounds(10,10,200,30);
		hregisterpanel.add(loclabel);
		
		locfield = new JTextField();
	    locfield.setBounds(200,20,160,25);
		hregisterpanel.add(locfield);
		
		typelabel = new JLabel("Select type of house:");
		typelabel.setBounds(10,50,200,25);
		hregisterpanel.add(typelabel);
        
		typebox = new JComboBox(htypes);
        typebox.setBounds(200, 51, 160, 25);
        hregisterpanel.add(typebox);
        
        bedlabel = new JLabel("Enter the number of beds:");
		bedlabel.setBounds(10,80,200,25);
		hregisterpanel.add(bedlabel);
        
		bedbox = new JComboBox(bed);
        bedbox.setBounds(200, 82, 160, 25);
        hregisterpanel.add(bedbox);
        
        bathlabel = new JLabel("Enter the number of bathrooms:");
		bathlabel.setBounds(10,110,200,25);
		hregisterpanel.add(bathlabel);
        
		bathbox = new JComboBox(bath);
        bathbox.setBounds(200, 113, 160, 25);
        hregisterpanel.add(bathbox);
        
        yearlabel = new JLabel("Year Built:");
		yearlabel.setBounds(10,140,200,30);
		hregisterpanel.add(yearlabel);
		
		yearfield = new JTextField();
	    yearfield.setBounds(200,143,160,25);
		hregisterpanel.add(yearfield);
		
		pricelabel = new JLabel("Asking Price:");
		pricelabel.setBounds(10,170,200,30);
		hregisterpanel.add(pricelabel);
			
		pricefield = new JTextField("$");
		pricefield.setBounds(200,173,160,25);
	 	hregisterpanel.add(pricefield);
	
		regbutton = new JButton("Register property");
		regbutton.setBounds(100,230,200,50);
		regbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				if(locfield.getText().isEmpty()==true){
					JOptionPane.showMessageDialog(null, "The location hasn't been entered.", "Whoops", JOptionPane.ERROR_MESSAGE);
					frame.setVisible(true);
				}
				else if(yearfield.getText().isEmpty()==true){
					JOptionPane.showMessageDialog(null, "The year of built hasn't been entered.", "Whoops", JOptionPane.ERROR_MESSAGE);
					frame.setVisible(true);
				}
				else if(pricefield.getText().isEmpty()==true){
					JOptionPane.showMessageDialog(null, "The expected price hasn't been entered.", "Whoops", JOptionPane.ERROR_MESSAGE);
					frame.setVisible(true);
				}
				else {
					frame.setVisible(false);
					JOptionPane.showMessageDialog(frame, "Congrats! The property has now been listed.");
					redirect.landlordinfobutton();
			
			}
			}
		});
		hregisterpanel.add(regbutton);
		
		cancelbutton = new JButton("Cancel");
		cancelbutton.setBounds(100, 300, 200, 50);
		cancelbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				frame.setVisible(false);
				redirect.landlordinfobutton();
				}
			}
		);
		hregisterpanel.add(cancelbutton);
		
		
		
		frame.setVisible(true);
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

	public static String[] getHtypes() {
		return htypes;
	}

	public static void setHtypes(String[] htypes) {
		RegisterPropertyGUI.htypes = htypes;
	}

	public static String[] getBed() {
		return bed;
	}

	public static void setBed(String[] bed) {
		RegisterPropertyGUI.bed = bed;
	}

	public static String[] getBath() {
		return bath;
	}

	public static void setBath(String[] bath) {
		RegisterPropertyGUI.bath = bath;
	}

}
