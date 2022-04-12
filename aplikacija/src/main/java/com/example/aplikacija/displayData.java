package com.example.aplikacija;

import javax.swing.*;
import java.sql.Connection;

public class displayData extends JFrame {
    private JLabel lbName;
    private JPanel mainPanel;

    public displayData(Integer x){
        setContentPane(mainPanel);
        setTitle("Izpis");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        DbFunctions db= new DbFunctions();
        Connection conn=db.connect_to_db();

        //lbName =
    }
}
