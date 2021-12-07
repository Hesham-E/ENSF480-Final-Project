package View;

import javax.swing.*;

public class RegisterPropertyGUI extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton addPropertyButton;
    private JButton cancelButton;
    private JPanel RegisterPropertyPanel;

    RegisterPropertyGUI () {
        super();
        this.setContentPane(this.RegisterPropertyPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
}
