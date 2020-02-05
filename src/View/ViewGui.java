package View;

import Controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ViewGui extends JFrame implements ActionListener {
    Controller cont;
    JButton login;
    JButton Ok;
    JButton logOut;
    JButton CheckBalance;
    JButton checkLoan;
    JButton withdrawal;
    JPanel loginpanel;
    JPanel choicePannel;
    JPanel checkBalancePanel;
    JPanel checkLoanPanel;
    JTextField pass;
    JLabel password;
    JLabel Amount;
    JTextField txtAmount;
    JTextArea showResult;
    JTextArea showResult2;
    int kundId;

    public ViewGui() {
        super("Login Customer");
        cont = new Controller(this);

        setResizable(false);
        loginpanel = new JPanel();
        choicePannel = new JPanel();
        checkLoanPanel = new JPanel();
        checkBalancePanel = new JPanel(new FlowLayout());
        add(loginpanel);
        login = new JButton("Login");
        Ok = new JButton("OK");
        CheckBalance = new JButton("Check Balance");
        checkLoan = new JButton("check Loan");
        withdrawal = new JButton("withdrawal");
        logOut = new JButton("Log out");
        pass = new JPasswordField(15);
        password = new JLabel("PIN - ");
        txtAmount = new JTextField(15);
        Amount = new JLabel("Amount - ");
        showResult = new JTextArea();
        showResult2 = new JTextArea();
        showResult.setEditable(false);
        showResult2.setEditable(false);

        setSize(300, 200);
        setLocation(500, 280);
        loginpanel.setLayout(null);


        pass.setBounds(70, 65, 150, 20);
        login.setBounds(110, 100, 80, 20);
        Ok.setBounds(110, 100, 80, 20);
        password.setBounds(20, 63, 80, 20);
        showResult.setBounds(20, 63, 80, 20);
        showResult2.setBounds(20, 63, 80, 20);
        Amount.setBounds(20, 63, 80, 20);
        login.addActionListener(this);
        logOut.addActionListener(this);
        withdrawal.addActionListener(this);
        checkLoan.addActionListener(this);
        Ok.addActionListener(this);
        loginpanel.add(login);
        loginpanel.add(pass);
        loginpanel.add(password);

        choicePannel.add(CheckBalance);
        choicePannel.add(checkLoan);
        choicePannel.add(withdrawal);
        choicePannel.add(logOut);

        checkBalancePanel.add(Amount,BorderLayout.WEST);
        checkBalancePanel.add(txtAmount,BorderLayout.EAST);
        checkBalancePanel.add(Ok,BorderLayout.CENTER);
        checkBalancePanel.add(showResult,BorderLayout.SOUTH);

        checkLoanPanel.add(showResult2,BorderLayout.SOUTH);


        setVisible(true);
        loginpanel.setVisible(true);
        choicePannel.setVisible(false);
        checkBalancePanel.setVisible(false);
        checkLoanPanel.setVisible(false);
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
                    kundId = cont.getAccountByString(pass.getText());
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

        if (e.getSource() == withdrawal) {
            add(checkBalancePanel);
            checkBalancePanel.setVisible(true);
            choicePannel.setVisible(false);
            loginpanel.setVisible(false);
        }
        if (e.getSource() == Ok) {
//            try {
//               cont.insertwithdrawal(kundId,"-"+ txtAmount.getText(), 1);
//                showResult.append("-"+txtAmount.getText()+"\n");
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }

        }
        if(e.getSource() == checkLoan){
            add(checkLoanPanel);
            checkLoanPanel.setVisible(true);
            checkBalancePanel.setVisible(false);
            choicePannel.setVisible(false);
            loginpanel.setVisible(false);
            try {
                double loan = cont.getLoanBalance(kundId);
                showResult2.append(loan +" Kvar att betala"+"\n");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

