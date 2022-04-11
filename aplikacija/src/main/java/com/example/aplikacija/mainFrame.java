package com.example.aplikacija;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainFrame extends JFrame{
    private JTextField tfName;
    private JTextField tfPassword;
    private JButton btnLogin;
    private JLabel lbWelcome;
    private JPanel mainPanel;

    public mainFrame() {
        setContentPane(mainPanel);
        setTitle("Welcome");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfName.getText();
                lbWelcome.setText("Pozdravljeni, " + username + "!");
            }
        });
    }

    public static void main(String[] args) {
        mainFrame myFrame = new mainFrame();
    }
}
