package com.example.aplikacija;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;


public class mainFrame extends JFrame{
    private JTextField tfPriimek;
    private JTextField tfIme;
    private JButton btnSpremeni;
    private JPanel mainPanel;
    private JTextField tfOddelek;
    private JButton btnClear;

    public mainFrame() {
        setContentPane(mainPanel);
        setTitle("Zaposleni");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        DbFunctions db= new DbFunctions();
        Connection conn=db.connect_to_db();

        btnSpremeni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String priimek = tfPriimek.getText();
                String ime = tfIme.getText();
                String oddelek = tfOddelek.getText();
                if (priimek.isEmpty()==false && ime.isEmpty()==false && oddelek.isEmpty()==false){
                    db.spremeni_oddelek_zaposlenemu(conn, priimek, ime, oddelek);
                    System.out.println("Oddelek spremenjen");
                }else{
                    System.out.println("Oddelek ni spremenjen");
                    JOptionPane.showMessageDialog(null, "Vnesite vrednosti");
                }

            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfOddelek.setText("");
                tfIme.setText("");
                tfPriimek.setText("");
            }
        });

        db.read_data(conn, "zaposleni");
    }
}
