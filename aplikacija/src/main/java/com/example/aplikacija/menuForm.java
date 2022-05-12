package com.example.aplikacija;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class menuForm extends JFrame{
    private JPanel mainPanel;
    private JButton btnLogout;
    private JButton btnDeleteUser;

    public menuForm(int x, String username) {
        setContentPane(mainPanel);
        setTitle("Meni - " + username);
        setSize(750, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        DbFunctions db = new DbFunctions();
        Connection conn = db.connect_to_db();

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginForm loginForm = new loginForm();
                dispose();
            }
        });
    }
}
