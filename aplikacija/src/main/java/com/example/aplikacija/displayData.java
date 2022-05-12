package com.example.aplikacija;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

public class displayData extends JFrame {
    private JPanel mainPanel;
    private JList list1;
    private JButton btnNew;

    DefaultListModel listM = new DefaultListModel(){

    };

    public displayData(Connection conn){
        setContentPane(mainPanel);
        setTitle("Zaposleni");
        setSize(750, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        DbFunctions db= new DbFunctions();
        //Connection conn=db.connect_to_db();

        String elements = db.izpis_zaposlenih(conn);
        elements=elements.replace("(", "");
        elements=elements.replace(")", "#");
        String[] zaposleni = elements.split("#");

        for (String i : zaposleni) {
            listM.addElement(i);
        }

        list1.setModel(listM);

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println(list1.getSelectedValue());
                editFrame editframe = new editFrame(conn, list1.getSelectedValue().toString());
                dispose();
            }
        });

        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editFrame editframe = new editFrame(conn,"Nov uslužbenec");
                dispose();
            }
        });
    }
}
