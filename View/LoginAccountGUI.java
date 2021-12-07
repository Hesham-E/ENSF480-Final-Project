package View;

import javax.swing.*;

public class LoginAccountGUI extends JFrame{
    private JPanel LogInPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton logInButton;

    LoginAccountGUI () {
        super();
        this.setContentPane(this.LogInPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
}
