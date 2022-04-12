package com.example.aplikacija;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

public class displayData extends JFrame {
    private JPanel mainPanel;
    private JList list1;

    DefaultListModel listM = new DefaultListModel(){

    };

    public displayData(Integer x){
        setContentPane(mainPanel);
        setTitle("Zaposleni");
        setSize(750, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        DbFunctions db= new DbFunctions();
        Connection conn=db.connect_to_db();

        String elements = db.izpis_zaposlenih(conn);
        elements=elements.replace("(", "");
        elements=elements.replace(",", ", ");
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
                editFrame editframe = new editFrame(list1.getSelectedValue().toString());
            }
        });
    }
}
