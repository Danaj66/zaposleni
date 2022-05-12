package com.example.aplikacija;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class menuForm extends JFrame{
    private JPanel mainPanel;
    private JButton btnLogout;
    private JButton btnDeleteUser;
    private JButton btnZaposleni;
    private JButton btnKraji;
    private JButton btnOddelki;

    public menuForm(int x, String username) {
        setContentPane(mainPanel);
        setTitle("Meni - " + username);
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        DbFunctions db = new DbFunctions();
        Connection conn = db.connect_to_db();

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                loginForm loginForm = new loginForm();
                dispose();
            }
        });
        btnDeleteUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                db.zbrisi_uporabnika(conn, String.valueOf(x));
                loginForm loginForm = new loginForm();
                dispose();
            }
        });
        btnZaposleni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayData displayData = new displayData(conn);
            }
        });
        btnKraji.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayKraji displaykraji = new displayKraji(conn);
            }
        });
    }
}
