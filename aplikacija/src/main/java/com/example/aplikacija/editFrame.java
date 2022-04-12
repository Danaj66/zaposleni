package com.example.aplikacija;

import javax.swing.*;
import java.sql.Connection;

public class editFrame extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton btnEdit;
    private JButton btnDelete;
    private JPanel mainPanel;
    private JTextField textField7;

    public editFrame(String info){
        setContentPane(mainPanel);
        setTitle(info);
        setSize(750, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        DbFunctions db= new DbFunctions();
        Connection conn=db.connect_to_db();
    }

}
