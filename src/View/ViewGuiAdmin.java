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
    JPanel loginpanel;
    JPanel choicePannel;
    JTextField txuser;
    JTextField pass;
    JLabel username;
    JLabel password;

    public ViewGuiAdmin() {
        super("Login Customer");
        cont = new Controller(this);

        loginpanel = new JPanel();
        choicePannel = new JPanel();
        add(loginpanel);
        login = new JButton("Login");
        CheckBalance = new JButton("Check Balance");
        checkLoan = new JButton("check Loan");
        withdrawal = new JButton("withdrawal");
        logOut = new JButton("Log out");
        txuser = new JTextField(15);
        pass = new JPasswordField(15);
        username = new JLabel("User - ");
        password = new JLabel("PIN - ");

        setSize(300, 200);
        setLocation(500, 280);
        loginpanel.setLayout(null);


        txuser.setBounds(70,30,150,20);
        pass.setBounds(70, 65, 150, 20);
        login.setBounds(110, 100, 80, 20);
        username.setBounds(20,28,80,20);
        password.setBounds(20, 63, 80, 20);
        login.addActionListener(this);
        logOut.addActionListener(this);
        loginpanel.add(login);
        loginpanel.add(username);
        loginpanel.add(txuser);
        loginpanel.add(pass);
        loginpanel.add(password);

        choicePannel.add(CheckBalance);
        choicePannel.add(checkLoan);
        choicePannel.add(withdrawal);
        choicePannel.add(logOut);

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
                if (cont.getAccountByStringAdmin(txuser.getText(),pass.getText()) > 0) {
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
        }
    }

}
