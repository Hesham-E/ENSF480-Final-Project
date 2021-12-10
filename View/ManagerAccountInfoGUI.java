package View;

import Model.Property;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;


public class ManagerAccountInfoGUI{
    private JButton ViewSummaryButton;
    private JButton EditPropertyButton;
    private JButton ChangeFeesButton;
    private JLabel NumberOfPropertiesLabel;
    private ArrayList<Property> propertyList;
    private static JButton logoutbutton;

 
    public void setGUIProperties(ArrayList<Property> list){
        this.propertyList = list;
    }

    public ArrayList<Property> getGUIProperties(){
        return this.propertyList;
    }

    
    public ManagerAccountInfoGUI() {
    
    JFrame frame = new JFrame();
	frame.setSize(400, 300);
	frame.setTitle("Manager's Page!");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JPanel lpanel = new JPanel();
	frame.add(lpanel);
	lpanel.setLayout(null);
	
	ViewSummaryButton = new JButton("View periodic summary.");
	ViewSummaryButton.setBounds(100,10,200,25);
	ViewSummaryButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent a){
			frame.setVisible(false);
			redirect.gotosumbutton();
	}
	});
	lpanel.add(ViewSummaryButton);
	frame.setVisible(true);
	
	EditPropertyButton = new JButton("Edit existing property");
	EditPropertyButton.setBounds(100, 40, 200, 25);
	EditPropertyButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent b) {
			frame.setVisible(false);
			//code needed
			}
		}
	);
	lpanel.add(EditPropertyButton);
	
	ChangeFeesButton = new JButton("Change fees");
	ChangeFeesButton.setBounds(100, 70, 200, 25);
	ChangeFeesButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent b) {
			frame.setVisible(false);
			// code needed
			}
		}
	);
	lpanel.add(ChangeFeesButton);
    
	logoutbutton = new JButton("View Listed Properties");
	logoutbutton.setBounds(100, 100, 200, 25);
	logoutbutton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent b) {
			frame.setVisible(false);
			
			}
		}
	);
	
	logoutbutton = new JButton("Logout");
	logoutbutton.setBounds(100, 150, 200, 25);
	logoutbutton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent b) {
			frame.setVisible(false);
			redirect.backtologin();
			}
		}
	);
	lpanel.add(logoutbutton);
}
    
}

