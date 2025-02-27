package View;

import Controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ViewGuiAdmin extends JFrame implements ActionListener {
    Controller cont;
    JButton login;
    JButton adminUtilities;
    JButton initiate;
    JButton cancel;
    JPanel adminUtilitiesPanel;
    JPanel createUserAccountPanel;
    JPanel loginpanel;
    JTextField txuser;
    JTextField pass;
    JLabel username;
    JLabel password;
    JComboBox adminUtitiliesPanelComboBox;
    String[] adminComboBoxOptions;
    String comboBoxChoice;

    public ViewGuiAdmin() {
        super("Login Admin");
        cont = new Controller(this);

        setResizable(false);
        adminComboBoxOptions = new String[]{"Add Customer",
                "Delete Customer",
                "Update Customer Information",
                "Create Customer Account",
                "Delete Customer Account",
                "Insert Money to Customer",
                "Withdraw Money from Customer",
                "Approve loan",
                "Edit Rate for Account",
                "Edit Rate for Loan",
                "Show Payment Plan",
                "Edit Payment Plan",
                "Show Account History"};

        loginpanel = new JPanel();
        adminUtilitiesPanel = new JPanel();
        add(loginpanel);
        login = new JButton("Login");
        initiate = new JButton("Initiate");
        cancel = new JButton("Cancel");
        ;
        adminUtilities = new JButton("Admin Utilities");
        txuser = new JTextField(15);
        pass = new JPasswordField(15);
        username = new JLabel("User - ");
        password = new JLabel("PIN - ");
        adminUtitiliesPanelComboBox = new JComboBox(adminComboBoxOptions);


        setSize(300, 200);
        setLocation(500, 280);
        loginpanel.setLayout(null);


        txuser.setBounds(70, 30, 150, 20);
        pass.setBounds(70, 65, 150, 20);
        login.setBounds(110, 100, 80, 20);
        username.setBounds(20, 28, 80, 20);
        password.setBounds(20, 63, 80, 20);
        login.addActionListener(this);
        adminUtilities.addActionListener(this);
        initiate.addActionListener(this);
        cancel.addActionListener(this);
        loginpanel.add(login);
        loginpanel.add(username);
        loginpanel.add(txuser);
        loginpanel.add(pass);
        loginpanel.add(password);

        adminUtilitiesPanel.add(adminUtitiliesPanelComboBox);
        adminUtilitiesPanel.add(initiate);
        adminUtilitiesPanel.add(cancel);


        setVisible(true);
        loginpanel.setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {
        ViewGuiAdmin v = new ViewGuiAdmin();

    }

    @Override
    public void actionPerformed(ActionEvent ee) {
        if (ee.getSource() == login) {
            try {
                if (cont.getAccountType(txuser.getText(), pass.getText())) {
                    add(adminUtilitiesPanel);
                    setTitle("Admin Utilities");
                    adminUtilitiesPanel.setVisible(true);
                    loginpanel.setVisible(false);

                }


            } catch (SQLException | NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "Admin finns inte");
            }

        }
        if (ee.getSource() == initiate) {
            comboBoxChoice = adminUtitiliesPanelComboBox.getItemAt(adminUtitiliesPanelComboBox.getSelectedIndex()).toString();
            try {
                initiateAdminUtility(comboBoxChoice);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (ee.getSource() == cancel)
            System.exit(0);
    }

    public void initiateAdminUtility(String comboBoxChoice) throws SQLException {

        switch (comboBoxChoice) {
            case "Add Customer":
                System.out.println(comboBoxChoice);
                break;
            case "Delete Customer":
                System.out.println(comboBoxChoice);
                break;
            case "Update Customer Information":
                System.out.println(comboBoxChoice);
                break;
            case "Create Customer Account":
                int userID = Integer.parseInt(JOptionPane.showInputDialog("Input user ID"));
                String username = JOptionPane.showInputDialog("Input username");
                int password = Integer.parseInt(JOptionPane.showInputDialog("Input password (4 digits)"));
                if (cont.createUserAccount(userID, username, password))
                    JOptionPane.showMessageDialog(null, "success");
                else
                    JOptionPane.showMessageDialog(null, "ERROR");

                System.out.println(comboBoxChoice);
                break;
            case "Delete Customer Account":
                System.out.println(comboBoxChoice);
                break;
            case "Insert Money to Customer":
                System.out.println(comboBoxChoice);
                break;
            case "Withdraw Money from Customer":
                System.out.println(comboBoxChoice);
                break;
            case "Approve loan":
                System.out.println(comboBoxChoice);
                break;
            case "Edit Rate for Account":
                System.out.println(comboBoxChoice);
                break;
            case "Edit Rate for Loan":
                System.out.println(comboBoxChoice);
                break;
            case "Show Payment Plan":
                System.out.println(comboBoxChoice);
                break;
            case "Edit Payment Plan":
                System.out.println(comboBoxChoice);
                break;
            case "Show Account History":
                System.out.println(comboBoxChoice);
                break;
            default:
                System.out.println("Default outcome");
                break;
        }
    }
}
