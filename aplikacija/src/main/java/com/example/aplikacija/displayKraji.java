package com.example.aplikacija;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

public class displayKraji extends JFrame{
    private JPanel mainPanel;
    private JList list1;
    private JButton btnNew;

    DefaultListModel listM = new DefaultListModel(){

    };

    public displayKraji(Connection conn) {
        setContentPane(mainPanel);
        setTitle("Kraji");
        setSize(750, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        DbFunctions db = new DbFunctions();
        //Connection conn = db.connect_to_db();

        String elements = db.izpis_krajev(conn);
        elements = elements.replace("(", "");
        elements = elements.replace(")", "#");
        elements = elements.replace("\"", "");
        String[] kraji = elements.split("#");

        for (String i : kraji) {
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
                editKraji editkraji = new editKraji(conn, list1.getSelectedValue().toString());
                dispose();
            }
        });

        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editKraji editkraji = new editKraji(conn,"Nov kraj");
                dispose();
            }
        });
    }
}
