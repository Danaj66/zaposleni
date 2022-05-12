package com.example.aplikacija;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class loginForm extends JFrame{
    private JTextField tfUsername;
    private JTextField tfPassword;
    private JButton btnLogin;
    private JPanel mainPanel;
    private JButton btnRegistration;

    public loginForm(){
        setContentPane(mainPanel);
        setTitle("Prijava");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        DbFunctions db= new DbFunctions();
        Connection conn=db.connect_to_db();

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUsername.getText();
                String password = tfPassword.getText();
                int x = 0;
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);

                x = db.prijava(conn, username, password);

                System.out.println(x);

                if (x!=0){
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    menuForm menuform = new menuForm(x, username);
                    //displayData displaydata = new displayData();
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Prijava neuspešna!");
                }


            }
        });
        btnRegistration.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                registrationForm registrationform = new registrationForm();
                dispose();
            }
        });
    }
}
