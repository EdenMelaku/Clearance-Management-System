/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.*;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;


import newServletAndModelClasses.finalApprove;
import otherService.outputobj;

/**
 *
 * @author MEBA
 */
public class UpdateClearance {

    public static void setCafeStatus(String id, int value, String username, int kk) throws NullPointerException, ClassNotFoundException, SQLException {
        int status = 1;

        Calendar c = new GregorianCalendar();
        java.util.Date d = c.getTime();
        java.util.Date ll = null;

        DateFormat df = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        //Date d=new Date();
        Instant instant = d.toInstant();
        ZoneId zoneID = ZoneId.systemDefault();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneID);
        LocalDate localDate = zdt.toLocalDate();
        Connection con = connection.connectDB();

        String sql = "{CALL setCafeStatus(?,?,?,?)}";

        CallableStatement cs = con.prepareCall(sql);
        cs.setString(1, id);
        cs.setInt(2, value);
        cs.setString(4, username);
        cs.setDate(3, (java.sql.Date.valueOf(localDate)));

        cs.executeUpdate();
        // private String id;firstName; lastname; department; program; int year;
        if (kk != 1) {
            finalApprove.setFinalStatus(id);
        }

        con.close();

    }

    public static void sethousingOfficeStatus(String id, int value, String username, int kk) throws NullPointerException, ClassNotFoundException, SQLException {

        Calendar c = new GregorianCalendar();
        java.util.Date d = c.getTime();
        java.util.Date ll = null;

        DateFormat df = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        //Date d=new Date();
        Instant instant = d.toInstant();
        ZoneId zoneID = ZoneId.systemDefault();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneID);
        LocalDate localDate = zdt.toLocalDate();

        Connection con = connection.connectDB();

        String sql = "{CALL SETHOUSINGOFFICESTATUS(?,?,?,?)}";

        CallableStatement cs = con.prepareCall(sql);

        cs.setString(1, id);
        cs.setInt(2, value);
        cs.setString(4, username);
        cs.setDate(3, (java.sql.Date.valueOf(localDate)));

        cs.executeUpdate();
        if (kk != 1) {
            finalApprove.setFinalStatus(id);
        }
        // private String id;firstName; lastname; department; program; int year;
        con.close();
    }

    public static void setSportMasterStatus(String id, int value, String username, int kk) throws NullPointerException, ClassNotFoundException, SQLException {
        Calendar c = new GregorianCalendar();
        java.util.Date d = c.getTime();
        java.util.Date ll = null;

        DateFormat df = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        //Date d=new Date();
        Instant instant = d.toInstant();
        ZoneId zoneID = ZoneId.systemDefault();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneID);
        LocalDate localDate = zdt.toLocalDate();

        Connection con = connection.connectDB();

        String sql = "{CALL setSportMasterStatus(?,?,?,?)}";

        CallableStatement cs = con.prepareCall(sql);

        cs.setString(1, id);
        cs.setInt(2, value);
        cs.setString(4, username);
        cs.setDate(3, (java.sql.Date.valueOf(localDate)));

        cs.executeUpdate();
        if (kk != 1) {
            finalApprove.setFinalStatus(id);
        }
        // private String id;firstName; lastname; department; program; int year;
        con.close();
    }

    public static void setLibraryStatus(String id, int value, String username, int kk) throws NullPointerException, ClassNotFoundException, SQLException {

        outputobj.joption("in the set library status method for id=  " + id);
        Calendar c = new GregorianCalendar();
        java.util.Date d = c.getTime();
        java.util.Date ll = null;

        DateFormat df = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        //Date d=new Date();
        Instant instant = d.toInstant();
        ZoneId zoneID = ZoneId.systemDefault();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneID);
        LocalDate localDate = zdt.toLocalDate();

        Connection con = connection.connectDB();

        String sql = "{CALL SETLIBRARYSTATUS(?,?,?,?)}";

        CallableStatement cs = con.prepareCall(sql);

        cs.setString(1, id);
        cs.setInt(2, value);
        cs.setString(4, username);
        cs.setDate(3, (java.sql.Date.valueOf(localDate)));

        cs.executeUpdate();
        outputobj.joption("the execute update method called  ");
        // private String id;firstName; lastname; department; program; int year;
        if (kk != 1) {
            finalApprove.setFinalStatus(id);
        }
        con.close();
    }

    public static void setFacultyStoreStatus(String id, int value, String username, int kk) throws NullPointerException, ClassNotFoundException, SQLException {
        Calendar c = new GregorianCalendar();
        java.util.Date d = c.getTime();
        java.util.Date ll = null;

        DateFormat df = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        //Date d=new Date();
        Instant instant = d.toInstant();
        ZoneId zoneID = ZoneId.systemDefault();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneID);
        LocalDate localDate = zdt.toLocalDate();

        Connection con = connection.connectDB();

        String sql = "{CALL setFacultyStoreStatus(?,?,?,?)}";

        CallableStatement cs = con.prepareCall(sql);

        cs.setString(1, id);
        cs.setInt(2, value);
        cs.setString(4, username);
        cs.setDate(3, (java.sql.Date.valueOf(localDate)));

        cs.executeUpdate();
        // private String id;firstName; lastname; department; program; int year;
        if (kk != 1) {
            finalApprove.setFinalStatus(id);
        }
        con.close();
    }

    public static void setRegistrarStatus(String id, int value, String username, int kk) throws NullPointerException, ClassNotFoundException, SQLException {
        Calendar c = new GregorianCalendar();
        java.util.Date d = c.getTime();
        java.util.Date ll = null;

        DateFormat df = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        //Date d=new Date();
        Instant instant = d.toInstant();
        ZoneId zoneID = ZoneId.systemDefault();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneID);
        LocalDate localDate = zdt.toLocalDate();

        Connection con = connection.connectDB();

        String sql = "{CALL setRegistrarStatus(?,?,?,?)}";

        CallableStatement cs = con.prepareCall(sql);

        cs.setString(1, id);
        cs.setInt(2, value);
        cs.setString(4, username);
        cs.setDate(3, (java.sql.Date.valueOf(localDate)));

        cs.executeUpdate();
        // private String id;firstName; lastname; department; program; int year;

        if (kk != 1) {
            finalApprove.setFinalStatus(id);
        }
        con.close();
    }

    public static void setDeanOFRPGStatus(String id, int value, String username, int kk) throws NullPointerException, ClassNotFoundException, SQLException {
        Calendar c = new GregorianCalendar();
        java.util.Date d = c.getTime();
        java.util.Date ll = null;

        DateFormat df = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        //Date d=new Date();
        Instant instant = d.toInstant();
        ZoneId zoneID = ZoneId.systemDefault();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneID);
        LocalDate localDate = zdt.toLocalDate();

        Connection con = connection.connectDB();

        String sql = "{CALL setDeanOFRPGStatus(?,?,?,?)}";

        CallableStatement cs = con.prepareCall(sql);

        cs.setString(1, id);
        cs.setInt(2, value);
        cs.setString(4, username);
        cs.setDate(3, (java.sql.Date.valueOf(localDate)));

        cs.executeUpdate();
        // private String id;firstName; lastname; department; program; int year;

        if (kk != 1) {
            finalApprove.setFinalStatus(id);
        }
        con.close();
    }

    public static void setContinuingEducationBAStatus(String id, int value, String username, int kk) throws NullPointerException, ClassNotFoundException, SQLException {
        Calendar c = new GregorianCalendar();
        java.util.Date d = c.getTime();
        java.util.Date ll = null;

        DateFormat df = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        //Date d=new Date();
        Instant instant = d.toInstant();
        ZoneId zoneID = ZoneId.systemDefault();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneID);
        LocalDate localDate = zdt.toLocalDate();

        Connection con = connection.connectDB();

        String sql = "{CALL setContinuingEducationBAStatus(?,?,?,?)}";

        CallableStatement cs = con.prepareCall(sql);

        cs.setString(1, id);
        cs.setInt(2, value);
        cs.setString(4, username);
        cs.setDate(3, (java.sql.Date.valueOf(localDate)));

        cs.executeUpdate();
        // private String id;firstName; lastname; department; program; int year;

        if (kk != 1) {
            finalApprove.setFinalStatus(id);
        }
        con.close();
    }

    public static void setContinuingEducationStatus(String id, int value, String username, int kk) throws NullPointerException, ClassNotFoundException, SQLException {
        Calendar c = new GregorianCalendar();
        java.util.Date d = c.getTime();
        java.util.Date ll = null;

        DateFormat df = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        //Date d=new Date();
        Instant instant = d.toInstant();
        ZoneId zoneID = ZoneId.systemDefault();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneID);
        LocalDate localDate = zdt.toLocalDate();

        Connection con = connection.connectDB();

        String sql = "{CALL setContinuingEducationStatus(?,?,?,?)}";

        CallableStatement cs = con.prepareCall(sql);

        cs.setString(1, id);
        cs.setInt(2, value);
        cs.setString(4, username);
        cs.setDate(3, (java.sql.Date.valueOf(localDate)));

        cs.executeUpdate();
        // private String id;firstName; lastname; department; program; int year;

        if (kk != 1) {
            finalApprove.setFinalStatus(id);
        }
        con.close();
    }

    public static void setAdvisorStatus(String id, int value, String username, int kk) throws NullPointerException, ClassNotFoundException, SQLException {
//JOptionPane.showMessageDialog(null, "setting advisor status ");
        Calendar c = new GregorianCalendar();
        java.util.Date d = c.getTime();
        java.util.Date ll = null;

        DateFormat df = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        //Date d=new Date();
        Instant instant = d.toInstant();
        ZoneId zoneID = ZoneId.systemDefault();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneID);
        LocalDate localDate = zdt.toLocalDate();

        Connection con = connection.connectDB();

        String sql = "{CALL setAdvisorStatus(?,?,?,?)}";

        CallableStatement cs = con.prepareCall(sql);

        cs.setString(1, id);
        cs.setInt(2, value);
        cs.setString(4, username);
        cs.setDate(3, (java.sql.Date.valueOf(localDate)));

        cs.executeUpdate();
        // private String id;firstName; lastname; department; program; int year;
        if (kk != 1) {
            finalApprove.setFinalStatus(id);
        }
        con.close();
    }

    public static void setDepartmentHeadStatus(String id, int value, String username, int kk) throws NullPointerException, ClassNotFoundException, SQLException {

        Calendar c = new GregorianCalendar();
        java.util.Date d = c.getTime();
        java.util.Date ll = null;

        DateFormat df = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
        //Date d=new Date();
        Instant instant = d.toInstant();
        ZoneId zoneID = ZoneId.systemDefault();
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneID);
        LocalDate localDate = zdt.toLocalDate();

        Connection con = connection.connectDB();

        String sql = "{CALL setDepartmentHeadStatus(?,?,?,?)}";

        CallableStatement cs = con.prepareCall(sql);

        cs.setString(1, id);
        cs.setInt(2, value);
        cs.setString(4, username);
        cs.setDate(3, (java.sql.Date.valueOf(localDate)));

        cs.execute();

        // private String id;firstName; lastname; department; program; int year;
        if (kk != 1) {
            finalApprove.setFinalStatus(id);
        }
        con.close();
    }

    public static void main(String... jn) {
String fr[]={"oo13", "oo14","oo15","oo16","oo11","oo9","oo5","oo7"};
        try {
            for(int i=0;i<fr.length;i++){
            UpdateClearance.sethousingOfficeStatus(fr[i], 0, "bini@gmail.com", 0);
            System.out.println("done for  "+fr[i]);
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
