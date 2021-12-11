package View;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import java.util.ArrayList;

import Model.Property;
import Controller.Database;
import Controller.SearchController;

public class SearchGUI {

	private static JPanel panel;

	private static JLabel typelabel;
	private static JComboBox typebox;
	private static JLabel bedlabel;
	private static JComboBox bedbox;
	private static JLabel bathlabel;
	private static JComboBox bathbox;
	private JLabel furnlabel;
	private static JComboBox furnbox;
	private JLabel arealabel;
	private static JComboBox areabox;
	private JButton searchbutton;
	private JButton loginbutton;
	private JButton bookmarkbutton;

	static String[] htypes = { "No preference", "Apartment", "Duplex", "Condo", "Basement", "Loft", "House",
			"Townhouse", "Shared" };
	static String[] area = { "No preference","NW", "SW", "NE", "SE" };
	static String[] bed = { "No preference", "1", "2","3", "4", "5" };
	static String[] bath = { "No preference", "1", "2","3" };
	static String[] options = {"Yes", "No"};
	
	private ArrayList<Property> searchFind;
	private SearchController controller;
	private String subscriber;

	public SearchGUI(String emailAddress) {
		controller = new SearchController(new Database());
//created a search frame 
		this.subscriber  = emailAddress;

		JFrame frame = new JFrame("Search");
		panel = new JPanel();
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.setLayout(null);
//selection of preferred house type
		typelabel = new JLabel("Preferred house type:");
		typelabel.setBounds(10, 20, 200, 25);
		panel.add(typelabel);

		typebox = new JComboBox(htypes);
		typebox.setBounds(250, 20, 110, 25);
		panel.add(typebox);

//selection of preferred number of bedrooms
		bedlabel = new JLabel("Preferred number of bedrooms:");
		bedlabel.setBounds(10, 50, 200, 25);
		panel.add(bedlabel);

		bedbox = new JComboBox(bed);
		bedbox.setBounds(250, 50, 110, 25);
		panel.add(bedbox);

//selection of preferred number of bathrooms

		bathlabel = new JLabel("Preferred number of bathrooms:");
		bathlabel.setBounds(10, 80, 200, 25);
		panel.add(bathlabel);

		bathbox = new JComboBox(bath);
		bathbox.setBounds(250, 80, 110, 25);
		panel.add(bathbox);

//selection of preference in furnishing

		furnlabel = new JLabel("Would you prefer a furnished house:");
		furnlabel.setBounds(10, 110, 200, 25);
		panel.add(furnlabel);

		furnbox = new JComboBox(options);
		furnbox.setBounds(250, 110, 110, 25);
		panel.add(furnbox);

//selection of preference in part of calgary
		arealabel = new JLabel("Prefered area of city:");
		arealabel.setBounds(10, 140, 200, 25);
		panel.add(arealabel);

		areabox = new JComboBox(area);
		areabox.setBounds(250, 140, 110, 25);
		panel.add(areabox);
//search button
		searchbutton = new JButton("Search");
		searchbutton.setBounds(175, 200, 200, 50);

		searchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String htype = typebox.getSelectedItem().toString();
				String bed = bedbox.getSelectedItem().toString();
				String bath = bathbox.getSelectedItem().toString();
				String area = areabox.getSelectedItem().toString();
				String furn = furnbox.getSelectedItem().toString();

				System.out.println(htype + " " + bed + " " + bath + " " + area + " " + furn);
				searchFind = controller.filterInputs(htype, bed, bath, area, furn);
			}
		});
		panel.add(searchbutton);

		// back to login page
		loginbutton = new JButton("Head back to login page");
		loginbutton.setBounds(175, 260, 200, 50);

		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				redirect.backtologin();
			}
		});
		panel.add(loginbutton);

		// subscription button
		bookmarkbutton = new JButton("Subscribe to this Search!");
		bookmarkbutton.setBounds(10, 200, 150, 110);
		bookmarkbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
          	if(!subscriber.equals(null)){
				frame.setVisible(false);
				JOptionPane.showMessageDialog(frame, "Subscription Saved!");
			}
          
            else {
            	frame.setVisible(false);
            	JOptionPane.showMessageDialog(null, "You must Login as Registered Renter to use this feature. Kindly Login and retry.", "Whoops", JOptionPane.ERROR_MESSAGE);
            	redirect.backtologin();
            }
		}
		});
		panel.add(bookmarkbutton);

		panel.setVisible(true);
		frame.setVisible(true);

	}

	public static JComboBox getTypebox() {
		return typebox;
	}

	public static void setTypebox(JComboBox typebox) {
		SearchGUI.typebox = typebox;
	}

	public static JComboBox getBedbox() {
		return bedbox;
	}

	public static void setBedbox(JComboBox bedbox) {
		SearchGUI.bedbox = bedbox;
	}

	public static JComboBox getBathbox() {
		return bathbox;
	}

	public static void setBathbox(JComboBox bathbox) {
		SearchGUI.bathbox = bathbox;
	}

	public static JComboBox getAreabox() {
		return areabox;
	}

	public static void setAreabox(JComboBox areabox) {
		SearchGUI.areabox = areabox;
	}
}
