package com.example.OGKeys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseCreation {

    public static void createDatabase (){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ogkeys",
                    "root","root");
            con.close();

        }catch (Exception e){
            try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/",
                        "root", "root");
                Statement statement = con.createStatement();
                statement.execute("CREATE DATABASE ogkeys");
                con.close();

            }catch (Exception i){
                System.out.println(i);
            }

        }
    }
}
