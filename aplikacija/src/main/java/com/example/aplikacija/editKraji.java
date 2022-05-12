package com.example.aplikacija;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class editKraji extends JFrame {

    private JPanel mainPanel;
    private JTextField tfID;
    private JButton btnEdit;
    private JButton btnDelete;
    private JTextField tfPostna_st;
    private JTextField tfNaziv;
    private JTextField tfVel_upor;
    private JButton btnAdd;

    public editKraji(Connection conn, String info) {
        setContentPane(mainPanel);
        setTitle(info);
        setSize(750, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        DbFunctions db = new DbFunctions();

        tfID.setEnabled(false);
        if (info != "Nov kraj")
        {
            String[] kraji = info.split(",");
            tfID.setText(kraji[0]);
            tfPostna_st.setText(kraji[1]);
            tfNaziv.setText(kraji[2]);
            tfVel_upor.setText(kraji[3]);
            btnAdd.setVisible(false);
        }
        else
        {
            btnEdit.setVisible(false);
            btnDelete.setVisible(false);
        }

        /*
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                db.uredi_zaposlenega(conn, tfID.getText(), tfIme.getText(), tfPriimek.getText(), tfKraj_id.getText(),
                        tfDatum_rojstva.getText() ,tfTelefon.getText(), tfMail.getText());
            }
        });

         */

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                db.dodaj_kraj(conn, tfPostna_st.getText(), tfNaziv.getText(), tfVel_upor.getText());
                displayKraji displayKraji = new displayKraji(conn);
                dispose();
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                db.zbrisi_kraj(conn, tfID.getText());
                displayKraji displayKraji = new displayKraji(conn);
                dispose();
            }
        });
    }
}
