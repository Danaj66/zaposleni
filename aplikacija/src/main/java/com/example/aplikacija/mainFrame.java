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
    private JComboBox cbZaposlen;
    private JComboBox cbOddelek;

    public mainFrame(Connection conn) {
        setContentPane(mainPanel);
        setTitle("Zaposleni");
        setSize(525, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        DbFunctions db= new DbFunctions();

        String elements_z = db.izpis_zaposlenih(conn);
        elements_z = elements_z.replace("(", "");
        elements_z = elements_z.replace(")", "#");
        elements_z = elements_z.replace("\"", "");
        String[] zaposleni = elements_z.split("#");

        System.out.println(zaposleni.length);
        for (int i=0; i <= zaposleni.length-1; i++)
        {
            cbZaposlen.addItem(zaposleni[i]);
        }

        String elements = db.izpis_oddelkov(conn);
        elements = elements.replace("(", "");
        elements = elements.replace(")", "#");
        elements = elements.replace("\"", "");
        String[] oddelki = elements.split("#");

        System.out.println(oddelki.length);
        for (int i=0; i <= oddelki.length-1; i++)
        {
            cbOddelek.addItem(oddelki[i]);
        }

        btnSpremeni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String oddelek = (String) cbOddelek.getSelectedItem();
                String zaposlen = (String) cbZaposlen.getSelectedItem();

                String[] id = oddelek.split(",");
                String od_id = id[0];

                id = zaposlen.split(",");
                String za_id = id[0];

                System.out.println("Oddelek ID: " +od_id + ", Zaposlen ID: " + za_id);
                db.spremeni_oddelek_zaposlenemu(conn, za_id, od_id);
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        db.read_data(conn, "zaposleni");
    }
}
