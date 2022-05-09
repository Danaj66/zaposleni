package com.example.aplikacija;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class editFrame extends JFrame{
    private JTextField tfIme;
    private JTextField tfPriimek;
    private JTextField tfKraj_id;
    private JTextField tfDatum_rojstva;
    private JTextField tfTelefon;
    private JTextField tfMail;
    private JButton btnEdit;
    private JButton btnDelete;
    private JPanel mainPanel;
    private JTextField tfID;
    private JButton btnAdd;

    public editFrame(String info){
        setContentPane(mainPanel);
        setTitle(info);
        setSize(750, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        DbFunctions db= new DbFunctions();
        Connection conn=db.connect_to_db();

        tfID.setEnabled(false);
        if (info != "Nov uslužbenec")
        {
            String[] zaposlen = info.split(",");
            tfID.setText(zaposlen[0]);
            tfIme.setText(zaposlen[1]);
            tfPriimek.setText(zaposlen[2]);
            tfKraj_id.setText(zaposlen[3]);
            tfDatum_rojstva.setText(zaposlen[4]);
            tfTelefon.setText(zaposlen[5]);
            tfMail.setText(zaposlen[6]);
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
               db.uredi_zaposlenega(conn, tfID.getText(), tfIme.getText(), tfPriimek.getText(), tfKraj_id.getText(),
                        tfDatum_rojstva.getText() ,tfTelefon.getText(), tfMail.getText());


            }
        });
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                db.zbrisi_zaposlenega(conn, tfID.getText());
            }
        });
    }

}
