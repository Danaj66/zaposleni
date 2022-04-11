package com.example.aplikacija;
import java.sql.Connection;
import java.sql.DriverManager;
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
}
