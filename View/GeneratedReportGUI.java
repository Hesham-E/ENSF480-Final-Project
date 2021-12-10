package View;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import Model.Property;

public class GeneratedReportGUI {
	private static JLabel activeProperties;
	private static JLabel rentedProperties;
    private static JLabel noOfProperties;
    private static JLabel list_rented;
    private static JLabel count;

    private static int active_properties;
	private static int rented_properties;
    private static int no_properties;
    private static ArrayList<Property> rented;

    public void setGUINoOfActiveProperties(int num){
        this.active_properties = num;
    }

    public void setGUINoOfRentedProperties(int num){
        this.rented_properties = num;
    }

    public void setGUITotalNo_of_Properties(int num){
        this.no_properties = num;
    }

    public void setGUIRentedProperties(ArrayList<Property> rented){
        this.rented = rented;
    }

    public GeneratedReportGUI() {
        JFrame frame = new JFrame();
		frame.setSize(400, 300);
		frame.setTitle("Periodical Summary Report");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		JPanel reportPanel = new JPanel();
		frame.add(reportPanel);
		reportPanel.setLayout(null);
	
		activeProperties = new JLabel("Number of Active Properties:" + active_properties);
		activeProperties.setBounds(10, 20, 80, 25);
		reportPanel.add(activeProperties);

        rentedProperties = new JLabel("Number of Rented Properties:" + rented_properties);
		rentedProperties.setBounds(10, 20, 80, 25);
		reportPanel.add(rentedProperties);

        noOfProperties = new JLabel("Total Number of Active Listing:" + no_properties);
		noOfProperties.setBounds(10, 20, 80, 25);
		reportPanel.add(noOfProperties);

        list_rented = new JLabel("Total Number of Active Listing:");
        list_rented.setBounds(10, 20, 80, 25);
		reportPanel.add(list_rented);

        for (int i = 0; i < rented.size(); i++ ){
            count = new JLabel("Landlord: " + rented.get(i).getLandlord().getUserInfo().getName() + 
                                " House ID: " + rented.get(i).getHouseid() + " Address: " + rented.get(i).getAddress() + "\n");
		    count.setBounds(10, 20, 80, 25);
		    reportPanel.add(count);
        }
        frame.setVisible(true);
    }
    public static void main(String[] args) {
		
		new GeneratedReportGUI();
	}
} //unsure
