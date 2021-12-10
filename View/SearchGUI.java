package View;

import javax.swing.*;
import java.awt.event.*;

public class SearchGUI {

    private static JPanel panel;
	
	private static JLabel typelabel;
	private static JComboBox typebox;
	private static JLabel bedlabel;
	private static JComboBox bedbox;
	private static JLabel bathlabel;
	private static JComboBox bathbox;
    private JLabel arealabel;
    private static JComboBox areabox;
    private JButton searchbutton;

	static String[] htypes = {"No preference","Apartment","Duplex","Condo","Basement",
			                   "Loft","House","Townhouse","Shared"};
	static String[] area = {"No preference","NW","SW","NE","SE","Central"};
	static String[] bed = {"No preference","Studio","1 Bed","1 + Den","2 Bed","2 + Den",
			                   "3 Bed", "3 + Den","4+ Bed"};
	static String[] bath = {"No preference","1 Bath","1.5 Bath","2 Bath","2.5 Bath","3+ Bath"};

    public SearchGUI(){

        JFrame frame = new JFrame("Search");
        panel = new JPanel();
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        typelabel = new JLabel("Prefered house type:");
        typelabel.setBounds(10, 80, 200, 25);
        panel.add(typelabel);

        typebox = new JComboBox(htypes);
        typebox.setBounds(250, 80, 110, 25);
        panel.add(typebox);

        bedlabel = new JLabel("Prefered number of bedrooms:");
        bedlabel.setBounds(10, 110, 200, 25);
        panel.add(bedlabel);

        bedbox = new JComboBox(bed);
        bedbox.setBounds(250, 110, 110, 25);
        panel.add(bedbox);

        bathlabel = new JLabel("Prefered number of bathrooms:");
        bathlabel.setBounds(10, 140, 200, 25);
        panel.add(bathlabel);

        bathbox = new JComboBox(bath);
        bathbox.setBounds(250, 140, 110, 25);
        panel.add(bathbox);


        arealabel = new JLabel("Prefered area of city:");
        arealabel.setBounds(10, 170, 200, 25);
        panel.add(arealabel);

        areabox = new JComboBox(area);
        areabox.setBounds(250, 170, 110, 25);
        panel.add(areabox);

        searchbutton = new JButton("Search");
        searchbutton.setBounds(175, 270, 200, 50);

        searchbutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String htype = typebox.getSelectedItem().toString();
                String bed = bedbox.getSelectedItem().toString();
                String bath = bathbox.getSelectedItem().toString();
                String area = areabox.getSelectedItem().toString();

                System.out.println(htype +" "+bed+" "+bath+" "+area);
            }
        });
        panel.add(searchbutton);

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

