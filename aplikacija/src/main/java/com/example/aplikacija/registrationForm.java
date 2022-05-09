package com.example.aplikacija;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class registrationForm extends JFrame{

    private JTextField tfUser;
    private JPasswordField tfPass;
    private JButton brnRegistration;
    private JPanel mainPanel;

    public registrationForm() {
        setContentPane(mainPanel);
        setTitle("Registracija");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        DbFunctions db= new DbFunctions();
        Connection conn=db.connect_to_db();

        brnRegistration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUser.getText();
                String password = String.valueOf(tfPass.getPassword());
                int x = 0;
                x = db.dodaj_uporabnika(conn, username, password);
                if (x!=0){
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    loginForm loginform = new loginForm();
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Registracija neuspešna!");
                }
            }
        });
    }
}
