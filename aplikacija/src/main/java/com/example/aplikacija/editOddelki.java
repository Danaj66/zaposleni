package com.example.aplikacija;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class editOddelki extends JFrame{
    private JPanel mainPanel;
    private JTextField tfID;
    private JTextField tfIme;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;

    public editOddelki(Connection conn, String info) {
        setContentPane(mainPanel);
        setTitle(info);
        setSize(750, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        DbFunctions db = new DbFunctions();

        tfID.setEnabled(false);
        if (info != "Nov oddelek")
        {
            String[] oddelki = info.split(",");
            tfID.setText(oddelki[0]);
            tfIme.setText(oddelki[1]);
            btnAdd.setVisible(false);
        }
        else
        {
            btnEdit.setVisible(false);
            btnDelete.setVisible(false);
        }


        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                db.uredi_oddelek(conn, tfID.getText(), tfIme.getText());
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                db.dodaj_oddelek(conn, tfIme.getText());
                displayOddelki displayoddelki = new displayOddelki(conn);
                dispose();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                db.zbrisi_oddelek(conn, tfID.getText());
                displayOddelki displayoddelki = new displayOddelki(conn);
                dispose();
            }
        });
    }
}
