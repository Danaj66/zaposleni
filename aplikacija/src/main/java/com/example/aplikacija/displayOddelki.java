package com.example.aplikacija;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

public class displayOddelki extends JFrame{
    private JPanel mainPanel;
    private JList list1;
    private JButton btnNew;

    DefaultListModel listM = new DefaultListModel(){

    };

    public displayOddelki(Connection conn) {
        setContentPane(mainPanel);
        setTitle("Oddelki");
        setSize(750, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        DbFunctions db = new DbFunctions();
        //Connection conn = db.connect_to_db();

        String elements = db.izpis_oddelkov(conn);
        elements = elements.replace("(", "");
        elements = elements.replace(")", "#");
        elements = elements.replace("\"", "");
        String[] oddelki = elements.split("#");

        for (String i : oddelki) {
            listM.addElement(i);
        }

        list1.setModel(listM);
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println(list1.getSelectedValue());
                editOddelki editoddelki = new editOddelki(conn, list1.getSelectedValue().toString());
                dispose();
            }
        });

        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editOddelki editoddelki = new editOddelki(conn,"Nov oddelek");
                dispose();
            }
        });
    }
}
