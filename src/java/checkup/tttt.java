/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import model.connection;

/**
 *
 * @author MEBA
 */
public class tttt {
    public static void main(String ... args ){
        Calendar c = new GregorianCalendar();
            java.util.Date d = c.getTime();
        DateFormat df = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        //Date d=new Date();
        Instant instant = d.toInstant();
        ZoneId zoneID = ZoneId.systemDefault();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneID);
        LocalDate localDate = zdt.toLocalDate();
        String query;
        String studID[] ={"0021","0022","0023","0024"};
        Connection con=connection.connectDB();
        PreparedStatement ps;
        query="insert into advisor values(?,?,?,?) ";
        for(int k=0;k<studID.length;k++){
            try{
            ps=con.prepareStatement(query);  
                
            ps.setString(1, studID[k]);
            ps.setInt(2,0);
            ps.setString(3, "default");
            ps.setDate(4, (java.sql.Date.valueOf(localDate)));
            ps.execute();
            
   } catch (SQLException ex) {
           System.out.println(ex);
           ex.printStackTrace();
        }
            try{
// INSERT INRO CONTINUING EDUCATION

  query="insert into continuingeducation values(?,?,?,?) ";
            
            ps=con.prepareStatement(query);  
                
            ps.setString(1, studID[k]);
            ps.setInt(2,1);
            ps.setString(3, "default");
            ps.setDate(4, (java.sql.Date.valueOf(localDate)));
            ps.execute();
   } catch (SQLException ex) {
           System.out.println(ex);
           ex.printStackTrace();
        }
            try{
                
        // INSERT INTO CONTINUING EDUACTION BUSSINES AFFAIR   
                
              
         query="insert into continuingeducationBA values(?,?,?,?) ";
            
            ps=con.prepareStatement(query);  
                
            ps.setString(1, studID[k]);
            ps.setInt(2,1);
            ps.setString(3, "default");
            ps.setDate(4, (java.sql.Date.valueOf(localDate)));
            ps.execute();         
               
                   } catch (SQLException ex) {
           System.out.println(ex);
           ex.printStackTrace();
        }
            try{
         //       INSERT INTO DEAN  OF RPG 
         
           query="insert into deanofrpg values(?,?,?,?) ";
            
            ps=con.prepareStatement(query);  
                
            ps.setString(1, studID[k]);
            ps.setInt(2,1);
            ps.setString(3, "default");
            ps.setDate(4, (java.sql.Date.valueOf(localDate)));
            ps.execute(); 
         
           } catch (SQLException ex) {
           System.out.println(ex);
           ex.printStackTrace();
        }
            try{
            // INSERT INTO DEPARTMENT HEAD 
         
         
          query="insert into DEPARTMENTHEAD values(?,?,?,?) ";
            
            ps=con.prepareStatement(query);  
                
            ps.setString(1, studID[k]);
            ps.setInt(2,0);
            ps.setString(3, "default");
            ps.setDate(4, (java.sql.Date.valueOf(localDate)));
            ps.execute(); 
         
                
            
               } catch (SQLException ex) {
           System.out.println(ex);
           ex.printStackTrace();
        }
            try{
            
            // INSERT INTO FACULTY STORE 
            
            
           query="insert into FACULTYSTORE values(?,?,?,?) ";
            
            ps=con.prepareStatement(query);  
                
            ps.setString(1, studID[k]);
            ps.setInt(2,0);
            ps.setString(3, "default");
            ps.setDate(4, (java.sql.Date.valueOf(localDate)));
            ps.execute(); 
               } catch (SQLException ex) {
           System.out.println(ex);
           ex.printStackTrace();
        }
            try{
            // INSERT INTO HOUSING OFFICE
            
          query="insert into HOUSINGOFFICE values(?,?,?,?) ";
            
            ps=con.prepareStatement(query);  
                
            ps.setString(1, studID[k]);
            ps.setInt(2,1);
            ps.setString(3, "default");
            ps.setDate(4, (java.sql.Date.valueOf(localDate)));
            ps.execute(); 
            
             } catch (SQLException ex) {
           System.out.println(ex);
           ex.printStackTrace();
        }
            try{  
            
            // INSERT INTO LIBRARY 
            
                   query="insert into LIBRARY values(?,?,?,?) ";
            
            ps=con.prepareStatement(query);  
                
            ps.setString(1, studID[k]);
            ps.setInt(2,0);
            ps.setString(3, "default");
            ps.setDate(4, null);
            ps.execute(); 
            
              } catch (SQLException ex) {
           System.out.println(ex);
           ex.printStackTrace();
        }
            try{ 
            
            //  INSER INTO  REGISTRAR
          query="insert into REGISTRAR values(?,?,?,?) ";
            
            ps=con.prepareStatement(query);  
                
            ps.setString(1, studID[k]);
            ps.setInt(2,1);
            ps.setString(3, "default");
            ps.setDate(4, (java.sql.Date.valueOf(localDate)));
            ps.execute(); 
            
            
               } catch (SQLException ex) {
           System.out.println(ex);
           ex.printStackTrace();
        }
            try{
            
            // INSERT INTO SPORT MASTER 
         query="insert into SPORTMASTER values(?,?,?,?) ";
            
            ps=con.prepareStatement(query);  
                
            ps.setString(1, studID[k]);
            ps.setInt(2,0);
            ps.setString(3, "default");
            ps.setDate(4, (java.sql.Date.valueOf(localDate)));
            ps.execute(); 
            
            } catch (SQLException ex) {
           System.out.println(ex);
           ex.printStackTrace();
        }
            try{
            // INSERT INTO STUDENTS CAFE 
                   query="insert into STUDENTSCAFE values(?,?,?,?,?) ";
            
            ps=con.prepareStatement(query);  
                
            ps.setString(1, studID[k]);
            ps.setInt(2,0);
            ps.setString(3, "default");
            ps.setDate(4, (java.sql.Date.valueOf(localDate)));
            ps.setInt(5, 0);
            ps.execute(); 
            
            
            
        } catch (SQLException ex) {
           System.out.println(ex);
           ex.printStackTrace();
        }
        
    }
}
}
