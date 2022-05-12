package com.example.aplikacija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFunctions {

    public Connection connect_to_db(){

        Connection conn=null;

        try {
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://tyke.db.elephantsql.com/"+"gvoskozc", "gvoskozc", "cT8IIQPBvgYA0SuxelOpso8DwyETD0hL");

            if(conn!=null){
                System.out.println("Connection established");
            }else{
                System.out.println("Connection failed");
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return conn;
    }

    public void spremeni_oddelek_zaposlenemu(Connection conn, String priimek, String ime, String oddelek){
        Statement statement;
        try {
            String query="SELECT spremeni_oddelek_zaposlenemu('"+priimek+"', '" + ime + "', '" + oddelek + "');";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Oddelek spremenjen");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public String izpis_uporabnikov(Connection conn){
        Statement statement;
        ResultSet rs=null;
        String s = "";
        try {
            String query="SELECT preberi_uporabnike();";
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next()){
                s=s+rs.getString(1);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(s);
        return s;
    }

    public String izpis_zaposlenih(Connection conn){
        Statement statement;
        ResultSet rs=null;
        String s = "";
        try {
            String query="SELECT preberi_zaposlene();";
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next()){
                s=s+rs.getString(1);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println(s);
        return s;
    }

    public void read_data(Connection conn, String table_name){
        Statement statement;
        ResultSet rs=null;
        String s = null;
        int i = 1;
        try {
            String query="SELECT * FROM " + table_name +";";
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while (rs.next()){
                s=s+rs.getString(i);
                i++;
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public int prijava(Connection conn, String username, String password){
        Statement statement;
        ResultSet rs=null;
        int x = 0;
        try {
            String query="SELECT prijava('"+username+"', '" + password + "');";
            System.out.println("1");
            statement=conn.createStatement();
            System.out.println("2");
            rs = statement.executeQuery(query);
            while (rs.next()){
                x = rs.getInt(1);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return x;
    }

    public void uredi_zaposlenega(Connection conn, String id, String ime, String priimek, String kraj, String datum_r, String telefon, String mail){
        Statement statement;
        try {
            String query="SELECT uredi(" +id + ", '"+ime+"', '" + priimek + "', " + kraj + ", '"+datum_r+"', '"+telefon+"', '"+mail+"');";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Zaposleni urejen");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public int dodaj_uporabnika(Connection conn, String username, String password){
        Statement statement;
        ResultSet rs=null;
        int x = 0;
        try {
            String query="SELECT registracija('"+username+"', '" + password + "');";
            statement=conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()){
                x = rs.getInt(1);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return x;
    }

    public void zbrisi_zaposlenega(Connection conn, String id){
        Statement statement;
        try {
            String query="SELECT delete_user(" +id + ");";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Zaposleni izbrisan");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public int dodaj_zaposlenega(Connection conn, String ime, String priimek, String kraj, String datum_r, String telefon, String mail){
        Statement statement;
        ResultSet rs=null;
        int x = 0;
        try {
            String query="SELECT  dodaj_zaposlenega('"+ime+"', '"+priimek+"', "+kraj+", '"+datum_r+"', '"+telefon+"', '"+mail+"');";
            statement=conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()){
                x = rs.getInt(1);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return x;
    }
}
