package View;

import javax.swing.*;
import java.awt.*;

public class UserWindow extends JFrame {

    private JButton withdrawBtn = new JButton("Withdraw");
    private JButton balanceBtn = new JButton("Balance");
    private JTextField txtAmount = new JTextField();

    public UserWindow() {
        super("User-Window");
        setLayout(new BorderLayout());

        JPanel buttonsPanel1 = new JPanel();
        buttonsPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel1.add(withdrawBtn);
        buttonsPanel1.add(balanceBtn);
        add(buttonsPanel1, BorderLayout.NORTH);





        JPanel buttonsPanel3 = new JPanel();
        buttonsPanel3.setLayout(new BorderLayout());
        buttonsPanel3.add(txtAmount, BorderLayout.SOUTH);
        add(buttonsPanel3, BorderLayout.SOUTH);

        pack();
    }

    public static void main(String[] args) {
        UserWindow app = new UserWindow();

        app.setVisible(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setLocationRelativeTo(null);
    }
}



