/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import clearance_management.user;
import java.sql.*;

/**
 *
 * @author Bit
 */
public class connection {

    static Connection con = null;

    public static Connection connectDB() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "roba");
            //  con = DriverManager.getConnection("jdbc.databaseurl=jdbc:oracle:thin:@localhost:1521/xe", "system", "roba");
            System.out.println("connected");
        } catch (Exception e) {
            System.out.println("not connected ");
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String... args) throws ClassNotFoundException, SQLException {
   
       connection.connectDB();

   user su = read.getAUser("abebe@gmail.com");
System.out.println(su.getFirstName()+" "+su.getFirstName());
        }
}
