package View;

import Controller.*;
import Pojos.Account;
import org.w3c.dom.html.HTMLObjectElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ViewGuiAdmin extends JFrame implements ActionListener {
    Controller cont;
    JButton login;
    JButton adminUtilities;
    JButton initiate;
    JButton cancel;
    JPanel adminUtilitiesPanel;
    JPanel loginpanel;
    JTextField txuser;
    JTextField pass;
    JLabel username;
    JLabel password;
    JComboBox adminUtitiliesPanelComboBox;
    String[] adminComboBoxOptions;
    String comboBoxChoice;

    int userID;
    String stringUsername;
    int stringPassword;
    String amount;
    String customerPin;
    int customerAccountID;
    int rateID;
    int intAmount;
    String customerFirstName;
    String customerLastName;
    String customerEmail;
    String accountChoice;
    String[] accountArray;

    List<String> accountList;

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
                customerFirstName = JOptionPane.showInputDialog(null, "Input Customer's First Name");
                customerLastName = JOptionPane.showInputDialog(null, "Input Customer's Last Name");
                customerEmail = JOptionPane.showInputDialog(null, "Input Customer's Email");
                if (cont.createUser(customerFirstName, customerLastName, customerEmail))
                    JOptionPane.showMessageDialog(null, "Sucess!");
                else JOptionPane.showMessageDialog(null, "ERROR!");
                break;

            case "Delete Customer":
                userID = Integer.parseInt(JOptionPane.showInputDialog(null, "Input User ID"));
                if (cont.deleteUser(userID))
                    JOptionPane.showMessageDialog(null, "Sucess!");
                else JOptionPane.showMessageDialog(null, "ERROR!");
                break;

            case "Update Customer Information":
                userID = Integer.parseInt(JOptionPane.showInputDialog(null, "Input User ID"));
                customerFirstName = JOptionPane.showInputDialog(null, "Input Customer's First Name");
                customerLastName = JOptionPane.showInputDialog(null, "Input Customer's Last Name");
                customerEmail = JOptionPane.showInputDialog(null, "Input Customer's Email");
                cont.updateUser(userID, customerFirstName, customerLastName, customerEmail);
                JOptionPane.showMessageDialog(null, "Success!");
                break;

            case "Create Customer Account":
                userID = Integer.parseInt(JOptionPane.showInputDialog("Input user ID"));
                stringUsername = JOptionPane.showInputDialog("Input username");
                stringPassword = Integer.parseInt(JOptionPane.showInputDialog("Input password (4 digits)"));
                if (cont.createUserAccount(userID, stringUsername, stringPassword))
                    JOptionPane.showMessageDialog(null, "success");
                else
                    JOptionPane.showMessageDialog(null, "ERROR");

                System.out.println(comboBoxChoice);
                break;

            case "Delete Customer Account":
                userID = Integer.parseInt(JOptionPane.showInputDialog(null, "Input user ID"));
                if (cont.deleteUserAccount(userID))
                    JOptionPane.showMessageDialog(null, "success");
                else
                    JOptionPane.showMessageDialog(null, "ERROR");
                break;

            case "Insert Money to Customer":
                userID = Integer.parseInt(JOptionPane.showInputDialog(null, "Input user ID"));
                amount = JOptionPane.showInputDialog(null, "Input amount to deposit");
                customerPin = JOptionPane.showInputDialog(null, "Input Customer PIN");
                customerAccountID = cont.getAccountByString(customerPin);
                accountList = cont.getBalanceAccountsForWhereUserId(customerAccountID);
                accountArray = cont.listToStringArray(accountList);

                accountChoice = (String) JOptionPane.showInputDialog(null, "Choose account",
                        "Choose account", JOptionPane.QUESTION_MESSAGE, null,
                        accountArray,
                        accountArray[1]);
                if (cont.insertwithdrawal(customerAccountID, accountChoice, amount, 1).equalsIgnoreCase(
                        "Result set representing update count of 0")) {
                    JOptionPane.showMessageDialog(null, "Success!");
                } else
                    JOptionPane.showMessageDialog(null, "ERROR!");
                break;

            case "Withdraw Money from Customer":
                userID = Integer.parseInt(JOptionPane.showInputDialog(null, "Input user ID"));
                amount = JOptionPane.showInputDialog(null, "Input amount to withdraw");
                customerPin = JOptionPane.showInputDialog(null, "Input Customer PIN");
                customerAccountID = cont.getAccountByString(customerPin);
                accountList = cont.getBalanceAccountsForWhereUserId(customerAccountID);
                accountArray = cont.listToStringArray(accountList);

                accountChoice = (String) JOptionPane.showInputDialog(null, "Choose account",
                        "Choose account", JOptionPane.QUESTION_MESSAGE, null,
                        accountArray,
                        accountArray[1]);

                if (cont.insertwithdrawal(customerAccountID, accountChoice, "-" + amount, 1).equalsIgnoreCase(
                        "Result set representing update count of 0")) {
                    JOptionPane.showMessageDialog(null, "Success!");
                } else
                    JOptionPane.showMessageDialog(null, "ERROR!");
                break;

            case "Approve loan":
                userID = Integer.parseInt(JOptionPane.showInputDialog(null, "Input user ID"));
                intAmount = Integer.parseInt(JOptionPane.showInputDialog(null, "input amount to loan"));
                rateID = Integer.parseInt(JOptionPane.showInputDialog(null, "input rate ID to use"));
                customerPin = JOptionPane.showInputDialog(null, "Input Customer PIN");
                customerAccountID = cont.getAccountByString(customerPin);
                if (cont.createLoanForUser(customerAccountID, intAmount, rateID)) {
                    JOptionPane.showMessageDialog(null, "Success!");
                } else
                    JOptionPane.showMessageDialog(null, "ERROR!");
                break;

            case "Edit Rate for Account":
                System.out.println(comboBoxChoice);
                break;

            case "Edit Rate for Loan":
                System.out.println(comboBoxChoice);
                break;

            case "Show Payment Plan":
                int userIDPaymentPlan = Integer.parseInt(JOptionPane.showInputDialog("Input user ID"));
                JOptionPane.showMessageDialog(null, "Summa att betala efter 1 år: \n" + cont.showPaymentPlanByAccountId(userIDPaymentPlan + ""), "Payment Plan", 3);
                System.out.println(comboBoxChoice);
                break;

            case "Edit Payment Plan":
                int userIDPaymentPlanEdit = Integer.parseInt(JOptionPane.showInputDialog("Input user ID"));
                int paymentPlanEdit = Integer.parseInt(JOptionPane.showInputDialog("Input amount of years"));
                JOptionPane.showMessageDialog(null, "Summa att betala efter " + paymentPlanEdit + " år: \n" + cont.editPaymentPlanByAccountId(userIDPaymentPlanEdit + "", paymentPlanEdit), "Payment Plan", 3);
                System.out.println(comboBoxChoice);
                break;

            case "Show Account History":

                Controller cont = new Controller();
                JComboBox emailList = new JComboBox(cont.getArrayListUserEmail());
                JOptionPane.showMessageDialog(null, emailList, "Title",
                        JOptionPane.QUESTION_MESSAGE);

                int get = emailList.getSelectedIndex();
                String[] pickedEmail = cont.getArrayListUserEmail();
                String email = pickedEmail[get];
                JComboBox kontoList = new JComboBox(cont.getDropDownBalanceAccounts(cont.getAccountIdWhereEmail(email)));
                JOptionPane.showMessageDialog(null, kontoList, "Title",
                        JOptionPane.QUESTION_MESSAGE);

                int AccountId = cont.getAccountIdWhereEmail(email);

                int get2 = kontoList.getSelectedIndex();
                String[] accountStringArray = cont.getDropDownBalanceAccounts(AccountId);
                String pickedBalanceAccountString = accountStringArray[get2];
                int account_balance_id = cont.getBalanceIdByName(pickedBalanceAccountString);


                JTextField xField = new JTextField(10);
                JTextField yField = new JTextField(10);

                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("Date from:"));
                myPanel.add(xField);
                myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                myPanel.add(new JLabel("Date to:"));
                myPanel.add(yField);

                JOptionPane.showConfirmDialog(null, myPanel,
                        "Please enter two dates in the format YYYY-MM-DD", JOptionPane.OK_CANCEL_OPTION);

                String one = xField.getText();
                String two = yField.getText();

                List<String> history = cont.getBalanceHistoryTimePeriod(AccountId,account_balance_id,one,two);

                JTextArea textArea = new JTextArea(10,20);
                textArea.append("      Date and Time                  Amount\n");
                for (String item:history) {
                    textArea.append(item + "\n");
                }
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                JOptionPane.showMessageDialog(null, scrollPane, "[ " + one + " ] to [ " + two + " ]",
                        JOptionPane.QUESTION_MESSAGE);

                break;
            default:
                System.out.println("Default outcome");
                break;
        }
    }
}
