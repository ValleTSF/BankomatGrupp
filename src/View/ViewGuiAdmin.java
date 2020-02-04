package View;

import Controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ViewGuiAdmin extends JFrame implements ActionListener {
    Controller cont;
    JButton login;
    JButton logOut;
    JButton CheckBalance;
    JButton checkLoan;
    JButton withdrawal;
    JButton adminUtilities;
    JPanel adminUtilitiesPanel;
    JPanel loginpanel;
    JPanel choicePannel;
    JTextField txuser;
    JTextField pass;
    JLabel username;
    JLabel password;
    JComboBox adminUtitiliesPanelComboBox;
    String[] adminComboBoxOptions;

    public ViewGuiAdmin() {
        super("Login Admin");
        cont = new Controller(this);

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
        choicePannel = new JPanel();
        adminUtilitiesPanel = new JPanel();
        add(loginpanel);
        login = new JButton("Login");
        CheckBalance = new JButton("Check Balance");
        checkLoan = new JButton("check Loan");
        withdrawal = new JButton("withdrawal");
        adminUtilities = new JButton("Admin Utilities");
        logOut = new JButton("Log out");
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
        logOut.addActionListener(this);
        adminUtilities.addActionListener(this);
        loginpanel.add(login);
        loginpanel.add(username);
        loginpanel.add(txuser);
        loginpanel.add(pass);
        loginpanel.add(password);

        choicePannel.add(CheckBalance);
        choicePannel.add(adminUtilities);
        choicePannel.add(checkLoan);
        choicePannel.add(withdrawal);
        choicePannel.add(logOut);

        adminUtilitiesPanel.add(adminUtitiliesPanelComboBox);



    setVisible(true);
        loginpanel.setVisible(true);
        choicePannel.setVisible(false);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}


    public static void main(String[] args) {
        ViewGuiAdmin v = new ViewGuiAdmin();

    }

    @Override
    public void actionPerformed(ActionEvent ee) {
        if (ee.getSource() == login) {
            try {
                if (cont.getAccountByStringAdmin(txuser.getText(), pass.getText()) > 0) {
                    add(choicePannel);
                    setTitle("Customer choice");
                    loginpanel.setVisible(false);
                    choicePannel.setVisible(true);

                } else
                    JOptionPane.showMessageDialog(null, "Admin finns inte");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


        if (ee.getSource() == logOut) {
            add(loginpanel);
            setTitle("Login Customer");
            loginpanel.setVisible(true);
            choicePannel.setVisible(false);
        } else if (ee.getSource() == adminUtilities) {
          add(adminUtilitiesPanel);
          setTitle("Admin Utilities");
          adminUtilitiesPanel.setVisible(true);
          choicePannel.setVisible(false);
        }
    }

}
