package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewGui extends JFrame implements ActionListener{
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

    public ViewGui() {
        super("Login Customer");

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
        password = new JLabel("Pass - ");

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
        loginpanel.add(login);
        loginpanel.add(txuser);
        loginpanel.add(pass);
        loginpanel.add(username);
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
            add(choicePannel);
            setTitle("Login Customer");
            loginpanel.setVisible(false);
            choicePannel.setVisible(true);
        }
        if (e.getSource() == logOut) {
            add(loginpanel);
            setTitle("choice Customer");
            loginpanel.setVisible(true);
            choicePannel.setVisible(false);
        }
    }

}







