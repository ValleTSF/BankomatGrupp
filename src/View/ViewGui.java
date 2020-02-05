

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
    JButton withdrawalBack;
    JButton withdrawalConfirm;
    JButton logOut;
    JButton checkBalance;
    JButton checkBalanceBack;
    JButton checkLoan;
    JButton checkLoanBack;
    JButton withdrawal;
    JPanel loginPanel;
    JPanel choicePanel;
    JPanel withdrawalPanel;
    JPanel checkBalancePanel;
    JPanel checkLoanPanel;
    JTextField passwordTextField;
    JLabel passwordLabel;
    JLabel amountLabel;
    JTextField amountTextField;
    JTextArea showWithdrawal;
    JTextArea showLoan;
    JTextArea showBalanceAmount;
    JTextArea checkBalanceAmount;
    JTextArea checkBalanceHistory;
    int kundId;

    public ViewGui() {
        super("Login Customer");
        cont = new Controller(this);

        setResizable(false);
        loginPanel = new JPanel();
        choicePanel = new JPanel();
        checkLoanPanel = new JPanel();
        checkBalancePanel = new JPanel(new FlowLayout());
        withdrawalPanel = new JPanel(new FlowLayout());
        add(loginPanel);
        login = new JButton("Login");
        withdrawalBack = new JButton("Back");
        checkLoanBack = new JButton("Back");
        withdrawalConfirm = new JButton("Confirm");
        checkBalance = new JButton("Check Balance");
        checkLoan = new JButton("check Loan");
        withdrawal = new JButton("withdrawal");
        logOut = new JButton("Log out");
        checkBalanceBack = new JButton("Back");
        passwordTextField = new JPasswordField(15);
        passwordLabel = new JLabel("PIN - ");
        amountTextField = new JTextField(15);
        amountLabel = new JLabel("Amount - ");
        showWithdrawal = new JTextArea();
        showLoan = new JTextArea();
        showBalanceAmount = new JTextArea();
        checkBalanceAmount = new JTextArea();
        checkBalanceHistory = new JTextArea();
        showWithdrawal.setEditable(false);
        showLoan.setEditable(false);
        showBalanceAmount.setEditable(false);
        checkBalanceAmount.setEditable(false);
        checkBalanceHistory.setEditable(false);

        setSize(300, 200);
        setLocation(500, 280);
        loginPanel.setLayout(null);


        passwordTextField.setBounds(70, 65, 150, 20);
        login.setBounds(110, 100, 80, 20);
        checkBalanceBack.setBounds(110, 100, 80, 20);
        withdrawalConfirm.setBounds(110, 100, 80, 20);
        checkBalanceHistory.setBounds(110, 100, 80, 20);
        passwordLabel.setBounds(20, 63, 80, 20);
        showWithdrawal.setBounds(20, 63, 80, 20);
        showBalanceAmount.setBounds(20, 63, 80, 20);
        showLoan.setBounds(20, 63, 80, 20);
        amountLabel.setBounds(20, 63, 80, 20);
        login.addActionListener(this);
        logOut.addActionListener(this);
        withdrawal.addActionListener(this);
        checkLoan.addActionListener(this);
        withdrawalConfirm.addActionListener(this);
        withdrawalBack.addActionListener(this);
        checkLoanBack.addActionListener(this);
        checkBalance.addActionListener(this);
        checkBalanceBack.addActionListener(this);
        loginPanel.add(login);
        loginPanel.add(passwordTextField);
        loginPanel.add(passwordLabel);

        choicePanel.add(checkBalance);
        choicePanel.add(checkLoan);
        choicePanel.add(withdrawal);
        choicePanel.add(logOut);

        withdrawalPanel.add(amountLabel, BorderLayout.NORTH);
        withdrawalPanel.add(amountTextField, BorderLayout.SOUTH);
        withdrawalPanel.add(withdrawalConfirm, BorderLayout.NORTH);
        withdrawalPanel.add(withdrawalBack, BorderLayout.NORTH);
        withdrawalPanel.add(showWithdrawal, BorderLayout.WEST);
        withdrawalPanel.add(showBalanceAmount, BorderLayout.EAST);

        checkLoanPanel.add(showLoan, BorderLayout.CENTER);
        checkLoanPanel.add(checkLoanBack, BorderLayout.SOUTH);

        checkBalancePanel.add(checkBalanceBack, BorderLayout.NORTH);
        checkBalancePanel.add(checkBalanceAmount, BorderLayout.CENTER);


        setVisible(true);
        loginPanel.setVisible(true);
        choicePanel.setVisible(false);
        withdrawalPanel.setVisible(false);
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
                if (cont.getAccountByString(passwordTextField.getText()) > 0) {
                    kundId = cont.getAccountByString(passwordTextField.getText());
                    add(choicePanel);
                    setTitle("Customer choice");
                    loginPanel.setVisible(false);
                    choicePanel.setVisible(true);

                } else
                    JOptionPane.showMessageDialog(null, "kund finns inte");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


        if (e.getSource() == logOut) {
            add(loginPanel);
            setTitle("Login Customer");
            loginPanel.setVisible(true);
            choicePanel.setVisible(false);
            checkBalancePanel.setVisible(false);
            passwordTextField.setText("");
        }

        if (e.getSource() == withdrawal) {
            add(withdrawalPanel);
            withdrawalPanel.setVisible(true);
            choicePanel.setVisible(false);
            loginPanel.setVisible(false);
            checkBalancePanel.setVisible(false);

        }

        if (e.getSource() == withdrawalConfirm) {

            try {
                JComboBox kontoList = new JComboBox(cont.getDropDownAccounts(kundId));
                JOptionPane.showMessageDialog(null, kontoList, "Title",
                        JOptionPane.QUESTION_MESSAGE);
                int get5 = kontoList.getSelectedIndex();
                String[] accountStringArray = cont.getDropDownAccounts(kundId);
                String pickedAccountString = accountStringArray[get5];

                cont.insertwithdrawal(kundId, pickedAccountString,"-" + amountTextField.getText(), 1);
                showWithdrawal.append(amountTextField.getText() + ", har dragits från ditt konto\n");
                showBalanceAmount.setText("Nuvarande saldo: \n"
                        + cont.getBalanceNameAndAmount(kundId + ""));
                amountTextField.setText("");

            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        }
        if (e.getSource() == withdrawalBack) {
            add(loginPanel);
            setTitle("Customer choice");
            withdrawalPanel.setVisible(false);
            choicePanel.setVisible(true);
            checkBalancePanel.setVisible(false);
            showWithdrawal.setText("");
            showBalanceAmount.setText("");
            amountTextField.setText("");

        }
        if (e.getSource() == checkLoanBack) {
            add(choicePanel);
            choicePanel.setVisible(true);
            checkLoanPanel.setVisible(false);
            withdrawalPanel.setVisible(false);
            loginPanel.setVisible(false);
            checkBalancePanel.setVisible(false);
            showLoan.setText("");
        }

        if (e.getSource() == checkBalance) {
            add(checkBalancePanel);
            checkBalancePanel.setVisible(true);
            choicePanel.setVisible(false);
            checkLoanPanel.setVisible(false);
            withdrawalPanel.setVisible(false);
            loginPanel.setVisible(false);

            try {
                checkBalanceAmount.setText("Nuvarande saldo: \n" + cont.getBalanceNameAndAmount(kundId + ""));

                JTextArea textArea = new JTextArea(10,20);
                textArea.append("Date and Time           Amount\n");
                for (String item:cont.getBalanceHistory(kundId+"")) {
                    textArea.append(item + "\n");
                }
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                JOptionPane.showMessageDialog(null, scrollPane,
                        cont.getBalanceName(kundId +"").toString(),
                        JOptionPane.QUESTION_MESSAGE);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

        if (e.getSource() == checkBalanceBack) {
            add(choicePanel);
            choicePanel.setVisible(true);
            checkBalancePanel.setVisible(false);
            checkLoanPanel.setVisible(false);
            withdrawalPanel.setVisible(false);
            loginPanel.setVisible(false);
            showLoan.setText("");
        }


        if (e.getSource() == checkLoan) {
            add(checkLoanPanel);
            checkLoanPanel.setVisible(true);
            withdrawalPanel.setVisible(false);
            choicePanel.setVisible(false);
            loginPanel.setVisible(false);
            checkBalancePanel.setVisible(false);
            try {
                double loan = cont.getLoanBalance(kundId);
                showLoan.setText("Du har: " + loan + " kvar att betala." + "\n");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

