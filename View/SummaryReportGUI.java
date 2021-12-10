package View;

import java.awt.event.*;
import javax.swing.*;

public class SummaryReportGUI {
	private static JLabel periodLabel;
	private static JTextField timePeriod;
	private static JButton generate;

	public SummaryReportGUI() {
		
		JFrame frame = new JFrame();
		frame.setSize(400, 300);
		frame.setTitle("Periodical Summary Report");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		JPanel reportPanel = new JPanel();
		frame.add(reportPanel);
		reportPanel.setLayout(null);
	
		periodLabel = new JLabel("Time Period:");
		periodLabel.setBounds(10, 20, 80, 25);
		reportPanel.add(periodLabel);
		
		timePeriod = new JTextField();
		timePeriod.setBounds(100, 20, 160, 25);
		timePeriod.addKeyListener(new KeyAdapter() { // To restrict to numerical inputs only
	        public void keyPressed(KeyEvent key) {
	           if ((key.getKeyChar() < '0' || key.getKeyChar() > '9') && key.getKeyChar() != '\b') {
	        	   JOptionPane.showMessageDialog(null, "Only Numerical Inputs!", "Error Message", JOptionPane.PLAIN_MESSAGE);
	           }
	        }
	    });
		reportPanel.add(timePeriod);
	
		generate = new JButton("Generate");
		generate.setBounds(100, 190, 100, 25);
		generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				frame.setVisible(false);
				redirect.gotogeneratedreport();
			}
		});
		reportPanel.add(generate);

		frame.setVisible(true);
	}
	
	public int getGUITimePeriod() {
		return Integer.valueOf(timePeriod.getText());
	}
}


