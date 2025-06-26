package com.mycompany.minimarketgg.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    static Connection con;
    
    public static Connection getConnection(){
        try {
            String myDB = "jdbc:mysql://localhost:3307/minimarketdb?serverTimezone=UTC";
            con = DriverManager.getConnection(myDB,"root","");
            return con;
        } catch(SQLException exception){
            System.out.println(exception.toString());
        }
            return null;
        }
}