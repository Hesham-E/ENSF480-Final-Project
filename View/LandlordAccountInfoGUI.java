package View;

import Model.Property;
import java.util.ArrayList;
import javax.swing.*;
import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;


public class LandlordAccountInfoGUI extends JFrame {
    private JLabel LandlordNameLabel;
    private JLabel LandlordUsernameLabel;
    private JLabel LandlordEmailLabel;
    private JLabel LandlordAccountTypeLabel;
    private JTextField UserNameField;
    private JTextField PasswordField;
    private JTextField NameField;
    private JTextField EmailField;
    private JButton SaveChangesButton;
    private JButton ViewPropertiesButton;
    private JButton AddPropertyButton;
    private JLabel NumberOfPropertiesLabel;
    private ArrayList<Property> propertyList;

    public void setGUIUsername(String username){
        LandlordUsernameLabel.setText("Username: " + username);
    }

    public void setGUIName(String name){
        LandlordNameLabel.setText("Name: " + name);
    }

    public void setGUIEmail(String email){
        LandlordEmailLabel.setText("Email: " + email);
    }

    public void setGUIAccountType(String type){
        LandlordAccountTypeLabel.setText("Account Type: " + type);
    }

    public void setGUIProperties(ArrayList<Property> list){
        this.propertyList = list;
    }
}

