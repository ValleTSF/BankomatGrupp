package View;

import Controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ViewGui extends JFrame implements ActionListener {
    Controller cont;
    JButton login;
    JButton logOut;
    JButton CheckBalance;
    JButton checkLoan;
    JButton withdrawal;
    JPanel loginpanel;
    JPanel choicePannel;
    JTextField pass;
    JLabel password;

    public ViewGui() {
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
        pass = new JPasswordField(15);
        password = new JLabel("PIN - ");

        setSize(300, 200);
        setLocation(500, 280);
        loginpanel.setLayout(null);


        pass.setBounds(70, 65, 150, 20);
        login.setBounds(110, 100, 80, 20);
        password.setBounds(20, 63, 80, 20);
        login.addActionListener(this);
        logOut.addActionListener(this);
        loginpanel.add(login);
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
        ViewGui v = new ViewGui();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try {
                if (cont.getAccountByString(pass.getText()) > 0) {
                    add(choicePannel);
                    setTitle("Customer choice");
                    loginpanel.setVisible(false);
                    choicePannel.setVisible(true);

                } else
                    JOptionPane.showMessageDialog(null, "kund finns inte");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


        if (e.getSource() == logOut) {
            add(loginpanel);
            setTitle("Login Customer");
            loginpanel.setVisible(true);
            choicePannel.setVisible(false);
        }
    }

}